package com.idream.student;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByCourseId(Long courseId);
}
