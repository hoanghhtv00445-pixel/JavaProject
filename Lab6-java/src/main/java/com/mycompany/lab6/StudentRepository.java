/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haghe
 */
class StudentRepository {

  public List<Student> getAll() {
    String sql = "SELECT * FROM student";
    
    List<Student> list = new ArrayList<>(); 

    
    try (Connection conn = DBConnect.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            
            list.add(new Student(
                rs.getInt("student_id"),
                rs.getString("student_name"),
                rs.getString("gender"),
                rs.getDouble("gpa")
            ));
        }
    } catch (SQLException e) {
    }
    return list; 
}
    
}
