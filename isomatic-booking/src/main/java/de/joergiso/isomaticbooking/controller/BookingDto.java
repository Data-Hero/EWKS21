package de.joergiso.isomaticbooking.controller;

import java.time.LocalDateTime;

public class BookingDto {

  int id;

  Long userId;

  Long deviceId;

  LocalDateTime startTime;

  LocalDateTime endTime;

  String functionBundleId;

  public BookingDto() { }

  public BookingDto(int id,
                    Long userId,
                    Long deviceId,
                    LocalDateTime startTime,
                    LocalDateTime endTime,
                    String functionBundleId) {
    this.id = id;
    this.userId = userId;
    this.deviceId = deviceId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.functionBundleId = functionBundleId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(Long deviceId) {
    this.deviceId = deviceId;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public String getFunctionBundleId() {
    return functionBundleId;
  }

  public void setFunctionBundleId(String functionBundleId) {
    this.functionBundleId = functionBundleId;
  }
}
