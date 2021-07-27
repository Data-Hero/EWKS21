package de.joergiso.isomatic.device.domain.function.value;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FunctionPricing implements Serializable {
    public int price;
    public int amount;
    public Usage usage;

    public FunctionPricing() {
        this.price = 0;
        this.amount = 0;
        this.usage = Usage.PER_USE;
    }

    public FunctionPricing(int price, int amount, Usage usage) {
        this.price = price;
        this.amount = amount;
        this.usage = usage;
    }

    public enum Usage {
        PER_USE, PER_MINUTE
    }
}
