package qdo_ln.light_system_testing.dto;

import lombok.Data;
import qdo_ln.light_system_testing.entities.Device;
import qdo_ln.light_system_testing.entities.Event;
import qdo_ln.light_system_testing.entities.Project;
import qdo_ln.light_system_testing.utils.EventType;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProjectDTO {

    private Integer id;

    private String projectName;

    private DeviceStats stats;

    private List<String> devices;

    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.projectName = project.getName();
        this.stats = buildDeviceStates(project);
        this.devices = project.getDeviceList().stream().map(Device::getSerialNumber).collect(Collectors.toList());
    }

    DeviceStats buildDeviceStates(Project project){
        DeviceStats stats = new DeviceStats();
        List<Device> devices = project.getDeviceList();
        int allDevices = devices.size();
        int unstableDevices = 0;
        int deviceWithErrors = 0;
        for (Device d: devices) {
            for (Event e: d.getEventList()) {
                if(e.getType() == EventType.ERROR || e.getType() == EventType.WARNING){
                    unstableDevices++;
                    if(System.currentTimeMillis() - e.getDate().getTime() <= 86400000L){
                        deviceWithErrors++;
                    }
                }
            }
        }
        stats.setDeviceCount(allDevices);
        stats.setStableDevices(allDevices - unstableDevices);
        stats.setDeviceWithErrors(deviceWithErrors);
        return stats;
    }

    @Data
    class DeviceStats {
        private int deviceCount;
        private int deviceWithErrors;
        private int stableDevices;
    }
}
