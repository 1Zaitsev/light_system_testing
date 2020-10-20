package qdo_ln.light_system_testing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qdo_ln.light_system_testing.entities.Device;
import qdo_ln.light_system_testing.repositories.DeviceRepository;
import qdo_ln.light_system_testing.services.intefeces.DeviceService;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    private DeviceRepository deviceRepository;

    @Autowired
    public void setDeviceRepository(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<Device> findAllByProjectId(int projectId) {
        return deviceRepository.findAllByProjectId(projectId);
    }
}
