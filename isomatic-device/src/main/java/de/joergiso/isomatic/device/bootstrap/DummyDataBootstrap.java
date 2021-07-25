package de.joergiso.isomatic.device.bootstrap;

import de.joergiso.isomatic.device.domain.function.value.FunctionPricing;
import de.joergiso.isomatic.device.domain.model.DeviceModelDto;
import de.joergiso.isomatic.device.domain.model.value.DeviceManufacturer;
import de.joergiso.isomatic.device.request.DeviceFunctionBlueprint;
import de.joergiso.isomatic.device.service.DeviceModelService;
import de.joergiso.isomatic.device.service.DeviceService;
import de.joergiso.isomatic.device.util.DeviceFunctionFactory;
import de.joergiso.isomatic.device.util.DeviceModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DummyDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final DeviceModelService deviceModelService;
    private final DeviceService deviceService;

    @Autowired
    public DummyDataBootstrap(DeviceModelService deviceModelService, DeviceService deviceService) {
        this.deviceModelService = deviceModelService;
        this.deviceService = deviceService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        if (deviceModelService.getAllDeviceModels().isEmpty()) {
            DeviceFunctionBlueprint fncBp1 = new DeviceFunctionBlueprint("CO2-Ausgleich", 0.1f, 60, FunctionPricing.Usage.PER_MINUTE);
            DeviceFunctionBlueprint fncBp2 = new DeviceFunctionBlueprint("4D-Wäsche", 1.0f, 1, FunctionPricing.Usage.PER_USE);
            DeviceFunctionBlueprint fncBp3 = new DeviceFunctionBlueprint("Magic Sous-Vide", 2.5f, 120, FunctionPricing.Usage.PER_MINUTE);
            DeviceFunctionBlueprint fncBp4 = new DeviceFunctionBlueprint("Magic Aktiv-Kohle", 1.0f, 60, FunctionPricing.Usage.PER_MINUTE);
            DeviceFunctionBlueprint fncBp5 = new DeviceFunctionBlueprint("5D-Heißluft", 1.5f, 60, FunctionPricing.Usage.PER_MINUTE);
            DeviceFunctionBlueprint fncBp6 = new DeviceFunctionBlueprint("Power-Boost", 0.5f, 30, FunctionPricing.Usage.PER_MINUTE);

            DeviceManufacturer dmBosch = new DeviceManufacturer("BSH", "Bosch");
            DeviceManufacturer dmSiemens = new DeviceManufacturer("BSH", "Siemens");
            DeviceManufacturer dmElectrolux = new DeviceManufacturer("ELX", "Electrolux");
            DeviceManufacturer dmAeg = new DeviceManufacturer("ELX", "AEG");

            DeviceModelDto deviceModelDtoBoschGS = DeviceModelFactory.build("Geschirrspüler", "G133742096X", dmBosch, Set.of());
            DeviceModelDto deviceModelDtoSiemensBO = DeviceModelFactory.build("Backofen", "B230173885S", dmSiemens, Set.of());
            DeviceModelDto deviceModelDtoElectroluxAH = DeviceModelFactory.build("Dunstabzugshaube", "E473836574G", dmElectrolux, Set.of());
            DeviceModelDto deviceModelDtoAegIH = DeviceModelFactory.build("Induktionskochfeld", "A256396640X", dmAeg, Set.of());

            deviceModelDtoBoschGS.setFunctions(Set.of(fncBp1, fncBp2, fncBp4).stream().map(DeviceFunctionFactory::build).collect(Collectors.toSet()));
            deviceModelDtoSiemensBO.setFunctions(Set.of(fncBp1, fncBp3, fncBp5, fncBp6).stream().map(DeviceFunctionFactory::build).collect(Collectors.toSet()));
            deviceModelDtoElectroluxAH.setFunctions(Set.of(fncBp1, fncBp4, fncBp6).stream().map(DeviceFunctionFactory::build).collect(Collectors.toSet()));
            deviceModelDtoAegIH.setFunctions(Set.of(fncBp1, fncBp3, fncBp6).stream().map(DeviceFunctionFactory::build).collect(Collectors.toSet()));

            this.deviceModelService.createDeviceModel(deviceModelDtoBoschGS);
            this.deviceModelService.createDeviceModel(deviceModelDtoSiemensBO);
            this.deviceModelService.createDeviceModel(deviceModelDtoElectroluxAH);
            this.deviceModelService.createDeviceModel(deviceModelDtoAegIH);
        }

        if (deviceService.getAllDeviceUnits().isEmpty()) {
            List<DeviceModelDto> models = this.deviceModelService.getAllDeviceModels();
            models.forEach(it ->
                    this.deviceService.createDeviceUnitByDeviceModelIdentifier(it.getIdentifier().identifier)
            );
        }
    }
}
