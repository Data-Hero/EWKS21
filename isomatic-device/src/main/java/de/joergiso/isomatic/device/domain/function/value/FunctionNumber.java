package de.joergiso.isomatic.device.domain.function.value;

import java.io.Serializable;

public class FunctionNumber implements Serializable {
    public final String value;

    public FunctionNumber(String value) {
        this.value = value;
    }
}
