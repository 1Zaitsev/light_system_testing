DROP TABLE IF EXISTS light_system.devices CASCADE;

CREATE TABLE light_system.devices
(
    id            INT          NOT NULL AUTO_INCREMENT,
    project_id    INT          NOT NULL,
    serial_number VARCHAR(256) NULL,
    PRIMARY KEY (id),
    INDEX         fk_devices_projects_idx(project_id ASC) VISIBLE,
    CONSTRAINT fk_devices_projects
        FOREIGN KEY (project_id)
            REFERENCES light_system.projects (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
