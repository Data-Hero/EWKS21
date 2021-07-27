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


export interface DeviceFunctionBlueprint { 
    amount?: number;
    price?: number;
    usage?: DeviceFunctionBlueprint.UsageEnum;
    name?: string;
}
export namespace DeviceFunctionBlueprint {
    export type UsageEnum = 'PER_USE' | 'PER_MINUTE';
    export const UsageEnum = {
        USE: 'PER_USE' as UsageEnum,
        MINUTE: 'PER_MINUTE' as UsageEnum
    };
}

