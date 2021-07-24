import {Injectable} from '@angular/core';
import {Observable, of} from "rxjs";
import {UserDto} from "../dtos/user-dto";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() {
  }

  getUsers(): Observable<UserDto[]> {
    let users: UserDto[] = [];

    fetch("http://localhost:8083/userservice/user", {
      method: "get",
      headers: {
        "Content-Type": "application/json"
      }
    })
      .then((response) => response.json())
      .then((json) => (users = json));

    return of(users);
  }
}
