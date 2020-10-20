package qdo_ln.light_system_testing.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qdo_ln.light_system_testing.services.intefeces.DeviceService;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class MainController {

    private final String DATA_TYPE = "application/json";

    private final DeviceService deviceService;

    @PostMapping(value = "/devices/{projectId}", produces = DATA_TYPE)
    public String showDevicesByProjectId(@PathVariable int projectId){
        return deviceService.findAllByProjectId(projectId).toString();
    }
}
