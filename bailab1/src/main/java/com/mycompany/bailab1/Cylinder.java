/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bailab1;

/**
 *
 * @author HP
 */
    public class Cylinder extends Circle {

    private double height;

    // Constructor đầy đủ: radius + color + height
    public Cylinder(double radius, String color, double height) {
        super(radius, color);  // gọi constructor của Circle
        this.height = height;
    }

    // Getter / Setter cho height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Thể tích: diện tích đáy * height
    public double getVolume() {
        return getArea() * height; // getArea() từ Circle
    }

    @Override
    public String toString() {
        return String.format("Cylinder[radius=%.3f, color=%s, height=%.3f, baseArea=%.3f, volume=%.3f]",
                getRadius(), getColor(), height, getArea(), getVolume());
    }
}

