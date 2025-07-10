
/*
 * File: Country.java
 * Description: Represents a Country bean used in Spring Boot.
 */

package com.example.demo.model;

public class Country {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
