package de.joergiso.isomaticbooking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
}
