package de.joergiso.isomaticbooking.service;

import de.joergiso.isomaticbooking.domain.FunctionBundle;
import de.joergiso.isomaticbooking.domain.User;
import de.joergiso.isomaticbooking.repository.FunctionBundleRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunctionBundleService {
  private final FunctionBundleRepository functionBundleRepository;

  @Autowired
  public FunctionBundleService(FunctionBundleRepository functionBundleRepository) {
    this.functionBundleRepository = functionBundleRepository;
  }

  public List<FunctionBundle> getFunctionBundleByUser(User user) {
    return StreamSupport.stream(
        functionBundleRepository.findAll().spliterator(), false
      ).filter(fb -> fb.getFunction().stream().allMatch(
          function -> user.getDevices().stream().anyMatch(
            device -> device.equals(function.getDevice())
          )
        )
      ).collect(Collectors.toList());
  }
}
