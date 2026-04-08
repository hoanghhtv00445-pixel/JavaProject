/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static model.StudentManager.docDanhSach;
import java.util.ArrayList;
import java.util.List;
import static model.StudentManager.hienThiDanhSach;
import static model.StudentManager.luuDanhSach;


/**
 *
 * @author haghe
 */
public class menu {
        public static void main(String[] args) {
        String tenFile = "students.dat";
        List<Student> danhSach = new ArrayList<>();
        danhSach.add(new Student("SV001", "Nguyen Van An", 3.5));
        danhSach.add(new Student("SV002", "Tran Thi Bich", 3.8));
        danhSach.add(new Student("SV003", "Le Van Cuong", 2.9));
        danhSach.add(new Student("SV004", "Pham Thi Dung", 3.2));
        System.out.println(">> Trước khi lưu:");
        hienThiDanhSach(danhSach);
        luuDanhSach(tenFile, danhSach);
        System.out.println("\n>> Đọc lại từ file:");
        List<Student> danhSachDoc = docDanhSach(tenFile);
        hienThiDanhSach(danhSachDoc);
    }
}
