package qdo_ln.light_system_testing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import qdo_ln.light_system_testing.entities.Device;

import javax.transaction.Transactional;
import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

    /**
     * Поиск всех девайсов по идентификатору проекта
     */
    @Modifying
    @Query(value = "SELECT id, serial_number, project_id FROM devices WHERE project_id = :projectId", nativeQuery = true)
    @Transactional
    List<Device> findAllByProjectId(@Param("projectId") int projectId);
}
