package de.joergiso.isomatic.device.domain.function.value;

import java.io.Serializable;

public class FunctionPricing implements Serializable {
    public final float price;
    public final int amount;
    public final Usage usage;

    public FunctionPricing(float price, int amount, Usage usage) {
        this.price = price;
        this.amount = amount;
        this.usage = usage;
    }

    public enum Usage {
        PER_USE, PER_MINUTE;
    }
}
