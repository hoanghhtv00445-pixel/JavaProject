/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bailab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Service {
    private final ArrayList<Laptop> list;

    public Service() {
        list = new ArrayList<>();
    }

    // Trả về tham chiếu ArrayList (để main có thể truy cập nếu cần)
    public ArrayList<Laptop> getList() {
        return list;
    }

    // Kiểm tra id tồn tại (đơn giản, case-insensitive)
    public boolean idExists(String id) {
        if (id == null) return false;
        for (Laptop l : list) {
            if (l.getId().equalsIgnoreCase(id.trim())) return true;
        }
        return false;
    }

    // Thêm 1 laptop vào list (không kiểm tra trùng)
    public void addLaptop(Laptop l) {
        list.add(l);
    }

    // Nhập n laptop (ít kiểm tra, yêu cầu id không trùng)
    public void inputN(Scanner sc, int n) {
        while (list.size() < n) {
            System.out.println("\nNhập laptop thứ " + (list.size() + 1) + ":");
            System.out.print("Nhập id: ");
            String id = sc.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("Id rỗng, nhập lại.");
                continue;
            }
            if (idExists(id)) {
                System.out.println("Id đã tồn tại, nhập id khác.");
                continue;
            }

            Laptop l = new Laptop();
            l.setId(id);

            System.out.print("Nhập name: ");
            l.setName(sc.nextLine().trim());

            System.out.print("Nhập type: ");
            l.setType(sc.nextLine().trim());

            System.out.print("Nhập price: ");
            // đơn giản: assume nhập đúng số
            double p = Double.parseDouble(sc.nextLine().trim());
            l.setPrice(p);

            System.out.print("Nhập quantity: ");
            int q = Integer.parseInt(sc.nextLine().trim());
            l.setQuantity(q);

            list.add(l);
            System.out.println("Đã thêm: " + l);
        }
    }

    // In tất cả laptop
    public void printAll() {
        if (list.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        for (Laptop l : list) {
            l.output();
        }
    }

    // Tìm theo id chính xác hoặc name contains (case-insensitive)
    public ArrayList<Laptop> findByIdOrName(String key) {
        ArrayList<Laptop> res = new ArrayList<>();
        if (key == null) return res;
        String k = key.trim().toLowerCase();
        for (Laptop l : list) {
            if (l.getId().equalsIgnoreCase(k) || l.getName().toLowerCase().contains(k)) {
                res.add(l);
            }
        }
        return res;
    }

    // Tìm index theo id (trả -1 nếu không tìm)
    public int indexOfId(String id) {
        if (id == null) return -1;
        String k = id.trim();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(k)) return i;
        }
        return -1;
    }

    // Cập nhật name theo id
    public boolean updateNameById(String id, String newName) {
        int idx = indexOfId(id);
        if (idx == -1) return false;
        list.get(idx).setName(newName);
        return true;
    }

    // Trả về ArrayList các laptop trong khoảng [min, max], sắp theo price tăng dần
    public ArrayList<Laptop> findByPriceRange(double min, double max) {
        ArrayList<Laptop> res = new ArrayList<>();
        for (Laptop l : list) {
            if (l.getPrice() >= min && l.getPrice() <= max) res.add(l);
        }
        // sắp tăng dần theo price
        Collections.sort(res, new Comparator<Laptop>() {
            @Override
            public int compare(Laptop a, Laptop b) {
                return Double.compare(a.getPrice(), b.getPrice());
            }
        });
        return res;
    }

    // Sắp xếp chính danh sách theo name (alphabetical, case-insensitive)
    public void sortByName() {
        Collections.sort(list, new Comparator<Laptop>() {
            @Override
            public int compare(Laptop a, Laptop b) {
                return a.getName().toLowerCase().compareTo(b.getName().toLowerCase());
            }
        });
    }
}

