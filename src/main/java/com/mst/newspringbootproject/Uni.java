package com.mst.newspringbootproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mst.newspringbootproject.beans.Course;
import com.mst.newspringbootproject.beans.Room;
import com.mst.newspringbootproject.beans.Student;
import com.mst.newspringbootproject.service.CourseService;
import com.mst.newspringbootproject.service.RoomService;
import com.mst.newspringbootproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class Uni implements CommandLineRunner {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private RoomService roomService;


    @Override
    public void run(String... args) throws Exception {
        // create new room and save it ...

        Room room = new Room();
        room.setRoomNumber("001");
        room.setBuilding("SW Building");
        roomService.saveOrUpdateRoom(room);


        // create a new course and save it
        Course course = new Course();
        course.setTitle("MST : Intro to MicroServices");
        course.setDescription("MicroServices with Dawood Kabha");
        course.setRoom(room);
        courseService.saveOrUpdateCourse(course);




        // create a new student
        Student student = new Student();
        student.setName("Mahmood Gneam");
        student.setEmail("mahmoodpsgn@gmail.com");
        student.setEnrolledCourses(new HashSet<>());
        student.getEnrolledCourses().add(course);
        studentService.saveOrUpdateStudent(student);


        // link course and student
        course.getStudents().add(student);
        courseService.saveOrUpdateCourse(course);


        // display details
        System.out.println("Courses in Room " + room.getRoomNumber() + ":");
        room.getCourses().forEach(c -> System.out.println(c.getTitle()));

        System.out.println("Students enrolled in " + course.getTitle() + ":");
        course.getStudents().forEach(s -> System.out.println(s.getName()));




    }
}
