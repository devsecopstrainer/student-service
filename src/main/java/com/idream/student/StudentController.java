package com.idream.student;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {
	private final StudentRepository repo;
	private final RestTemplate rest;
	@Value("${course.service.url}")
	String courseUrl;

	StudentController(StudentRepository repo, RestTemplate rest) {
		this.repo = repo;
		this.rest = rest;
	}

	@GetMapping
	public List<Student> all() {
		return repo.findAll();
	}

	@PostMapping
	public Student create(@RequestBody Student s) {
		return repo.save(s);
	}

	@GetMapping("/course/{courseId}")
	public List<Student> byCourse(@PathVariable Long courseId) {
		return repo.findByCourseId(courseId);
	}

	@GetMapping("/{id}/course")
	public Object studentCourse(@PathVariable Long id) {
		Student s = repo.findById(id).orElseThrow();
		return rest.getForObject(courseUrl + "/api/courses/" + s.courseId, Object.class);
	}
}
