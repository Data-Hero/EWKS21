import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {UserDto} from "../dtos/user-dto";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  getUsers(): Observable<any> {
    return this.http.get("http://localhost:8083/userservice/user");
  }

  getUserById(id: number): Observable<any> {
    return this.http.get("http://localhost:8083/userservice/user/" + id);
  }

  saveUser(user: UserDto) {
    console.log(user);

    this.http.post("http://localhost:8083/userservice/user", user);
  }
}
