package com.example.demo;

import com.example.demo.models.Person;
import com.example.demo.models.PersonDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {

    PersonDAO people = new PersonDAO();

    @GetMapping("/people")
    public List<Person> getPeople() {
        return this.people.getPeople();
    }

    @GetMapping("/people/{id}")
    public Person getPeople(@PathVariable int id) {
        return this.people.findPerson(id);
    }

    @PostMapping("/people")
    public String addPerson(@RequestBody Person person) {
        this.people.addPerson(person);
        return "Success";
    }

    @DeleteMapping("/people/{id}")
    public boolean deletePeople(@PathVariable int id) {
        return this.people.removePerson(id);
    }

    @PatchMapping("/people/")
    public boolean updatePerson(@RequestBody Person person) {
        return this.people.updatePerson(person);
    }
}
