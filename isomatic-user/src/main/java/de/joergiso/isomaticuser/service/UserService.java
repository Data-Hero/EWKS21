package de.joergiso.isomaticuser.service;

import de.joergiso.isomaticuser.domain.Device;
import de.joergiso.isomaticuser.domain.DeviceDto;
import de.joergiso.isomaticuser.domain.User;
import de.joergiso.isomaticuser.domain.UserDto;
import de.joergiso.isomaticuser.repository.RemoteDeviceRepository;
import de.joergiso.isomaticuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RemoteDeviceRepository remoteDeviceRepository;

    @Autowired
    public UserService(UserRepository userRepository, RemoteDeviceRepository remoteDeviceRepository) {
        this.userRepository = userRepository;
        this.remoteDeviceRepository = remoteDeviceRepository;
    }

    public void registerDevice(Long userId, DeviceDto deviceDto) {
        User user = this.userRepository.findById(userId).get();
        Device device = new Device(deviceDto.getId(), deviceDto.getSerialNumber());

        List<String> serialNumbers = new ArrayList<>();
        this.remoteDeviceRepository.fetchDevices().forEach(deviceUnitDto -> serialNumbers.add(deviceUnitDto.getSerialNumber().serialNumber));

        if(serialNumbers.contains(deviceDto.getSerialNumber())) {
            user.getDevices().add(device);
            this.updateUser(user);
        } else {
            System.out.println("no devices availabe?");
        }
    }

    public void createUser(UserDto user) {
        User entity = new User();
        entity.setName(user.getName());

        this.userRepository.save(entity);
    }

    public User getUserById(Long id) {
        Optional<User> user = this.userRepository.findById(id);

        return user.orElse(null);
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public void updateUser(User user) {
        Optional<User> storedUser = this.userRepository.findById(user.getId());

        storedUser.ifPresent(entity -> {
            entity.setName(user.getName());
            entity.setBookings(user.getBookings());
            entity.setDevices(user.getDevices());

            this.userRepository.save(entity);
        });
    }
}
