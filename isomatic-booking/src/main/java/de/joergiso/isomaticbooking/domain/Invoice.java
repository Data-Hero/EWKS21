package de.joergiso.isomaticbooking.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @OneToOne
  private FunctionBundle functionBundle;

  @Enumerated(EnumType.STRING)
  private PaymentMethod paymentMethod;

  @OneToOne
  private Booking booking;

  @Column(nullable = false)
  private Double bill;

  public Invoice() { }

  public Invoice(FunctionBundle functionBundle, PaymentMethod paymentMethod, Booking booking, Double bill) {
    this.functionBundle = functionBundle;
    this.paymentMethod = paymentMethod;
    this.booking = booking;
    this.bill = bill;
  }


  public FunctionBundle getFunctionBundle() {
    return functionBundle;
  }

  public void setFunctionBundle(FunctionBundle functionBundle) {
    this.functionBundle = functionBundle;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public Booking getBooking() {
    return booking;
  }

  public void setBooking(Booking booking) {
    this.booking = booking;
  }

  public Double getBill() {
    return bill;
  }

  public void setBill(Double bill) {
    this.bill = bill;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Invoice invoice = (Invoice) o;
    return id == invoice.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Invoice{" +
        "id=" + id +
        ", functionBundle=" + functionBundle +
        ", paymentMethod=" + paymentMethod +
        ", booking=" + booking +
        ", bill=" + bill +
        '}';
  }
}
