package com.test.viet.Springmongodb;

public class Number {
    private String three;
    private String four;

    public Number() {
    }

    public Number(String three, String four) {
        this.three = three;
        this.four = four;
    }

    public String getnumber(){
        return three + "-" + four;
    }
}
