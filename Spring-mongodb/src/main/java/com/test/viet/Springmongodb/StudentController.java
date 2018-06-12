package com.test.viet.SRR"pringmongodb;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//this class displays all hotels we have in our database. Allows us to update etc
@RestController
//this is the url to access the data base, use /all to get the list of students
@RequestMapping("/students")
public class  StudentController {
    private StudentsResp studentsrep;

    public StudentController(StudentsResp studentsrep) {
        this.studentsrep = studentsrep;
    }

    @GetMapping("/alls")
    public List<Student> getAll() {
        List<Student> students = this.studentsrep.findAll();
        return students;
    }

    // this just insert data and not update
    @PutMapping
    public void insert(@RequestBody Student student) {
        this.studentsrep.insert(student);
    }

    // save method, if the student passed in dont have id  then it will insert else update.
    // can do both insert and update. Postmapping is using for updating
    @PostMapping
    public void update(@RequestBody Student student) {
        this.studentsrep.save(student);
    }
    // the id will be translated into the variable under it

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.studentsrep.deleteById(id);
    }
    //looking up a specific hotel by its id
    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable("id") String id) {
        Optional<Student> student = this.studentsrep.findById(id);
        return student;
    }
    @GetMapping("/price/{LuckyNumber}")
    public List<Student> getByLuckyNumberLessThan(@PathVariable("LuckyNumber") int luckyNumber) {
        List<Student> student = this.studentsrep.findByluckyNumberLessThan(luckyNumber);
        return student;
    }
    @GetMapping("/address/{city}")
    public List<Student> getByCity(@PathVariable("city") String city) {
        List<Student> student = this.studentsrep.findByCity(city);
        return student;
    }

}