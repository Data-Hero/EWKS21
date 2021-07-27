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

  selectedUserId: number = 0;
  selectedUser: User = {};

  userToBeSaved: User = {};
  userToBeUpdated: User = {};



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
    user.bookings = new Set();
    user.devices = new Set();

    this.userService.createUser(user).subscribe(e => console.log("saved user: " + e));
  }

  updateUser(user: User) {
    this.userService.updateUser(user).subscribe(e => console.log("updated user: " + e));
  }
}
