import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Student} from './models/student.model';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class StudentService {

  constructor(private http: HttpClient) {}

  private userUrl = 'http://localhost:8080/apiGestionEcole/users';
  // private userUrl = '/api';

  public getUsers() {
    return this.http.get<Student[]>(this.userUrl);
  }

  public deleteUser(user) {
    return this.http.delete(this.userUrl + '/' + user.id);
  }

  public createUser(user) {
    return this.http.post<Student>(this.userUrl, user);
  }

  public updateUser(user) {
    return this.http.put<Student>(this.userUrl + '/' + user.id, user);
  }

}
