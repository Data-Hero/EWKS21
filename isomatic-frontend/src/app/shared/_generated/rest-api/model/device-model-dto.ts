/**
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
import { DeviceType } from './device-type';
import { DeviceModelIdentifier } from './device-model-identifier';
import { DeviceManufacturer } from './device-manufacturer';
import { DeviceFunctionDto } from './device-function-dto';
import { DeviceName } from './device-name';


export interface DeviceModelDto { 
    identifier?: DeviceModelIdentifier;
    functions?: Array<DeviceFunctionDto>;
    name?: DeviceName;
    type?: DeviceType;
    manufacturer?: DeviceManufacturer;
}
