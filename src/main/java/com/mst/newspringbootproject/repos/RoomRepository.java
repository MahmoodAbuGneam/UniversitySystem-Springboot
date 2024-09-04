package com.mst.newspringbootproject.repos;

import com.mst.newspringbootproject.beans.Room;
import com.mst.newspringbootproject.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
