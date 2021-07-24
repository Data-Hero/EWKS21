package de.joergiso.isomaticbooking.controllers;

import java.util.List;

public class FunctionBundleDto {

  String functionBundleId;

  List<String> functionNumber;

  double priceByMinute;

  double discount;

  public FunctionBundleDto() {}

  public FunctionBundleDto(String functionBundleId,
                           List<String> functionNumber,
                           double priceByMinute,
                           double discount) {
    this.functionBundleId = functionBundleId;
    this.functionNumber = functionNumber;
    this.priceByMinute = priceByMinute;
    this.discount = discount;
  }

  public String getFunctionBundleId() {
    return functionBundleId;
  }

  public void setFunctionBundleId(String functionBundleId) {
    this.functionBundleId = functionBundleId;
  }

  public List<String> getFunctionNumber() {
    return functionNumber;
  }

  public void setFunctionNumber(List<String> functionNumber) {
    this.functionNumber = functionNumber;
  }

  public double getPriceByMinute() {
    return priceByMinute;
  }

  public void setPriceByMinute(double priceByMinute) {
    this.priceByMinute = priceByMinute;
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }
}
