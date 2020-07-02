CREATE SCHEMA IF NOT EXISTS sample_schema;

CREATE TABLE IF NOT EXISTS sample_schema.sample_table
(
    id int NOT NULL AUTO_INCREMENT,
    name       VARCHAR(64),
    PRIMARY KEY (id)
);

INSERT INTO sample_schema.sample_table VALUES (NULL, 'SampleName1');
INSERT INTO sample_schema.sample_table VALUES (NULL, 'SampleName2');