package com.kc.mylearnings.springdatabase.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
//Create namedQuery for JPA to do select-all on persons
@NamedQuery(name = "find_all_persons", query = "select p from Person p")
//@Table(name="person") //Table mapping annotation is not needed here since the Table name matches the entity name
public class Person {

    //@Id defines JPA that this field is the PK for table.
    @Id
    @GeneratedValue
    private int id;
    //@Column(name="nameOfField") //This is not needed here since the DB column name matches the object.
    private String name;
    private String location;
    private Date birthDate;

    public Person() {
    }

    //This constructor is created for JPA Entity. Note that ID will be generated by JPA and hence removed from constructor params.
    public Person(String name, String location, Date birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public Person(int id, String name, String location, Date birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}