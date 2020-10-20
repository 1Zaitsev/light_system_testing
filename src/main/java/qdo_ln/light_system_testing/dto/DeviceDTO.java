package qdo_ln.light_system_testing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import qdo_ln.light_system_testing.entities.Device;
import qdo_ln.light_system_testing.entities.Event;
import qdo_ln.light_system_testing.utils.EventType;

import java.util.List;

@Data
public class DeviceDTO {

    String serialNumber;

    DeviceDetails deviceDetails;

    public DeviceDTO(Device device){
        this.serialNumber = device.getSerialNumber();
        this.deviceDetails = buildDeviceDetails(device);
    }

    DeviceDetails buildDeviceDetails(Device device){
        DeviceDetails deviceDetails = new DeviceDetails();
        DeviceDetails.SummaryInfo si = deviceDetails.buildSummaryInfo(device.getEventList());
        deviceDetails.id = device.getId();
        deviceDetails.serialNumber = device.getSerialNumber();
        deviceDetails.projectId = device.getProject().getId();
        deviceDetails.hasErrors = si.errorCount != 0;
        deviceDetails.summaryInfo = si;
        return deviceDetails;
    }

    @Data
    class DeviceDetails{
        private int id;
        private String serialNumber;
        private int projectId;
        private boolean hasErrors;
        private SummaryInfo summaryInfo;

        SummaryInfo buildSummaryInfo(List<Event> eventList){
            SummaryInfo summaryInfo = new SummaryInfo();
            int eventCount = 0;
            int warningCount = 0;
            int errorCount = 0;
            for (Event e:eventList) {
                if(e.getType() == EventType.EVENT) eventCount++;
                if(e.getType() == EventType.WARNING) warningCount++;
                if(e.getType() == EventType.ERROR) errorCount++;
            }
            summaryInfo.setEventCount(eventCount);
            summaryInfo.setWarningCount(warningCount);
            summaryInfo.setErrorCount(errorCount);
            return summaryInfo;
        }

        @Data
        class SummaryInfo{
            private int eventCount;
            private int warningCount;
            private int errorCount;
        }
    }

}
