# SQL-lessons

This repo was created for my db lessons

## Homework 19 DDL, DML operations
- The Homework table consists of attributes: id, name, description. The ID attribute has the Primary Key and AutoIncrement constraints.
- Table Lesson - consists of attributes: id, name, updatedAt, homework_id (one-to-one relationship). The ID attribute has the Primary Key and AutoIncrement constraints. It is related to the Homework table via Foreign Key
- Table Schedule - consists of attributes: id, name, updatedAt. The ID attribute has Primary Key and AutoIncrement constraints.
- Table LessonSchedule - consists of attributes: lesson_id, schedule_id.  A pivot table between the Schedule and Lesson.

## Homework 20 TCL operations
Initiating tables is the same as in task 19.
- Get all Homework records
- Get all Lesson records, including Homework data
- Get all Lesson records (including Homework data) sorted by the last time they were updated
- Get all Schedule records, including Lesson data
- Get the number of Lessons for each Schedule

##  Homework 21 Working with databases in Java


The Homework table consists of attributes: id, name, description
The Lesson table consists of attributes: id, name, updatedAt, homework_id (associated with the Homework table)
The DataBaseConnection class:
- method getConnection() - returns a new connection to the database
- method close(Connection) - closes the passed connection

The Lesson class contains the following properties: id, name, homework
The Homework class contains the following properties: id, name, description
Class LessonDao has:
- method for adding a lesson
- method for removing a lesson
- method for getting all lessons
- method for getting a lesson by ID

The LessonDao class interacts with the database and returns objects of type Lesson