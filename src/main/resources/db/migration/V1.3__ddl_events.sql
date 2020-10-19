DROP TABLE IF EXISTS light_system.events CASCADE;

CREATE TABLE light_system.events
(
    id        INT  NOT NULL AUTO_INCREMENT,
    device_id INT  NOT NULL,
    date      DATE NOT NULL,
    type      ENUM ('event', 'warning', 'error'),
    is_read   BOOLEAN,
    PRIMARY KEY (id),
    INDEX fk_events_devices_idx (device_id ASC) VISIBLE,
    CONSTRAINT fk_events_devices
        FOREIGN KEY (device_id)
            REFERENCES light_system.devices (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
