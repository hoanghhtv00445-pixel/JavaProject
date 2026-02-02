/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bailab1;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class lab5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Service service = new Service();

        System.out.println("=== Nhập 5 laptop khác nhau ===");
        service.inputN(sc, 5);

        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Hiển thị tất cả laptop");
            System.out.println("2. Xuất danh sách theo khoảng giá (min -> max)");
            System.out.println("3. Tìm laptop theo id hoặc name");
            System.out.println("4. Tìm laptop theo id và cập nhật name");
            System.out.println("5. Sắp xếp danh sách theo name và in");
            System.out.println("0. Thoát");
            System.out.print("Chọn (0-5): ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> service.printAll();
                case "2" -> {
                    double min = readDoubleSafe(sc, "Nhập min price: ");
                    double max = readDoubleSafe(sc, "Nhập max price: ");
                    if (min > max) { double t = min; min = max; max = t; }
                    List<Laptop> inRange = service.findByPriceRange(min, max);
                    if (inRange.isEmpty()) {
                        System.out.println("Không có laptop trong khoảng giá này.");
                    } else {
                        System.out.println("Laptop trong khoảng [" + min + " , " + max + "] (tăng dần theo price):");
                        inRange.forEach(Laptop::output);
                    }
                }
                case "3" -> {
                    System.out.print("Nhập id hoặc name để tìm: ");
                    String key = sc.nextLine().trim();
                    List<Laptop> found = service.findByIdOrName(key);
                    if (found.isEmpty()) {
                        System.out.println("Không tìm thấy kết quả.");
                    } else {
                        System.out.println("Tìm thấy " + found.size() + " kết quả:");
                        found.forEach(Laptop::output);
                    }
                }
                case "4" -> {
                    System.out.print("Nhập id cần cập nhật name: ");
                    String idToUpdate = sc.nextLine().trim();
                    int idx = service.indexOfId(idToUpdate);
                    if (idx == -1) {
                        System.out.println("Không tìm thấy id: " + idToUpdate);
                    } else {
                        System.out.println("Laptop hiện tại:");
                        service.getList().get(idx).output();
                        System.out.print("Nhập name mới: ");
                        String newName = sc.nextLine().trim();
                        if (newName.isEmpty()) {
                            System.out.println("Name mới rỗng -> không cập nhật.");
                        } else {
                            service.updateNameById(idToUpdate, newName);
                            System.out.println("Đã cập nhật. Thông tin mới:");
                            service.getList().get(idx).output();
                        }
                    }
                }
                case "5" -> {
                    service.sortByName();
                    System.out.println("Danh sách sau khi sắp theo name:");
                    service.printAll();
                }
                case "0" -> running = false;
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }

        sc.close();
        System.out.println("Kết thúc chương trình. Tạm biệt!");
    }

    private static double readDoubleSafe(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ. Nhập lại số thực.");
            }
        }
    }
}

