package de.joergiso.isomatic.device.domain.function.value;

import java.io.Serializable;

public class FunctionName implements Serializable {
    public final String value;

    public FunctionName(String value) {
        this.value = value;
    }
}
