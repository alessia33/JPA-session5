package com.example.internship;

import com.example.internship.dao.StudentDAO;
import com.example.internship.entities.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // Create a new student
        Student student = new Student("John Doe", "john.doe@example.com");
        studentDAO.createStudent(student);
        System.out.println("Student created: " + student.getName());

        // Read all students
        List<Student> students = studentDAO.getAllStudents();
        System.out.println("All Students:");
        for (Student s : students) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Email: " + s.getEmail());
        }

        // Update a student
        Student existingStudent = studentDAO.getStudentById(student.getId());
        existingStudent.setName("John Updated");
        studentDAO.updateStudent(existingStudent);
        System.out.println("Updated Student: " + existingStudent.getName());

        // Delete a student
        studentDAO.deleteStudent(student.getId());
        System.out.println("Student deleted.");
    }
}
