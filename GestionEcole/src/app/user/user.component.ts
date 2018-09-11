import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {User} from '../models/user.model';
import {UserService} from './user.service';
import {TableModule} from 'primeng/table';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styles: []
})
export class UserComponent implements OnInit {

  users: User[];
  cols: any;

  constructor(private router: Router, private userService: UserService) {

  }

  ngOnInit() {
    this.userService.getUsers()
      .subscribe(data => {
        this.users = data;
      });
    this.cols = [
      {field: 'id', header: 'ID'},
      {field: 'email', header: 'Email'},
      {field: 'firstName', header: 'Prénom'},
      {field: 'lastName', header: 'Nom'}];
  }

  deleteUser(user: User): void {
    this.userService.deleteUser(user)
      .subscribe(data => {
        this.users = this.users.filter(u => u !== user);
      });
  }

}


