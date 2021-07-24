import {Component, OnInit} from '@angular/core';
import {UserService} from "../service/user.service";
import {UserDto} from "../dtos/user-dto";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: UserDto[] = [];

  constructor(private userService: UserService) {
    this.getUsers();
  }

  ngOnInit(): void {

  }

  getUsers() {
    this.userService.getUsers().subscribe(e => this.users = e);
  }
}
