export class UserDto {
  id: number = 0;
  name: string = '';
  bookings?: [];
  devices?: [];

  public UserDto(id: number, name: string, bookings: [], devices: []) {
    this.id = id;
    this.name = name;
    this.bookings = bookings;
    this.devices = devices;
  }
}
