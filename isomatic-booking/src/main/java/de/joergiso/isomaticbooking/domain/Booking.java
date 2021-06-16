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

  public FunctionBundle getFunctionBundle() {
    return functionBundle;
  }

  public void setFunctionBundle(FunctionBundle functionBundle) {
    this.functionBundle = functionBundle;
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
