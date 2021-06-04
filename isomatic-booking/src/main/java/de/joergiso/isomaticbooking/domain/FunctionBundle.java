package de.joergiso.isomaticbooking.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FunctionBundle {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(nullable = false)
  private String functionBundleId;

  @OneToMany(fetch = FetchType.LAZY)
  private List<Function> function;

  @Column(nullable = false)
  private Double priceByMinute;

  @Column
  private Double discount;

  public String getFunctionBundleId() {
    return functionBundleId;
  }

  public void setFunctionBundleId(String functionBundleId) {
    this.functionBundleId = functionBundleId;
  }

  public List<Function> getFunction() {
    return function;
  }

  public void setFunction(List<Function> function) {
    this.function = function;
  }

  public Double getPriceByMinute() {
    return priceByMinute;
  }

  public void setPriceByMinute(Double priceByMinute) {
    this.priceByMinute = priceByMinute;
  }

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }
}
