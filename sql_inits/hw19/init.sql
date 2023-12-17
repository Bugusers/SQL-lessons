
-- Task 1
CREATE TABLE t_homework(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(256) NOT NULL,
	description TEXT
);

-- Task 2
CREATE TABLE t_lesson(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(256),
	updatedAt DATE NOT NULL,
	homework_id INT UNIQUE,
	FOREIGN KEY (homework_id) REFERENCES t_homework(id)
);

-- Task 3
CREATE TABLE t_schedule(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(256) NOT NULL,
	updatedAt DATE NOT NULL
);


-- many-to-many звідна таблиця
CREATE TABLE t_lesson_schedule (
    lesson_id INT NOT NULL,
    schedule_id INT NOT NULL,
    PRIMARY KEY (lesson_id, schedule_id),
    FOREIGN KEY (lesson_id) REFERENCES t_lesson(id) ON DELETE CASCADE,
    FOREIGN KEY (schedule_id) REFERENCES t_schedule(id) ON DELETE CASCADE
);

