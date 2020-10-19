package qdo_ln.light_system_testing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qdo_ln.light_system_testing.entities.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
