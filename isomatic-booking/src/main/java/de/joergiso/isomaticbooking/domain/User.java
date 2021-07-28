package de.joergiso.isomaticbooking.domain;

import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String name;

  @OneToMany
  private Set<Booking> bookings;

  @ManyToMany(cascade=CascadeType.ALL)
  private Set<Device> devices;

  public User() {}

  public Set<Booking> getBookings() {
    return bookings;
  }

  public void setBookings(Set<Booking> bookings) {
    this.bookings = bookings;
  }

  public Set<Device> getDevices() {
    return devices;
  }

  public void setDevices(Set<Device> devices) {
    this.devices = devices;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", bookings=" + bookings +
        ", devices=" + devices +
        '}';
  }
}
