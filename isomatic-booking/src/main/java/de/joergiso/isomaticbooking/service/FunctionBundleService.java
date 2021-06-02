package de.joergiso.isomaticbooking.service;

import de.joergiso.isomaticbooking.dao.FunctionBundleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunctionBundleService {
  private final FunctionBundleDao functionBundleDao;

  @Autowired
  public FunctionBundleService(FunctionBundleDao functionBundleDao) {
    this.functionBundleDao = functionBundleDao;
  }
}
