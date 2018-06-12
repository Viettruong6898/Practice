package com.test.viet.Springmongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Students")
public class Student{
    @Id
    private String ID;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String name;
    private Address address;
    private Number phone;
    private int luckyNumber;

    protected Student(){};

    public Student(String name, String ID, Address address, Number phone, int LuckyNumber){
        this.name = name;
        this.ID = ID;
        this.address = address;
        this.phone = phone;
        this.luckyNumber = LuckyNumber;
}

    public String get(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public Address getaddress(){
        return address;
    }
    public Number getNum(){
        return phone;
    }
    public int getLuckyNumber() { return luckyNumber;
    }
}
