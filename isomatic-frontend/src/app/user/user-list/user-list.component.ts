import {Component, OnInit} from '@angular/core';
import {UserControllerService} from "../service/user-controller.service";
import {User} from "../dtos/user";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[] = [];

  selectedUser: User = {};

  constructor(private userService: UserControllerService) {
    this.getUsers();
  }

  ngOnInit(): void {

  }

  getUsers() {
    this.userService.getAll().subscribe(e => this.users = e);
  }

  getUserById(id: number) {
    this.userService.getUserById(id).subscribe(user => this.selectedUser = user);
  }

  saveUser(user: User) {
    this.userService.createUser(user);
  }
}
