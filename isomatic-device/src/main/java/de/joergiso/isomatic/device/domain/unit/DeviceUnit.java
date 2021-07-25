package de.joergiso.isomatic.device.domain.unit;

import de.joergiso.isomatic.device.domain.model.DeviceModel;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitRegistrationStatus;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;

import javax.persistence.*;

@Entity
public class DeviceUnit {

    @Id @GeneratedValue
    private Long id;

    @Embedded
    @Column(unique = true)
    private DeviceUnitSerialNumber serialNumber;

    @OneToOne
    private DeviceModel model;

    @Embedded
    @Column
    private DeviceUnitRegistrationStatus registrationStatus;

    public DeviceUnit() {
        this.serialNumber = new DeviceUnitSerialNumber();
        this. model = new DeviceModel();
        this.registrationStatus = new DeviceUnitRegistrationStatus();
    }

    public DeviceUnit(DeviceUnitSerialNumber serialNumber, DeviceModel model, DeviceUnitRegistrationStatus registrationStatus) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.registrationStatus = registrationStatus;
    }

    public Long getId() {
        return id;
    }

    public DeviceUnitSerialNumber getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(DeviceUnitSerialNumber serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DeviceModel getModel() {
        return model;
    }

    public void setModel(DeviceModel model) {
        this.model = model;
    }

    public DeviceUnitRegistrationStatus getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(DeviceUnitRegistrationStatus registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public boolean isRegistered() {
        return this.registrationStatus.status == DeviceUnitRegistrationStatus.Status.REGISTERED;
    }

    public DeviceUnitDto toDto() {
        return new DeviceUnitDto(serialNumber, model.toDto());
    }

    public DeviceUnit fromDto(DeviceUnitDto dto) {
        this.serialNumber = dto.getSerialNumber();
        this.model = new DeviceModel().fromDto(dto.getModelDto());

        return this;
    }
}
