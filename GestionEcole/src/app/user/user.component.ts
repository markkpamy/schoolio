import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {UserService} from './user.service';
import {TableModule} from 'primeng/table';
import {DialogModule} from 'primeng/dialog';
import {ToastModule} from 'primeng/toast';
import {MessageService} from 'primeng/api';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {User} from './models/user.model';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styles: []
})
export class UserComponent implements OnInit {
  displayDialog: boolean;
  userForm: FormGroup;
  users: User[];
  selectedUser: User;
  cols: any;
  newUser: boolean;
  user: User;
  public userFormId = 'userForm';

  constructor(
    private router: Router,
    private userService: UserService,
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
      {field: 'firstName', header: 'Prénom'},
      {field: 'lastName', header: 'Nom'},
      {field: 'email', header: 'Email'}];
  }

  deleteUser(user: User): void {
    this.userService.deleteUser(user)
      .subscribe(() => {
        this.messageService.add({severity: 'success', summary: '', detail: 'Utilisateur supprimé'});
        this.getUsers();
      });
  }

  createUser(user: User): void {
    this.userService.createUser(user)
      .subscribe(() => {
        this.messageService.add({severity: 'success', summary: '', detail: 'Utilisateur ajouté'});
        this.getUsers();
      }, () => {
        this.messageService.add({severity: 'error', summary: '', detail: 'Erreur lors de l\'ajout'});
      })
    ;
  }

  updateUser(user: User): void {
    this.userService.updateUser(user).subscribe(() => {
      this.messageService.add({severity: 'success', summary: '', detail: 'Utilisateur mis à jour'});
      this.getUsers();
    }, () => {
      this.messageService.add({severity: 'error', summary: '', detail: 'Utilisateur non mis à jour'});
    });
  }

  updateUserEditForm() {
    this.userForm.get('id').setValue(this.selectedUser.id);
    this.userForm.get('firstname').setValue(this.selectedUser.firstName);
    this.userForm.get('lastname').setValue(this.selectedUser.lastName);
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
    this.user = new User();
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

  private assignFormValues(user: User): void {
    user.firstName = this.userForm.get('firstname').value;
    user.lastName = this.userForm.get('lastname').value;
    user.email = this.userForm.get('email').value;
  }

}


