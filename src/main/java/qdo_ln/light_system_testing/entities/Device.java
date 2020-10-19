package qdo_ln.light_system_testing.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "devices")
@Data
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    Project project;

    @Column(name = "serial_number")
    String serialNumber;

    @OneToMany(mappedBy = "device", fetch = FetchType.LAZY)
    List<Event> eventList;
}
