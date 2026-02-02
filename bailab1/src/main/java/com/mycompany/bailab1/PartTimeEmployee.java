/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bailab1;

/**
 *
 * @author HP
 */
public class PartTimeEmployee extends Employee {
    private int workHours;
    private double salaryPerHour;

    public PartTimeEmployee(String id, String name, int workHours, double salaryPerHour) {
        super(id, name);
        this.workHours = workHours;
        this.salaryPerHour = salaryPerHour;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    @Override
    public double getSalary() {
        return workHours * salaryPerHour;
    }

    @Override
    public String toString() {
        return String.format("PartTimeEmployee[id=%s, name=%s, workHours=%d, salaryPerHour=%.2f, salary=%.2f]",
                id, name, workHours, salaryPerHour, getSalary());
    }
}


