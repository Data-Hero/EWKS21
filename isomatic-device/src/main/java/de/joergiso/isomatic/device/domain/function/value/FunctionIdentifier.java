package de.joergiso.isomatic.device.domain.function.value;

import java.io.Serializable;

public class FunctionIdentifier implements Serializable {
    public final String value;

    public FunctionIdentifier(String value) {
        this.value = value;
    }
}
