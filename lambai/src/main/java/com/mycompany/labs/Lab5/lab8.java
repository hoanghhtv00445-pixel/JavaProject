/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labs.Lab5;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class lab8 {
    public static void main(String[] args) {
        Service svc = new Service();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== QUẢN LÝ SINH VIÊN ===");
            System.out.println("1. Thêm sinh viên (nhập và kiểm tra regex)");
            System.out.println("2. Hiển thị tất cả sinh viên");
            System.out.println("3. Tìm theo id");
            System.out.println("4. Tìm theo name");
            System.out.println("5. Cập nhật name theo id");
            System.out.println("6. Bài 1: Xử lý họ tên (xóa khoảng trắng, in hoa, đếm)");
            System.out.println("0. Thoát");
            System.out.print("Chọn (0-6): ");

            String ch = sc.nextLine().trim();
            switch (ch) {
                case "1":
                    svc.addSinhVienInteractive(sc);
                    break;
                case "2":
                    svc.printAll();
                    break;
                case "3":
                    System.out.print("Nhập id cần tìm: ");
                    String id = sc.nextLine().trim();
                    SinhVien found = svc.findById(id);
                    if (found == null) {
                        System.out.println("Không tìm thấy id: " + id);
                    } else {
                        System.out.println(found);
                    }
                    break;
                case "4":
                    System.out.print("Nhập chuỗi name để tìm: ");
                    String key = sc.nextLine().trim();
                    ArrayList<SinhVien> res = svc.findByName(key);
                    if (res.isEmpty()) {
                        System.out.println("Không tìm thấy.");
                    } else {
                        System.out.println("Tìm thấy " + res.size() + " kết quả:");
                        for (SinhVien s : res) {
                            System.out.println(s);
                        }
                    }
                    break;
                case "5":
                    System.out.print("Nhập id cần cập nhật name: ");
                    String idUp = sc.nextLine().trim();
                    System.out.print("Nhập name mới: ");
                    String newName = sc.nextLine().trim();
                    if (svc.updateNameById(idUp, newName)) {
                        System.out.println("Đã cập nhật.");
                    } else {
                        System.out.println("Cập nhật thất bại: không tìm thấy id.");
                    }
                    break;
                case "6":
                    System.out.print("Nhập họ tên (chuỗi): ");
                    String raw = sc.nextLine();
                    svc.processFullName(raw);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Thử lại.");
            }
        }

        sc.close();
        System.out.println("Kết thúc chương trình.");
    }
}


