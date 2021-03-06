import {Component, OnInit} from '@angular/core';
import {UserControllerService} from "../service/user-controller.service";
import {User} from "../dtos/user";
import {DeviceDto} from "../dtos/device-dto";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[] = [];

  selectedUserId: number = 0;
  selectedUser: User = {};

  serialNumber: string = '';

  userToBeSaved: User = {};
  userToBeUpdated: User = {};

  deviceDto: DeviceDto = {};


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
    this.userService.createUser(user).subscribe(e => console.log("saved user: " + e));
  }

  registerDevice(deviceDto: DeviceDto) {
    this.userService.registerDevice(this.userToBeUpdated.id || 1, deviceDto).subscribe(e=> console.log("eeee" + e));
  }

  updateUser(user: User) {
    this.userService.updateUser(user).subscribe(e => console.log("updated user: " + e));
  }
}
