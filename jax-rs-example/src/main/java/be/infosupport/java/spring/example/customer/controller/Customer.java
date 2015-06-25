package be.infosupport.java.spring.example.customer.controller;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

    @XmlElement
    private Integer id;
    @XmlElement
    private String name;
    @XmlElement
    private int age;

    //needed to allow creation from json/xml
    public Customer() {
    }

    public Customer(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Integer getId() {
        return id;
    }
}
