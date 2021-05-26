package de.joergiso.isomaticbooking.model;

public class FunctionBundle {

  private String functionBundleId;
  private String functionId;
  private Double priceByMinute;
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
