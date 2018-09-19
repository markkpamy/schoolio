import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {StudentService} from './student.service';
import {LazyLoadEvent, MessageService} from 'primeng/api';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Student} from './models/student.model';
import {PageRequest} from '../models/page-request.model';
import {Filter} from '../models/filter.model';
import {Sort} from '../models/sort.model';
import {Direction} from '../enums/direction.enum';

@Component({
  selector: 'app-user',
  templateUrl: './student.component.html',
  styles: []
})
export class StudentComponent implements OnInit {
  displayDialog: boolean;
  studentForm: FormGroup;
  students: Student[];
  selectedUser: Student;
  cols: any;
  newStudent: boolean;
  student: Student;
  hideFilter: boolean = false;
  public studentFormId = 'studentForm';
  loading: boolean;
  filters: Filter[] = [];
  sort: Sort;
  pageRequest: PageRequest;
  totalRecords: number; // number of all account transactions that correspond to the filter

  constructor(
    private router: Router,
    private studentService: StudentService,
    private messageService: MessageService,
    private formBuilder: FormBuilder
  ) {
    this.createUserEditForm();
  }

  private createUserEditForm(): void {
    this.studentForm = this.formBuilder.group({
      id: [''],
      prenom: [''],
      nom: [''],
      email: ['']
    });
  }

  ngOnInit() {
    this.loading = true;
    this.cols = [
      {field: 'id_eleve', header: 'ID'},
      {field: 'prenom', header: 'Prénom'},
      {field: 'nom', header: 'Nom'},
      {field: 'lieu_naissance', header: 'Lieu de naissance'},
      {field: 'date_naissance', header: 'Date de naissance'},
      {field: 'telephone', header: 'Telephone'},
      {field: 'classe', header: 'Classe'},
      {field: 'email', header: 'Email'}];
  }

  deleteUser(user: Student): void {
    this.studentService.deleteUser(user)
      .subscribe(() => {
        this.messageService.add({severity: 'success', summary: '', detail: 'Utilisateur supprimé'});
        this.getUsers();
      }, () => {
        this.messageService.add({severity: 'error', summary: '', detail: 'Erreur lors de la suppression'});
      });
  }

  createUser(user: Student): void {
    this.studentService.createUser(user)
      .subscribe(() => {
        this.messageService.add({severity: 'success', summary: '', detail: 'Utilisateur ajouté'});
        this.getUsers();
      }, () => {
        this.messageService.add({severity: 'error', summary: '', detail: 'Erreur lors de l\'ajout'});
      })
    ;
  }

  updateUser(user: Student): void {
    this.studentService.updateUser(user).subscribe(() => {
      this.messageService.add({severity: 'success', summary: '', detail: 'Utilisateur mis à jour'});
      this.getUsers();
    }, () => {
      this.messageService.add({severity: 'error', summary: '', detail: 'Utilisateur non mis à jour'});
    });
  }

  updateUserEditForm() {
    this.studentForm.get('id').setValue(this.selectedUser.id_eleve);
    this.studentForm.get('prenom').setValue(this.selectedUser.prenom);
    this.studentForm.get('nom').setValue(this.selectedUser.nom);
    this.studentForm.get('email').setValue(this.selectedUser.email);
  }

  private getUsers(): void {
    this.studentService.getUsers(this.pageRequest)
      .subscribe(pageResponse => {
        this.loading = false;
        this.students = pageResponse.results;
        this.totalRecords = pageResponse.totalElements;
        // this.messageService.add({severity: 'success', summary: '', detail: 'Liste récupérée avec succès'});
      }, () => {
        this.loading = false;
        this.messageService.add({severity: 'error', summary: '', detail: 'Liste non récupérée'});
      });
  }

  showDialogToAdd() {
    this.newStudent = true;
    this.student = new Student();
    this.displayDialog = true;
  }

  save() {
    if (this.newStudent) {
      this.assignFormValues(this.student);
      this.createUser(this.student);
      this.student = null;
    } else {
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
    this.studentForm.reset();
  }

  private assignFormValues(user: Student): void {
    user.prenom = this.studentForm.get('prenom').value;
    user.nom = this.studentForm.get('nom').value;
    user.email = this.studentForm.get('email').value;
  }

  onSearch() {
    this.hideFilter = !this.hideFilter;
  }

  loadStudentLazy(event: LazyLoadEvent) {
    this.loading = true;
    this.getFilters(event.filters);
    this.pageRequest =
      new PageRequest((event.first / event.rows),
        event.rows,
        this.filters,
        this.getSortDirection(event.sortOrder),
        event.sortField);
    this.getUsers();
  }

  getSortDirection(sort: number): Direction {
    return (sort === 1 ) ? Direction.Up : Direction.Down;
  }

  getFilters(filters: any): void {
    this.filters = [];
    for (const filter in filters) {
      if (filters.hasOwnProperty(filter)) {
        const tableFilter: any = filters[filter];
        const tableFIlterValue: string[] = tableFilter ? tableFilter.value : null;
        if (tableFIlterValue !== null) {
          this.filters.push({key: filter, value: tableFIlterValue});
        }
      }
    }
    // TODO add debounce time to filter
  }
}


