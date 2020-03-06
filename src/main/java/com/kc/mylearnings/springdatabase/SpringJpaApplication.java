package com.kc.mylearnings.springdatabase;

import com.kc.mylearnings.springdatabase.entity.Person;
import com.kc.mylearnings.springdatabase.repository.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
//@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("User ID 10001 -> {}", personJpaRepository.findByID(10001));

		LOGGER.info("Inserting new person (10004) -> {}", personJpaRepository.insert(new Person("Saravanan", "Chicago", new Date())));

		LOGGER.info("Updating (10004) location -> {}", personJpaRepository.update(new Person(1, "Saravanan1", "Chennai", new Date())));

		personJpaRepository.deleteById(10002);

		LOGGER.info("All users -> {}", personJpaRepository.findAll());
	}
}
