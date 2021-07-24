package de.joergiso.isomatic.device.request;

import de.joergiso.isomatic.device.domain.function.value.FunctionPricing;

public class DeviceFunctionBlueprint {
    private String name;
    private float price;
    private int amount;
    private FunctionPricing.Usage usage;

    public DeviceFunctionBlueprint(String name, float price, int amount, FunctionPricing.Usage usage) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.usage = usage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public FunctionPricing.Usage getUsage() {
        return usage;
    }

    public void setUsage(FunctionPricing.Usage usage) {
        this.usage = usage;
    }
}
