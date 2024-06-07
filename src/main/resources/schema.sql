CREATE TABLE academy (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255),
                         location VARCHAR(255)
);

CREATE TABLE student (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255),
                         age INT,
                         academy_id BIGINT,
                         FOREIGN KEY (academy_id) REFERENCES academy(id)
);