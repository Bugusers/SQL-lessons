# SQL-lessons

This repo was created for my db lessons

## Homework 19 DDL, DML operations
- The Homework table consists of attributes: id, name, description. The ID attribute has the Primary Key and AutoIncrement constraints.
- Table Lesson - consists of attributes: id, name, updatedAt, homework_id (one-to-one relationship). The ID attribute has the Primary Key and AutoIncrement constraints. It is related to the Homework table via Foreign Key
- Table Schedule - consists of attributes: id, name, updatedAt. The ID attribute has Primary Key and AutoIncrement constraints.
- Table LessonSchedule - consists of attributes: lesson_id, schedule_id.  A pivot table between the Schedule and Lesson.

## Homework 20 TCL  operations
Initiating tables is the same as in task 19.
- Get all Homework records
- Get all Lesson records, including Homework data
- Get all Lesson records (including Homework data) sorted by the last time they were updated
- Get all Schedule records, including Lesson data
- Get the number of Lessons for each Schedule