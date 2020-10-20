package qdo_ln.light_system_testing.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qdo_ln.light_system_testing.entities.Device;
import qdo_ln.light_system_testing.entities.Project;
import qdo_ln.light_system_testing.services.intefeces.DeviceService;
import qdo_ln.light_system_testing.services.intefeces.ProjectService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class MainController {

    private final String DATA_TYPE = "application/json";

    private final DeviceService deviceService;

    private final ProjectService projectService;

    @GetMapping(value = "/devices/{projectId}", produces = DATA_TYPE)
    public List<Device> showDevicesByProjectId(@PathVariable int projectId){
        return deviceService.findAllByProjectId(projectId);
    }

    @GetMapping(value = "/projects", produces = DATA_TYPE)
    public List<Project> showAllProjects(){
        return projectService.findAll();
    }


}
