/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bailab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class lab6 {
    public static void main(String[] args) {
        ArrayList<Cylinder> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm cylinder");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tính tổng thể tích");
            System.out.println("4. Tìm cylinder có thể tích lớn nhất");
            System.out.println("5. Thêm dữ liệu mẫu");
            System.out.println("0. Thoát");
            System.out.print("Chọn (0-5): ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Nhập radius: ");
                    double r = readDouble(sc);
                    System.out.print("Nhập color: ");
                    String color = sc.nextLine().trim();
                    System.out.print("Nhập height: ");
                    double h = readDouble(sc);
                    list.add(new Cylinder(r, color, h));
                    System.out.println("Đã thêm.");
                    break;

                case "2":
                    if (list.isEmpty()) {
                        System.out.println("Danh sách rỗng.");
                    } else {
                        System.out.println("Danh sách cylinders:");
                        for (int i = 0; i < list.size(); i++) {
                            System.out.printf("[%d] %s%n", i + 1, list.get(i));
                        }
                    }
                    break;

                case "3":
                    double total = 0;
                    for (Cylinder c : list) {
                        total += c.getVolume();
                    }
                    System.out.printf("Tổng thể tích: %.3f%n", total);
                    break;

                case "4":
                    if (list.isEmpty()) {
                        System.out.println("Danh sách rỗng.");
                    } else {
                        Cylinder max = list.get(0);
                        for (Cylinder c : list) {
                            if (c.getVolume() > max.getVolume()) {
                                max = c;
                            }
                        }
                        System.out.println("Cylinder có thể tích lớn nhất:");
                        System.out.println(max);
                    }
                    break;

                case "5":
                    list.add(new Cylinder(2.5, "blue", 10.0));
                    list.add(new Cylinder(1.2, "red", 5.0));
                    list.add(new Cylinder(3.0, "green", 7.5));
                    System.out.println("Đã thêm dữ liệu mẫu.");
                    break;

                case "0":
                    running = false;
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }

        sc.close();
        System.out.println("Kết thúc chương trình.");
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.print("Không hợp lệ. Nhập lại số thực: ");
            }
        }
    }
}


