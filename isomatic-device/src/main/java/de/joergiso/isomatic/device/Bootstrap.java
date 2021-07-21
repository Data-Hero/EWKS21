package de.joergiso.isomatic.device;

import de.joergiso.isomatic.device.domain.function.DeviceFunction;
import de.joergiso.isomatic.device.domain.function.value.FunctionName;
import de.joergiso.isomatic.device.domain.function.value.FunctionNumber;
import de.joergiso.isomatic.device.domain.function.value.FunctionPricing;
import de.joergiso.isomatic.device.domain.model.DeviceModel;
import de.joergiso.isomatic.device.domain.model.value.DeviceManufacturer;
import de.joergiso.isomatic.device.domain.model.value.DeviceName;
import de.joergiso.isomatic.device.domain.model.value.DeviceType;
import de.joergiso.isomatic.device.domain.unit.DeviceUnit;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitRegistrationStatus;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;
import de.joergiso.isomatic.device.repository.DeviceUnitRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
  private final DeviceUnitRepository deviceUnitRepository;

  @Autowired
  public Bootstrap(DeviceUnitRepository deviceUnitRepository) {
    this.deviceUnitRepository = deviceUnitRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  private void initData() {
    DeviceUnit deviceUnit1 = new DeviceUnit();
    deviceUnit1.setSerialNumber(new DeviceUnitSerialNumber("D1"));
    DeviceModel deviceModel1 = new DeviceModel();
    deviceModel1.setName(new DeviceName("Fridge"));
    deviceModel1.setType(new DeviceType("Type"));
    DeviceFunction deviceFunction = new DeviceFunction(
        new FunctionNumber("F1"),
        new FunctionName("Function1"),
        new FunctionPricing(2.2f, 1, FunctionPricing.TimeUnit.MINUTE)
    );
    deviceModel1.setDeviceFunctions(Set.of(deviceFunction));
    deviceModel1.setManufacturer(new DeviceManufacturer("t", "Test"));
    deviceUnit1.setModel(deviceModel1);
    deviceUnit1.setRegistrationStatus(new DeviceUnitRegistrationStatus(DeviceUnitRegistrationStatus.Type.REGISTERED));
    deviceUnit1.setSerialNumber(new DeviceUnitSerialNumber("D2"));
    deviceUnitRepository.save(deviceUnit1);
  }
}
