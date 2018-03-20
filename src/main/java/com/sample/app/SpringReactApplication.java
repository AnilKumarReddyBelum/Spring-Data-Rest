package com.sample.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.sample.app.model.Student;
import com.sample.app.repository.StudentRepository;

@SpringBootApplication
public class SpringReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactApplication.class, args);
	}

	@Component
	public class DatabaseLoader implements CommandLineRunner {

		private final StudentRepository repository;

		@Autowired
		public DatabaseLoader(StudentRepository repository) {
			this.repository = repository;
		}

		@Override
		public void run(String... strings) throws Exception {
			this.repository.save(new Student(null,"anil-1","hyd-1"));
			this.repository.save(new Student(null,"anil-2","hyd-2"));
			this.repository.save(new Student(null,"anil-3","hyd-3"));
			this.repository.save(new Student(null,"anil-4","hyd-4"));
		}
	}

}
