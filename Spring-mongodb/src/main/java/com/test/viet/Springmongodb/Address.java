package com.test.viet.Springmongodb;

public class Address {
    private String city;
    private String number;

    protected Address(){}

    public Address(String city, String number){
        this.city = city;
        this.number = number;
    }

    public String getAddy() {

        return number + " " + city;
    }
}
