import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Student} from './models/student.model';
import {PageRequest} from '../../models/page-request.model';
import {PageResponse} from '../../models/page-response.model';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class StudentService {

  constructor(private http: HttpClient) {}

  private userUrl = 'http://localhost:8080/apiGestionEcole/students';
  // private userUrl = '/api';

  public getUsers(pagerequest: PageRequest) {
    return this.http.post<PageResponse<Student>>(this.userUrl.concat('/getstudents'), pagerequest);
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
