package de.joergiso.isomatic.device.domain.function;

import de.joergiso.isomatic.device.domain.function.value.FunctionName;
import de.joergiso.isomatic.device.domain.function.value.FunctionNumber;
import de.joergiso.isomatic.device.domain.function.value.FunctionPricing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DeviceFunction {

    @Id @GeneratedValue
    private Long id;

    @Column
    private FunctionNumber number;

    @Column
    private FunctionName name;

    @Column
    private FunctionPricing pricing;

}
