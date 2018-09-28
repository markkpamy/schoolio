import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentsRoutingModule } from './students-routing.module';
import {StudentComponent} from './student/student.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TableModule} from 'primeng/table';
import {DialogModule} from 'primeng/dialog';
import {ButtonModule, InputTextModule, MessageService} from 'primeng/primeng';
import {ToastModule} from 'primeng/toast';
import {StudentService} from './student/student.service';

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
    StudentComponent
  ],
  providers: [ StudentService, MessageService]
})
export class StudentsModule { }
