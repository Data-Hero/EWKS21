import { Component, OnInit } from '@angular/core';
import {UserService} from "../service/user.service";
import {UserDto} from "../dtos/user-dto";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: UserDto[] = [];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers() {
    this.userService.getUsers().subscribe(users => this.users = users);
  }
}
