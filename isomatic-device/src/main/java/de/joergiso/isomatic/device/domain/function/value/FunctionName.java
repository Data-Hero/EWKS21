package de.joergiso.isomatic.device.domain.function.value;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FunctionName implements Serializable {
    public final String name;

    public FunctionName() {
        this.name = "";
    }

    public FunctionName(String name) {
        this.name = name;
    }
}
