package qdo_ln.light_system_testing.entities;

import lombok.*;
import qdo_ln.light_system_testing.utils.EventType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
public class Event {

    public Event(Device device, Date date, EventType type, int isRead) {
        this.device = device;
        this.date = date;
        this.type = type;
        this.isRead=isRead;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    Device device;

    Date date;

    @Enumerated
    EventType type;

    @Column(name = "is_read")
    int isRead;
}

