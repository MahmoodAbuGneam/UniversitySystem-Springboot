package com.mst.newspringbootproject.repos;

import com.mst.newspringbootproject.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
