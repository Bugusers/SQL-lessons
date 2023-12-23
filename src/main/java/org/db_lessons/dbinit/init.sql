CREATE TABLE t_homework(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(256) NOT NULL,
	description TEXT
);


CREATE TABLE t_lesson(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(256),
	updatedAt DATE NOT NULL,
	homework_id INT,
	FOREIGN KEY (homework_id) REFERENCES t_homework(id)
);


