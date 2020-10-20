package qdo_ln.light_system_testing.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
public class Project {

    public Project(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    List<Device> deviceList;
}
