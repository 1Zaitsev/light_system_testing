package qdo_ln.light_system_testing.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qdo_ln.light_system_testing.dto.DeviceDTO;
import qdo_ln.light_system_testing.dto.ProjectDTO;
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
    public List<DeviceDTO> showDevicesByProjectId(@PathVariable int projectId){
        return deviceService.findAllByProjectIdDTO(projectId);
    }

    @GetMapping(value = "/projects", produces = DATA_TYPE)
    public List<ProjectDTO> showAllProjects(){
        return projectService.findAllDTO();
    }


}
