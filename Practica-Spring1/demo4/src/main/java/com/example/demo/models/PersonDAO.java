package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {


    List<Person> people = new ArrayList<>();

    public PersonDAO() {

        people.add(new Person(1, "Juan David", "3214914812"));
        people.add(new Person(2, "Pedro", "3214914813"));
        people.add(new Person(3, "Lucas", "3214914814"));
        people.add(new Person(4, "Gabriel", "3214914815"));
        people.add(new Person(5, "Maria", "3214914816"));
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public Person findPerson(int id) {
        for (Person p : people) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public List<Person> getPeople() {
        return people;
    }

    public boolean removePerson(int id) {
        Person person = this.findPerson(id);
        return this.people.remove(person);
    }

    public boolean updatePerson(Person updatedData) {
        Person person = this.findPerson(updatedData.getId());
        person.setName(updatedData.getName());
        person.setPhone(updatedData.getPhone());

        return this.findPerson(person.getId()).getName().equals(updatedData.getName());
    }
}
