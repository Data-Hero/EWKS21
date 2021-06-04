package de.joergiso.isomatic.device.domain.unit;

import de.joergiso.isomatic.device.domain.model.DeviceModel;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitRegistrationStatus;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;

import javax.persistence.*;

@Entity
public class DeviceUnit {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private DeviceUnitSerialNumber serialNumber;

    @OneToOne
    private DeviceModel model;

    @Column
    private DeviceUnitRegistrationStatus registrationStatus;


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
        return this.registrationStatus.type == DeviceUnitRegistrationStatus.Type.REGISTERED;
    }

    public DeviceUnitDto toDto() {
        return new DeviceUnitDto(serialNumber, model);
    }

    public DeviceUnit fromDto(DeviceUnitDto dto) {
        this.serialNumber = dto.getSerialNumber();
        this.model = dto.getModel();

        return this;
    }
}
