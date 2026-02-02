/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bailab1;

/**
 *
 * @author HP
 */
public class FullTimeEmployee extends Employee {
    private double basicSalary;

    public FullTimeEmployee(String id, String name, double basicSalary) {
        super(id, name);
        this.basicSalary = basicSalary;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public double getSalary() {
        return basicSalary;
    }

    @Override
    public String toString() {
        return String.format("FullTimeEmployee[id=%s, name=%s, basicSalary=%.2f, salary=%.2f]",
                id, name, basicSalary, getSalary());
    }
}

