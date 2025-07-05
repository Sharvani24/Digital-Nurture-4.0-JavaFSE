package com.example.model;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    private int id;

    private String name;
    private int ram;
    private int hdd;
    private double cpuSpeed;
    private String os;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRam() { return ram; }
    public void setRam(int ram) { this.ram = ram; }

    public int getHdd() { return hdd; }
    public void setHdd(int hdd) { this.hdd = hdd; }

    public double getCpuSpeed() { return cpuSpeed; }
    public void setCpuSpeed(double cpuSpeed) { this.cpuSpeed = cpuSpeed; }

    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }
}
