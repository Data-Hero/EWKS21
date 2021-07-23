package de.joergiso.isomatic.device.util;

import de.joergiso.isomatic.device.domain.function.DeviceFunctionDto;
import de.joergiso.isomatic.device.domain.function.value.FunctionIdentifier;
import de.joergiso.isomatic.device.domain.function.value.FunctionName;
import de.joergiso.isomatic.device.domain.function.value.FunctionPricing;
import de.joergiso.isomatic.device.request.DeviceFunctionBlueprint;

import java.util.UUID;

public class DeviceFunctionFactory {

    public static DeviceFunctionDto build(DeviceFunctionBlueprint blueprint) {
        return build(blueprint.getName(), blueprint.getPrice(), blueprint.getAmount(), blueprint.getUsage());
    }

    public static DeviceFunctionDto build(String name, float price, int amount, FunctionPricing.Usage usage) {
        return new DeviceFunctionDto(
                new FunctionIdentifier(UUID.randomUUID().toString()),
                new FunctionName(name),
                new FunctionPricing(price, amount, usage)
        );
    }
}
