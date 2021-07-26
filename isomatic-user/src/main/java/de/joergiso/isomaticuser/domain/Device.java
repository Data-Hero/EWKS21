package de.joergiso.isomaticuser.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Device {
    @Id
    private Long id;

    @Column
    private String serialNumber;

    public Device() {
    }

    public Device(Long id, String serialNumber) {
        this.id = id;
        this.serialNumber = serialNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonValue
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
