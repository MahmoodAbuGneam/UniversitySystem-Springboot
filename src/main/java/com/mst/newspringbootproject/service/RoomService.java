package com.mst.newspringbootproject.service;


import com.mst.newspringbootproject.beans.Course;
import com.mst.newspringbootproject.beans.Room;
import com.mst.newspringbootproject.repos.RoomRepository;
import com.mst.newspringbootproject.repos.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;



    @Autowired
    private CourseService courseService; // adding Course Service to use it

    // find a room by ID
    public Optional<Room> findRoomById(Long id) {
        return roomRepository.findById(id);
    }

    // list all rooms
    public List<Room> findAllRooms(){
        return roomRepository.findAll();
    }


    public Room saveOrUpdateRoom(Room room) {
        return roomRepository.save(room);
    }

    // delete a room
    public void deleteRoom(Long id){
        roomRepository.deleteById(id);
    }




    // add a course to a room
    public Room addCourseToRoom(Long roomId, Long courseId){
        Room room = findRoomById(roomId).orElseThrow(() -> new RuntimeException("Room not found!"));


         Course course = courseService.findCourseById(courseId).get();
         room.getCourses().add(course);
         course.setRoom(room);
        return roomRepository.save(room);

    }


}
