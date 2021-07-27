package de.joergiso.isomatic.device.domain.function;

import de.joergiso.isomatic.device.domain.function.value.FunctionIdentifier;
import de.joergiso.isomatic.device.domain.function.value.FunctionName;
import de.joergiso.isomatic.device.domain.function.value.FunctionPricing;

public class DeviceFunctionDto {
    private FunctionIdentifier identifier;
    private FunctionName name;
    private FunctionPricing pricing;

    public DeviceFunctionDto() {
    }

    public DeviceFunctionDto(FunctionIdentifier identifier, FunctionName name, FunctionPricing pricing) {
        this.identifier = identifier;
        this.name = name;
        this.pricing = pricing;
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
}
