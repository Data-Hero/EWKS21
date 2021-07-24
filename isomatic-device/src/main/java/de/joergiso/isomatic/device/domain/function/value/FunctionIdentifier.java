package de.joergiso.isomatic.device.domain.function.value;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FunctionIdentifier implements Serializable {
    public final String identifier;

    public FunctionIdentifier() {
        this.identifier = "";
    }

    public FunctionIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
