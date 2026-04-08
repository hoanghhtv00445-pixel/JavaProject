/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author haghe
 */
public class Main {
    public static void main(String[] args) {
        StudentRepository repo = new StudentRepository();
        List<Student> allStudents = repo.getAll();

        
        System.out.println("--- DANH SÁCH SINH VIÊN CÓ GPA > 3.0 ---");
        List<Student> excellentStudents = allStudents.stream()
                .filter(s -> s.getGpa() > 3.0)
                .collect(Collectors.toList());

        excellentStudents.forEach(System.out::println);
    }
}
