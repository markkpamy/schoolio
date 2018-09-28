import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentsRoutingModule } from './students-routing.module';
import {StudentListComponent} from './student-list/student-list.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TableModule} from 'primeng/table';
import {DialogModule} from 'primeng/dialog';
import {ButtonModule, InputTextModule, MessageService} from 'primeng/primeng';
import {ToastModule} from 'primeng/toast';
import {StudentService} from './student.service';

@NgModule({
  imports: [
    CommonModule,
    StudentsRoutingModule,
    HttpClientModule,
    FormsModule,
    TableModule,
    DialogModule,
    InputTextModule,
    ButtonModule,
    ToastModule,
    ReactiveFormsModule
  ],
  declarations: [
    StudentListComponent
  ],
  providers: [ StudentService, MessageService]
})
export class StudentsModule { }
