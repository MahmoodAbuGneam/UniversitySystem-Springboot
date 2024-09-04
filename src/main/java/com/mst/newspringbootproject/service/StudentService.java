package com.mst.newspringbootproject.service;


import com.mst.newspringbootproject.beans.Course;
import com.mst.newspringbootproject.beans.Student;
import com.mst.newspringbootproject.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private CourseService courseService; // adding course service to use it in the enrollment

    // find student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // List all students
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    // save student
    public Student saveOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    // delete student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


    // enroll a student to a course by id's
    public Student enrollStudentInCourse(Long studentId , Long courseId){
        Student student = getStudentById(studentId).orElseThrow(() -> new RuntimeException("Student not found !"));

        Course course = courseService.findCourseById(courseId).orElseThrow(()-> new RuntimeException("Course not found!"));

        student.getEnrolledCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        return student;
    }
}
