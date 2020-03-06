package com.kc.mylearnings.springdatabase.springdata;

import com.kc.mylearnings.springdatabase.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {
}
