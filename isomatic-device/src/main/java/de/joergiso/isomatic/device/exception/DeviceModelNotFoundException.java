package de.joergiso.isomatic.device.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DeviceModelNotFoundException extends IllegalArgumentException {
}
