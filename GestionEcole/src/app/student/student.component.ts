import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {StudentService} from './student.service';
import {TableModule} from 'primeng/table';
import {DialogModule} from 'primeng/dialog';
import {ToastModule} from 'primeng/toast';
import {MessageService} from 'primeng/api';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Student} from './models/student.model';

@Component({
  selector: 'app-user',
  templateUrl: './student.component.html',
  styles: []
})
export class StudentComponent implements OnInit {
  displayDialog: boolean;
  userForm: FormGroup;
  users: Student[];
  selectedUser: Student;
  cols: any;
  newUser: boolean;
  user: Student;
  hideFilter: boolean = false;
  public userFormId = 'userForm';

  constructor(
    private router: Router,
    private userService: StudentService,
    private messageService: MessageService,
    private formBuilder: FormBuilder
  ) {
    this.createUserEditForm();
  }

  private createUserEditForm(): void {
    this.userForm = this.formBuilder.group({
      id: [''],
      firstname: [''],
      lastname: [''],
      email: ['']
    });
  }

  ngOnInit() {
    this.getUsers();
    this.cols = [
      {field: 'id', header: 'ID'},
      {field: 'prenom', header: 'Prénom'},
      {field: 'nom', header: 'Nom'},
      {field: 'email', header: 'Email'}];
  }

  deleteUser(user: Student): void {
    this.userService.deleteUser(user)
      .subscribe(() => {
        this.messageService.add({severity: 'success', summary: '', detail: 'Utilisateur supprimé'});
        this.getUsers();
      });
  }

  createUser(user: Student): void {
    this.userService.createUser(user)
      .subscribe(() => {
        this.messageService.add({severity: 'success', summary: '', detail: 'Utilisateur ajouté'});
        this.getUsers();
      }, () => {
        this.messageService.add({severity: 'error', summary: '', detail: 'Erreur lors de l\'ajout'});
      })
    ;
  }

  updateUser(user: Student): void {
    this.userService.updateUser(user).subscribe(() => {
      this.messageService.add({severity: 'success', summary: '', detail: 'Utilisateur mis à jour'});
      this.getUsers();
    }, () => {
      this.messageService.add({severity: 'error', summary: '', detail: 'Utilisateur non mis à jour'});
    });
  }

  updateUserEditForm() {
    this.userForm.get('id').setValue(this.selectedUser.idEleve);
    this.userForm.get('firstname').setValue(this.selectedUser.prenom);
    this.userForm.get('lastname').setValue(this.selectedUser.nom);
    this.userForm.get('email').setValue(this.selectedUser.email);
  }

  private getUsers(): void {
    this.userService.getUsers()
      .subscribe(data => {
        this.users = data;
      });
  }

  showDialogToAdd() {
    this.newUser = true;
    this.user = new Student();
    this.displayDialog = true;
  }

  save() {
    if (this.newUser) {
      this.assignFormValues(this.user);
      this.createUser(this.user);
      this.user = null;
    } else {
      console.log('hello');
      this.assignFormValues(this.selectedUser);
      this.updateUser(this.selectedUser);
      this.selectedUser = null;
    }
    this.displayDialog = false;
  }

  delete() {
    this.deleteUser(this.selectedUser);
    this.displayDialog = false;
  }

  onRowSelect() {
    this.updateUserEditForm();
    this.displayDialog = true;
  }

  onSubmit() {
    this.save();
    this.resetUserForm();
  }

  public resetUserForm(): void {
    this.userForm.reset();
  }

  private assignFormValues(user: Student): void {
    user.prenom = this.userForm.get('firstname').value;
    user.nom = this.userForm.get('lastname').value;
    user.email = this.userForm.get('email').value;
  }

  onSearch() {
    this.hideFilter = !this.hideFilter;
  }
}


