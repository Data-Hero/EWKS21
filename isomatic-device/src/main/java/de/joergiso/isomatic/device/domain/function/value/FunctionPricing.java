package de.joergiso.isomatic.device.domain.function.value;

import java.io.Serializable;

public class FunctionPricing implements Serializable {
    public final float price;
    public final int timeAmount;
    public final TimeUnit timeUnit;

    public FunctionPricing(float price, int timeAmount, TimeUnit timeUnit) {
        this.price = price;
        this.timeAmount = timeAmount;
        this.timeUnit = timeUnit;
    }

    enum TimeUnit {
        MINUTE, HOUR, DAY
    }
}
