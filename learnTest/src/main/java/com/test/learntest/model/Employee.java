package com.test.learntest.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String dept;
}
