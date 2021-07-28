package de.joergiso.isomaticbooking.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class BookingInformationDto {

  private Long userId;

  private String functionBundleId;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Berlin")
  private LocalDateTime startTime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Berlin")
  private LocalDateTime endTime;

  public BookingInformationDto() {}

  public BookingInformationDto(@JsonProperty("userId") Long userId,
                               @JsonProperty("functionBundleId") String functionBundleId,
                               @JsonProperty("startTime") LocalDateTime startTime,
                               @JsonProperty("endTime") LocalDateTime endTime) {
    this.userId = userId;
    this.functionBundleId = functionBundleId;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getDeviceId() {
    return functionBundleId;
  }

  public void setDeviceId(String deviceId) {
    this.functionBundleId = deviceId;
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

  @Override
  public String toString() {
    return "BookingInformationDto{" +
        "userId=" + userId +
        ", functionBundleId='" + functionBundleId + '\'' +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        '}';
  }
}
