package de.joergiso.isomatic.device.domain.function;

import de.joergiso.isomatic.device.domain.function.value.FunctionName;
import de.joergiso.isomatic.device.domain.function.value.FunctionIdentifier;
import de.joergiso.isomatic.device.domain.function.value.FunctionPricing;
import de.joergiso.isomatic.device.request.DeviceFunctionBlueprint;
import de.joergiso.isomatic.device.util.DeviceFunctionFactory;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class DeviceFunction {

    @Id @GeneratedValue
    private Long id;

    @Embedded
    @Column(unique = true)
    private FunctionIdentifier identifier;

    @Embedded
    @Column
    private FunctionName name;

    @Embedded
    @Column
    private FunctionPricing pricing;

    public Long getId() {
        return id;
    }

    public FunctionIdentifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(FunctionIdentifier identifier) {
        this.identifier = identifier;
    }

    public FunctionName getName() {
        return name;
    }

    public void setName(FunctionName name) {
        this.name = name;
    }

    public FunctionPricing getPricing() {
        return pricing;
    }

    public void setPricing(FunctionPricing pricing) {
        this.pricing = pricing;
    }

    public DeviceFunctionDto toDto() {
        return new DeviceFunctionDto(identifier, name, pricing);
    }

    public DeviceFunction fromDto(DeviceFunctionDto dto) {
        this.identifier = dto.getIdentifier();
        this.name = dto.getName();
        this.pricing = dto.getPricing();

        return this;
    }

}
