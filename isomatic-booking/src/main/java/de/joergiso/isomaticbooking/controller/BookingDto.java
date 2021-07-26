package de.joergiso.isomaticbooking.controller;

import java.time.LocalDateTime;

public class BookingDto {
  
  Long userId;

  LocalDateTime startTime;

  LocalDateTime endTime;

  String functionBundleId;

  public BookingDto() { }

  public BookingDto(Long userId,
                    LocalDateTime startTime,
                    LocalDateTime endTime,
                    String functionBundleId) {
    this.userId = userId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.functionBundleId = functionBundleId;
  }


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
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
