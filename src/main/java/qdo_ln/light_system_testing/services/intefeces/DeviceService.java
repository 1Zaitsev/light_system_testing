package qdo_ln.light_system_testing.services.intefeces;

import qdo_ln.light_system_testing.entities.Device;
import qdo_ln.light_system_testing.repositories.DeviceRepository;

import java.util.List;

public interface DeviceService {

    List<Device> findAllByProjectId(int projectId);
}
