package de.joergiso.isomaticbooking.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @OneToOne
  private FunctionBundle functionBundle;

  @Column(nullable = false)
  private LocalDateTime startTime;

  @Column(nullable = false)
  private LocalDateTime endTime;

  @OneToOne
  private User user;

  @OneToOne
  private Device device;

  public Booking() {
  }

  public int getId() {
    return id;
  }

  public FunctionBundle getFunctionBundle() {
    return functionBundle;
  }

  public void setFunctionBundle(FunctionBundle functionBundle) {
    this.functionBundle = functionBundle;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Device getDevice() {
    return device;
  }

  public void setDevice(Device device) {
    this.device = device;
  }

  @Override
  public String toString() {
    return "Booking{" +
        "id=" + id +
        ", functionBundle=" + functionBundle +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", user=" + user +
        ", device=" + device +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Booking booking = (Booking) o;
    return id == booking.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
