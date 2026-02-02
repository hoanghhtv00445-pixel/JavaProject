/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bailab1;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Laptop {

    private String id;
    private String name;
    private String type;
    private double price;
    private int quantity;

    public Laptop() {
        this.id = "";
        this.name = "";
        this.type = "";
        this.price = 0.0;
        this.quantity = 0;
    }

    public Laptop(String id, String name, String type, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    // getters / setters
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // input: đọc thông tin laptop từ Scanner (có kiểm tra cơ bản)
    public void input(Scanner sc) {
        System.out.print("Nhập id: ");
        this.id = sc.nextLine().trim();

        System.out.print("Nhập name: ");
        this.name = sc.nextLine().trim();

        System.out.print("Nhập type: ");
        this.type = sc.nextLine().trim();

        // đọc price an toàn
        while (true) {
            System.out.print("Nhập price: ");
            String line = sc.nextLine().trim();
            try {
                double p = Double.parseDouble(line);
                if (p < 0) {
                    System.out.println("Price phải >= 0. Nhập lại.");
                    continue;
                }
                this.price = p;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ. Nhập lại số thực.");
            }
        }

        // đọc quantity an toàn
        while (true) {
            System.out.print("Nhập quantity: ");
            String line = sc.nextLine().trim();
            try {
                int q = Integer.parseInt(line);
                if (q < 0) {
                    System.out.println("Quantity phải >= 0. Nhập lại.");
                    continue;
                }
                this.quantity = q;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ. Nhập lại số nguyên.");
            }
        }
    }

    // output: in ra 1 laptop
    public void output() {
        System.out.printf("ID: %s | Name: %s | Type: %s | Price: %.2f | Quantity: %d%n",
                id, name, type, price, quantity);
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %.2f - %d",
                id, name, type, price, quantity);
    }
}


