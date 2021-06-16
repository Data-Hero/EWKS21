package de.joergiso.isomaticbooking.domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Device {
  @Id
  @GeneratedValue
  private Long id;

  @Column
  private String deviceType;

  @Column
  private String deviceName;

  @Column
  private String deviceManufacturerAbbr;

  @Column
  private String deviceManufacturerName;

  @OneToMany
  private List<Function> deviceFunctions;

  protected Device() {
    // ok
  }

  public Device(String deviceType,
                String deviceName,
                String deviceManufacturerAbbr,
                String deviceManufacturerName,
                List<Function> deviceFunctions) {
    this();
    this.deviceType = deviceType;
    this.deviceName = deviceName;
    this.deviceManufacturerAbbr = deviceManufacturerAbbr;
    this.deviceManufacturerName = deviceManufacturerName;
    this.deviceFunctions = deviceFunctions;
  }

  public Long getId() {
    return id;
  }

  public String getDeviceType() {
    return deviceType;
  }

  public void setDeviceType(String deviceType) {
    this.deviceType = deviceType;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getDeviceManufacturerAbbr() {
    return deviceManufacturerAbbr;
  }

  public void setDeviceManufacturerAbbr(String deviceManufacturerAbbr) {
    this.deviceManufacturerAbbr = deviceManufacturerAbbr;
  }

  public String getDeviceManufacturerName() {
    return deviceManufacturerName;
  }

  public void setDeviceManufacturerName(String deviceManufacturerName) {
    this.deviceManufacturerName = deviceManufacturerName;
  }

  public List<Function> getDeviceFunctions() {
    return deviceFunctions;
  }

  public void setDeviceFunctions(List<Function> deviceFunctions) {
    this.deviceFunctions = deviceFunctions;
  }

  @Override
  public String toString() {
    return "Device{" +
        "id=" + id +
        ", deviceType='" + deviceType + '\'' +
        ", deviceName='" + deviceName + '\'' +
        ", deviceManufacturerAbbr='" + deviceManufacturerAbbr + '\'' +
        ", deviceManufacturerName='" + deviceManufacturerName + '\'' +
        ", deviceFunctions=" + deviceFunctions +
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
    Device device = (Device) o;
    return Objects.equals(id, device.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

