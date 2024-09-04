package com.mst.newspringbootproject.service;


import com.mst.newspringbootproject.beans.Course;
import com.mst.newspringbootproject.beans.Room;
import com.mst.newspringbootproject.beans.Student;
import com.mst.newspringbootproject.repos.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // find a course by ID
    public Optional<Course> findCourseById(Long id) {
        return courseRepository.findById(id);
    }


    // List all courses
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }


    // Save or update course
    public Course saveOrUpdateCourse(Course course) {
        return courseRepository.save(course);
    }

    // delete a course
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }


    // assign a room to a course

    public Course assignRoomToCourse(Long courseId, Room room){
        Course course = findCourseById(courseId).orElseThrow(()-> new RuntimeException("Course not found"));
        course.setRoom(room);
        return courseRepository.save(course);
    }




}
