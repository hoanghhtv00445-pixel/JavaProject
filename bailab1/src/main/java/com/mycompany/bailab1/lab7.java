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
public class lab7 {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(new FullTimeEmployee("FT001", "Nguyen Van A", 1500.0));
        staff.add(new PartTimeEmployee("PT001", "Le Thi B", 80, 10.0));

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm FullTimeEmployee");
            System.out.println("2. Thêm PartTimeEmployee");
            System.out.println("3. In thông tin tất cả nhân viên (và lương tương ứng)");
            System.out.println("4. Tính tổng lương (payroll)");
            System.out.println("5. Thêm dữ liệu mẫu (nhiều nhân viên)");
            System.out.println("0. Thoát");
            System.out.print("Chọn (0-5): ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Nhập id: ");
                    String ftId = sc.nextLine().trim();
                    System.out.print("Nhập name: ");
                    String ftName = sc.nextLine().trim();
                    System.out.print("Nhập basicSalary: ");
                    double basic = readDouble(sc);
                    staff.add(new FullTimeEmployee(ftId, ftName, basic));
                    System.out.println("Đã thêm FullTimeEmployee.");
                    break;

                case "2":
                    System.out.print("Nhập id: ");
                    String ptId = sc.nextLine().trim();
                    System.out.print("Nhập name: ");
                    String ptName = sc.nextLine().trim();
                    System.out.print("Nhập workHours (int): ");
                    int hours = readInt(sc);
                    System.out.print("Nhập salaryPerHour: ");
                    double rate = readDouble(sc);
                    staff.add(new PartTimeEmployee(ptId, ptName, hours, rate));
                    System.out.println("Đã thêm PartTimeEmployee.");
                    break;

                case "3":
                    if (staff.isEmpty()) {
                        System.out.println("Danh sách rỗng.");
                    } else {
                        System.out.println("Danh sách nhân viên và lương:");
                        for (Employee e : staff) {
                            System.out.println(e.toString());
                            System.out.printf(" -> Salary = %.2f%n", e.getSalary());
                        }
                    }
                    break;

                case "4":
                    double total = 0.0;
                    for (Employee e : staff) {
                        total += e.getSalary();
                    }
                    System.out.printf("Tổng lương phải trả (payroll) = %.2f%n", total);
                    break;

                case "5":
                    staff.add(new FullTimeEmployee("FT002", "Tran Van C", 2000.0));
                    staff.add(new PartTimeEmployee("PT002", "Pham Thi D", 60, 12.0));
                    System.out.println("Đã thêm dữ liệu mẫu (2 nhân viên).");
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

    private static int readInt(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Không hợp lệ. Nhập lại số nguyên: ");
            }
        }
    }
}

