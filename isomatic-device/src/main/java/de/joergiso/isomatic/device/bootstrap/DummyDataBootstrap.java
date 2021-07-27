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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            DeviceFunctionBlueprint fncBp1 = new DeviceFunctionBlueprint("CO2-Ausgleich", 10, 60, FunctionPricing.Usage.PER_MINUTE);
            DeviceFunctionBlueprint fncBp2 = new DeviceFunctionBlueprint("4D-Wäsche", 100, 1, FunctionPricing.Usage.PER_USE);
            DeviceFunctionBlueprint fncBp3 = new DeviceFunctionBlueprint("Magic Sous-Vide", 250, 120, FunctionPricing.Usage.PER_MINUTE);
            DeviceFunctionBlueprint fncBp4 = new DeviceFunctionBlueprint("Magic Aktiv-Kohle", 100, 60, FunctionPricing.Usage.PER_MINUTE);
            DeviceFunctionBlueprint fncBp5 = new DeviceFunctionBlueprint("5D-Heißluft", 150, 60, FunctionPricing.Usage.PER_MINUTE);
            DeviceFunctionBlueprint fncBp6 = new DeviceFunctionBlueprint("Power-Boost", 50, 30, FunctionPricing.Usage.PER_MINUTE);

            DeviceManufacturer dmBosch = new DeviceManufacturer("BSH", "Bosch");
            DeviceManufacturer dmSiemens = new DeviceManufacturer("BSH", "Siemens");
            DeviceManufacturer dmElectrolux = new DeviceManufacturer("ELX", "Electrolux");
            DeviceManufacturer dmAeg = new DeviceManufacturer("ELX", "AEG");

            DeviceModelDto deviceModelDtoBoschGS = DeviceModelFactory.build("Geschirrspüler", "G133742096X", dmBosch, Collections.emptyList());
            DeviceModelDto deviceModelDtoSiemensBO = DeviceModelFactory.build("Backofen", "B230173885S", dmSiemens, Collections.emptyList());
            DeviceModelDto deviceModelDtoElectroluxAH = DeviceModelFactory.build("Dunstabzugshaube", "E473836574G", dmElectrolux, Collections.emptyList());
            DeviceModelDto deviceModelDtoAegIH = DeviceModelFactory.build("Induktionskochfeld", "A256396640X", dmAeg, Collections.emptyList());

            deviceModelDtoBoschGS.setFunctions(Stream.of(fncBp1, fncBp2, fncBp4).map(DeviceFunctionFactory::build).collect(Collectors.toList()));
            deviceModelDtoSiemensBO.setFunctions(Stream.of(fncBp1, fncBp3, fncBp5, fncBp6).map(DeviceFunctionFactory::build).collect(Collectors.toList()));
            deviceModelDtoElectroluxAH.setFunctions(Stream.of(fncBp1, fncBp4, fncBp6).map(DeviceFunctionFactory::build).collect(Collectors.toList()));
            deviceModelDtoAegIH.setFunctions(Stream.of(fncBp1, fncBp3, fncBp6).map(DeviceFunctionFactory::build).collect(Collectors.toList()));

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
