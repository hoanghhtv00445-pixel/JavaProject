/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model1;

import java.io.Serializable;

/**
 *
 * @author haghe
 */
public class Student1 implements Serializable {
    private String Ma;
    private String ten;
    private double gpa;

    public Student1(String Ma, String ten, double gpa) {
        this.Ma = Ma;
        this.ten = ten;
        this.gpa = gpa;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student1{" + "Ma=" + Ma + ", ten=" + ten + ", gpa=" + gpa + '}';
    }

}
