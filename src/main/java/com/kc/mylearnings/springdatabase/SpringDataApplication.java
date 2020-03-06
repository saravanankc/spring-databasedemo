package com.kc.mylearnings.springdatabase;

import com.kc.mylearnings.springdatabase.entity.Person;
import com.kc.mylearnings.springdatabase.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository personSpringDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("User ID 10001 -> {}", personSpringDataRepository.findById(10001));

		LOGGER.info("Inserting new person (10004) -> {}", personSpringDataRepository.save(new Person("Saravanan", "Chicago", new Date())));

		LOGGER.info("Updating (10004) location -> {}", personSpringDataRepository.save(new Person(1, "Saravanan22", "Chennai", new Date())));

		personSpringDataRepository.deleteById(10002);

		LOGGER.info("All users -> {}", personSpringDataRepository.findAll());
	}
}
