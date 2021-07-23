package de.joergiso.isomatic.device.request;

import de.joergiso.isomatic.device.domain.function.value.FunctionPricing;

public class DeviceFunctionBlueprint {
    private float price;
    private String name;
    private int amount;
    private FunctionPricing.Usage usage;

    public DeviceFunctionBlueprint(float price, String name, int amount, FunctionPricing.Usage usage) {
        this.price = price;
        this.name = name;
        this.amount = amount;
        this.usage = usage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
