package com.idream.student;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StudentServiceApplication {
	public static void main(String[] a) {
		SpringApplication.run(StudentServiceApplication.class, a);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	CommandLineRunner init(StudentRepository r) {
		return args -> {
			if (r.count() == 0) {
				r.save(new Student(null, "Rahul Kumar", "rahul@example.com", 1L));
				r.save(new Student(null, "Sunil Das", "sunil@example.com", 1L));
				r.save(new Student(null, "Abinash Patra", "abinash@example.com", 2L));
			}
		};
	}
}
