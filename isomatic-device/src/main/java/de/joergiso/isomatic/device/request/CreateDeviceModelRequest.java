package de.joergiso.isomatic.device.request;

import java.util.List;

public class CreateDeviceModelRequest {
    private String type;
    private String name;
    private String manufacturerAbbr;
    private String manufacturerName;
    private List<DeviceFunctionBlueprint> functionBlueprints;

    public CreateDeviceModelRequest(){}

    public CreateDeviceModelRequest(String type, String name, String manufacturerAbbr, String manufacturerName, List<DeviceFunctionBlueprint> functionBlueprints) {
        this.type = type;
        this.name = name;
        this.manufacturerAbbr = manufacturerAbbr;
        this.manufacturerName = manufacturerName;
        this.functionBlueprints = functionBlueprints;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturerAbbr() {
        return manufacturerAbbr;
    }

    public void setManufacturerAbbr(String manufacturerAbbr) {
        this.manufacturerAbbr = manufacturerAbbr;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public List<DeviceFunctionBlueprint> getFunctionBlueprints() {
        return functionBlueprints;
    }

    public void setFunctionBlueprints(List<DeviceFunctionBlueprint> functionBlueprints) {
        this.functionBlueprints = functionBlueprints;
    }
}
