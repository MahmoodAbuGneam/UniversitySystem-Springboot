package com.mst.newspringbootproject.repos;

import com.mst.newspringbootproject.beans.Course;
import com.mst.newspringbootproject.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
