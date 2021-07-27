package de.joergiso.isomaticbooking.domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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

  @ElementCollection
  private List<String> functions;

  @Column(nullable = false)
  private Double priceByMinute;

  @Column
  private Double discount;

  public FunctionBundle() {}

  public FunctionBundle(String functionBundleId, List<String> functionIds, Double priceByMinute, Double discount) {
    this.functionBundleId = functionBundleId;
    this.functions = functionIds;
    this.priceByMinute = priceByMinute;
    this.discount = discount;
  }

  public String getFunctionBundleId() {
    return functionBundleId;
  }

  public void setFunctionBundleId(String functionBundleId) {
    this.functionBundleId = functionBundleId;
  }

  public List<String> getFunctions() {
    return functions;
  }

  public void setFunctions(List<String> functions) {
    this.functions = functions;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FunctionBundle that = (FunctionBundle) o;
    return id == that.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "FunctionBundle{" +
        "id=" + id +
        ", functionBundleId='" + functionBundleId + '\'' +
        ", function=" + functions +
        ", priceByMinute=" + priceByMinute +
        ", discount=" + discount +
        '}';
  }
}
