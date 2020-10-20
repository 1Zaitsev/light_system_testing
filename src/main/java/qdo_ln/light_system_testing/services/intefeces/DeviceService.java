package qdo_ln.light_system_testing.services.intefeces;

import qdo_ln.light_system_testing.entities.Device;

import java.util.List;

public interface DeviceService {

    Device save(Device device);

    List<Device> findAllByProjectId(int projectId);
}
