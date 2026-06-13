package com.idream.student;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentRepository studentRepository;

	@Test
	void shouldReturnAllStudents() throws Exception {

		Student s1 = new Student(1L, "Rahul Kumar", "rahul@gmail.com", 101L);

		Student s2 = new Student(2L, "Anil Das", "anil@gmail.com", 102L);

		when(studentRepository.findAll()).thenReturn(List.of(s1, s2));

		mockMvc.perform(get("/api/students")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].name").value("Rahul Kumar"))
				.andExpect(jsonPath("$[0].email").value("rahul@gmail.com"))
				.andExpect(jsonPath("$[1].name").value("Anil Das"));
	}
}