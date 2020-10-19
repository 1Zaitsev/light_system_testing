DROP TABLE IF EXISTS light_system.projects CASCADE;

CREATE TABLE light_system.projects
(
    id   INT          NOT NULL AUTO_INCREMENT,
    name VARCHAR(256) NULL,
    PRIMARY KEY (id)
);
