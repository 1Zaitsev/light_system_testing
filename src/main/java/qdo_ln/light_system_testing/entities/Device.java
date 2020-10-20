package qdo_ln.light_system_testing.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "devices")
@Data
@NoArgsConstructor
public class Device {

    public Device(Project project, String serialNumber){
        this.project = project;
        this.serialNumber = serialNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    Project project;

    @Column(name = "serial_number")
    String serialNumber;

    @JsonManagedReference
    @OneToMany(mappedBy = "device", fetch = FetchType.LAZY)
    List<Event> eventList;
}
