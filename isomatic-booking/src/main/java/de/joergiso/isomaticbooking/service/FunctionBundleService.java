package de.joergiso.isomaticbooking.service;

import de.joergiso.isomaticbooking.repository.FunctionBundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunctionBundleService {
  private final FunctionBundleRepository functionBundleRepository;

  @Autowired
  public FunctionBundleService(FunctionBundleRepository functionBundleRepository) {
    this.functionBundleRepository = functionBundleRepository;
  }
}
