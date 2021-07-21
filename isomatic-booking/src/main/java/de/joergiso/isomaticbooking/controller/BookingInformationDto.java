package de.joergiso.isomaticbooking.controller;

import java.time.LocalDateTime;

public class BookingInformationDto {

  Long userId;

  Long deviceId;

  LocalDateTime startTime;

  LocalDateTime endTime;

  public BookingInformationDto(Long userId, Long deviceId, LocalDateTime startTime, LocalDateTime endTime) {
    this.userId = userId;
    this.deviceId = deviceId;
    this.startTime = startTime;
    this.endTime = endTime;
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
}
