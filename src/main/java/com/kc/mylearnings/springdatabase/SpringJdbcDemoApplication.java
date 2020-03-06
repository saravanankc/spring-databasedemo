package com.kc.mylearnings.springdatabase;

import com.kc.mylearnings.springdatabase.entity.Person;
import com.kc.mylearnings.springdatabase.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao personJdbcDao;
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LOGGER.info("All users -> {}", personJdbcDao.findAll());

		LOGGER.info("User ID 10001 -> {}", personJdbcDao.findByID(10001));

		LOGGER.info("Deleting User ID 10002 -> rows effected {}", personJdbcDao.deleteByID(10002));

		LOGGER.info("Inserting new person (10004) -> {}", personJdbcDao.insert(new Person(10004, "Saravanan", "Chicago", new Date())));

		LOGGER.info("Updating (10004) location -> {}", personJdbcDao.update(new Person(10004, "Saravanan", "Chennai", new Date())));

	}
}
