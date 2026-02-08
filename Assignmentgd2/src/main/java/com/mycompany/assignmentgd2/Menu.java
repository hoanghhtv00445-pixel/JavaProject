/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentgd2;

import java.util.Scanner;



/**
 *
 * @author HP
 */
public class Menu {
     public static void main(String[] args) {
        Service svc = new Service();
         try (Scanner sc = new Scanner(System.in)) {
             svc.loadSample();
             
             boolean running = true;
             while (running) {
                 System.out.println("\n--- MENU ---");
                 System.out.println("1. Nhập sản phẩm ");
                 System.out.println("2. Hiển thị tất cả");
                 System.out.println("3. Hiển thị sản phẩm Điện tử");
                 System.out.println("4. Hiển thị sản phẩm Tiêu dùng");
                 System.out.println("5. Tính thành tiền theo mã sản phẩm");
                 System.out.println("6. Cập nhật sản phẩm theo mã");
                 System.out.println("7. Tìm sản phẩm theo mã");
                 System.out.println("8. Xóa sản phẩm theo mã");
                 System.out.println("9. Sắp xếp theo tên");
                 System.out.println("0. Thoát");
                 System.out.print("Chọn: ");
                 
                 String ch = sc.nextLine().trim();
                 switch (ch) {
                     case "1" -> svc.addProductInteractive(sc);
                     case "2" -> svc.printAll();
                     case "3" -> {
                         for (SanPhamDienTu dt : svc.getDienTu()) {
                             dt.Xuat();
                         }
                     }
                     case "4" -> {
                         for (SanPhamTieuDung td : svc.getTieuDung()) {
                             td.Xuat();
                         }
                     }
                     case "5" -> {
                         System.out.print("Nhập mã SP: ");
                         String ma = sc.nextLine().trim();
                         System.out.print("Nhập số lượng mua: ");
                         int q = Integer.parseInt(sc.nextLine().trim());
                         Double total = svc.computeTotalByMaAndQty(ma, q);
                         if (total == null) {
                             System.out.println("Không tìm thấy mã.");
                         } else {
                             System.out.printf("Thành tiền = %.2f%n", total);
                         }
                     }
                     case "6" -> {
                         System.out.print("Nhập mã cần cập nhật: ");
                         String maup = sc.nextLine().trim();
                         if (svc.updateByMaInteractive(maup, sc)) {
                             System.out.println("Đã cập nhật.");
                         } else {
                             System.out.println("Không tìm thấy mã.");
                         }
                     }
                     case "7" -> {
                         System.out.print("Nhập mã tìm kiếm: ");
                         String mas = sc.nextLine().trim();
                         SanPham f = svc.findByMa(mas);
                         if (f == null) {
                             System.out.println("Không tìm thấy.");
                         } else {
                             f.Xuat();
                         }
                     }
                     case "8" -> {
                         System.out.print("Nhập mã cần xóa: ");
                         String mad = sc.nextLine().trim();
                         if (svc.removeByMa(mad)) {
                             System.out.println("Đã xóa.");
                         } else {
                             System.out.println("Không tìm thấy mã.");
                         }
                     }
                     case "9" -> {
                         svc.sortByName();
                         System.out.println("Đã sắp xếp theo tên.");
                     }
                     case "0" -> running = false;
                     default -> System.out.println("Lựa chọn không hợp lệ.");
                 }
             }}
        System.out.println("Kết thúc.");
    }
}
