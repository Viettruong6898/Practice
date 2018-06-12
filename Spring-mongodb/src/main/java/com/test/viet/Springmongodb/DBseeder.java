package com.test.viet.Springmongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DBseeder implements CommandLineRunner {
    private StudentsResp studentres;

    // constructor for resp
    public DBseeder(StudentsResp studentres) {
        this.studentres = studentres;
    }
    @Override
    public void run(String... Strings) throws Exception{
        Student bob =
                new Student("Bob","3031",
                        new Address("Blewp","2451"),
                        new Number("714","7174"),58);
        Student sally =
                new Student("sally","5123",
                        new Address("hehe","0000"),
                        new Number("666","4125"),5);
        Student phreaky =
                new Student("phreaky","5012",
                        new Address("mary","4124"),
                        new Number("666","4125"),100);
        //empty out database using the given delete all command
        this.studentres.deleteAll();

        //adding hotels to database, adding to a list so that we dont have to call on each student
        List<Student> students = Arrays.asList(bob,sally,phreaky);
        this.studentres.saveAll(students);
    }

}
