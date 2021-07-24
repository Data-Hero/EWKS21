package de.joergiso.isomatic.device.domain.function.value;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FunctionPricing implements Serializable {
    public final float price;
    public final int amount;
    public final Usage usage;

    public FunctionPricing() {
        this.price = 0.0f;
        this.amount = 0;
        this.usage = Usage.PER_USE;
    }

    public FunctionPricing(float price, int amount, Usage usage) {
        this.price = price;
        this.amount = amount;
        this.usage = usage;
    }

    public enum Usage {
        PER_USE, PER_MINUTE;
    }
}
