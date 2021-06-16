package de.joergiso.isomaticbooking.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Function {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private String functionNumber;

  @Column(nullable = false)
  private String functionName;

  @Column(nullable = false)
  private Double pricePerTimeUnit;

  @Column(nullable = false)
  private Integer amountOfTime;

  @Enumerated(EnumType.STRING)
  private TimeUnit timeRequired;

  protected Function() {
    // empty constructor
  }

  public Function(String functionNumber, String functionName, Double pricePerTimeUnit, Integer amountOfTime, TimeUnit timeRequired) {
    this();
    this.functionNumber = functionNumber;
    this.functionName = functionName;
    this.pricePerTimeUnit = pricePerTimeUnit;
    this.amountOfTime = amountOfTime;
    this.timeRequired = timeRequired;
  }

  public Long getId() {
    return id;
  }

  public String getFunctionNumber() {
    return functionNumber;
  }

  public void setFunctionNumber(String functionNumber) {
    this.functionNumber = functionNumber;
  }

  public String getFunctionName() {
    return functionName;
  }

  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }

  public Double getPricePerTimeUnit() {
    return pricePerTimeUnit;
  }

  public void setPricePerTimeUnit(Double pricePerTimeUnit) {
    this.pricePerTimeUnit = pricePerTimeUnit;
  }

  public Integer getAmountOfTime() {
    return amountOfTime;
  }

  public void setAmountOfTime(Integer amountOfTime) {
    this.amountOfTime = amountOfTime;
  }

  public TimeUnit getTimeRequired() {
    return timeRequired;
  }

  public void setTimeRequired(TimeUnit timeRequired) {
    this.timeRequired = timeRequired;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Function function = (Function) o;
    return Objects.equals(id, function.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Function{" +
        "id=" + id +
        ", functionNumber='" + functionNumber + '\'' +
        ", functionName='" + functionName + '\'' +
        ", pricePerTimeUnit=" + pricePerTimeUnit +
        ", amountOfTime=" + amountOfTime +
        ", timeRequired=" + timeRequired +
        '}';
  }
}
