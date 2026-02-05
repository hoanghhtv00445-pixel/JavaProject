/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labs.Lab5;

/**
 *
 * @author HP
 */
class SinhVien {
    private String id;
    private String name;
    private String phone;
    private String email;
    private int age;

    public SinhVien() {
    }

    public SinhVien(String id, String name, String phone, String email, int age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String normalizeNameToUpper(String rawName) {
        if (rawName == null) {
            return "";
        }
        String trimmed = rawName.trim();
        trimmed = trimmed.replaceAll("\\s+", " ");
        return trimmed.toUpperCase();
    }

    public static int countCharsAfterTrim(String rawName) {
        if (rawName == null) {
            return 0;
        }
        String trimmed = rawName.trim();
        
        return trimmed.length();
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Phone: %s | Email: %s | Age: %d",
                id, name, phone, email, age);
    }
}


