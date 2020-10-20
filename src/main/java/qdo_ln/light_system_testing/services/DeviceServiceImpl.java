package qdo_ln.light_system_testing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qdo_ln.light_system_testing.dto.DeviceDTO;
import qdo_ln.light_system_testing.entities.Device;
import qdo_ln.light_system_testing.repositories.DeviceRepository;
import qdo_ln.light_system_testing.services.intefeces.DeviceService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    private DeviceRepository deviceRepository;

    @Autowired
    public void setDeviceRepository(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public List<Device> findAllByProjectId(int projectId) {
        return deviceRepository.findAllByProjectId(projectId);
    }

    @Override
    public List<DeviceDTO> findAllByProjectIdDTO(int projectId) {
        List<Device> devices = findAllByProjectId(projectId);
        List<DeviceDTO> devicesDTO = new ArrayList<>(devices.size());
        for(Device d: devices){
            devicesDTO.add(new DeviceDTO(d));
        }
        return devicesDTO;
    }
}
