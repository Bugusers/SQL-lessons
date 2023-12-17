-- Task 1
SELECT * FROM t_homework;

-- Task 2
SELECT
    l.*,
    h.name AS Homework,
    h.description AS homework_description
FROM t_lesson l
JOIN t_homework h ON l.homework_id = h.id;

-- Task 3
SELECT
    l.*,
    h.name AS Homework,
    h.description AS homework_description
FROM t_lesson l
JOIN t_homework h ON l.homework_id = h.id
ORDER BY l.updatedAt;

-- Task 4
SELECT
    ls.schedule_id AS schedule_id,
    s.name AS Schedule,
    s.updatedAt AS schedule_updatedAt,
    ls.lesson_id AS lesson_id,
    l.name AS Lesson,
    l.updatedAt AS lesson_updatedAt,
    l.homework_id AS lesson_homework_id
FROM t_lesson_schedule ls
JOIN t_lesson l ON lesson_id = l.id
JOIN t_schedule s ON schedule_id = s.id;

-- Task 5
SELECT
    s.id AS ID,
    s.name AS Schedule,
    COUNT(l.id) AS lesson_count
FROM t_lesson_schedule ls
JOIN t_lesson l ON ls.lesson_id = l.id
JOIN t_schedule s ON ls.schedule_id = s.id
GROUP BY s.id, s.name;