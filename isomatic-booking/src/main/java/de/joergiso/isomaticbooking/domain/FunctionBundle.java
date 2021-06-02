package de.joergiso.isomaticbooking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FunctionBundle {

  @Id
  private String functionBundleId;

  @OneToMany(fetch = FetchType.LAZY)
  private String functionId;

  @Column
  private Double priceByMinute;

  @Column
  private Double discount;

  public String getFunctionBundleId() {
    return functionBundleId;
  }

  public void setFunctionBundleId(String functionBundleId) {
    this.functionBundleId = functionBundleId;
  }

  public String getFunctionId() {
    return functionId;
  }

  public void setFunctionId(String functionId) {
    this.functionId = functionId;
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
