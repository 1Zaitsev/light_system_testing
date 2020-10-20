package qdo_ln.light_system_testing.entities;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
@Data
public class Event {

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

@Getter
@RequiredArgsConstructor
enum EventType{
    EVENT("event"),
    WARNING("warning"),
    ERROR("error");

    private final String title;
}
