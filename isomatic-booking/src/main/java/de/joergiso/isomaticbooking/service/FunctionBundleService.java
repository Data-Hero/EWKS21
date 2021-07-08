package de.joergiso.isomaticbooking.service;

import de.joergiso.isomaticbooking.controllers.FunctionBundleDto;
import de.joergiso.isomaticbooking.domain.FunctionBundle;
import de.joergiso.isomaticbooking.domain.User;
import de.joergiso.isomaticbooking.exception.UserNotFoundException;
import de.joergiso.isomaticbooking.repository.FunctionBundleRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunctionBundleService {
  private final FunctionBundleRepository functionBundleRepository;
  private final Mapper mapper;
  private final UserService userService;
  @Autowired
  public FunctionBundleService(FunctionBundleRepository functionBundleRepository,
                               Mapper mapper,
                               UserService userService) {
    this.functionBundleRepository = functionBundleRepository;
    this.mapper = mapper;
    this.userService = userService;
  }

  public List<FunctionBundleDto> getFunctionBundleByUser(Long userId) throws UserNotFoundException {
    User user = userService.fetchUser(userId);
    return StreamSupport.stream(
        functionBundleRepository.findAll().spliterator(), false
      ).filter(fb -> fb.getFunction().stream().allMatch(
          function -> user.getDevices().stream().anyMatch(
            device -> device.equals(function.getDevice())
          )
        )
      ).map(mapper::functionBundleToDto)
        .collect(Collectors.toList());
  }

  public FunctionBundle addFunctionBundle(FunctionBundleDto functionBundleDto){
    return functionBundleRepository.save(mapper.functionBundleFromDto(functionBundleDto));
  }
}
