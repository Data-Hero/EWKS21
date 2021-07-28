package de.joergiso.isomaticbooking.domain;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;


@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String serialNumber;

    public Device() {
    }

    public Device(String serialNumber) {
        this.serialNumber = serialNumber;
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
