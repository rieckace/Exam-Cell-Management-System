CREATE DATABASE ExamCell;
USE ExamCell;

CREATE TABLE Users (
    UserId INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(50),
    Password VARCHAR(255),
    Role VARCHAR(20)
);

insert into Users
values(1,'rieckace','7263','Student');

insert into Users
values(4,'raman@123','1234','Admin');

select * from Users;
select * from Courses;

CREATE TABLE Courses (
    CourseId INT PRIMARY KEY AUTO_INCREMENT,
    CourseCode VARCHAR(20),
    CourseName VARCHAR(100),
    Credits INT
);

insert into courses values(1,'U23cs125','ADD', 3);
insert into courses values(2,'U23cs120','MATH', 4);
CREATE TABLE Students (
    StudentId INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(50),
    RollNumber VARCHAR(20),
    Department VARCHAR(50)
);



CREATE TABLE Marks (
    MarkId INT PRIMARY KEY AUTO_INCREMENT,
    StudentId INT,
    CourseId INT,
    MarksObtained INT,
    MaxMarks INT,
    FOREIGN KEY (StudentId) REFERENCES Students(StudentId),
    FOREIGN KEY (CourseId) REFERENCES Courses(CourseId)
);
