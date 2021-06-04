package de.joergiso.isomaticbooking.domain;

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


  public Booking() {}

  public FunctionBundle getFunctionBundle() {
    return functionBundle;
  }

  public void setFunctionBundle(FunctionBundle functionBundle) {
    this.functionBundle = functionBundle;
  }
}
