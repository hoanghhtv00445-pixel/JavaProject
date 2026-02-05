/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labs.Lab5;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author HP
 */
public class Service {
    private ArrayList<SinhVien> ds;

    
    private static final Pattern ID_PATTERN = Pattern.compile("^SV\\d{3}$", Pattern.CASE_INSENSITIVE);
    
    private static final Pattern NAME_PATTERN = Pattern.compile("^[\\p{L} ]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^0\\d{9}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$");

    public Service() {
        ds = new ArrayList<>();
    }

    public ArrayList<SinhVien> getDs() {
        return ds;
    }

    public boolean idExists(String id) {
        if (id == null) {
            return false;
        }
        String k = id.trim();
        for (SinhVien s : ds) {
            if (s.getId().equalsIgnoreCase(k)) {
                return true;
            }
        }
        return false;
    }

    public void addSinhVienInteractive(Scanner sc) {
        String id;
        while (true) {
            System.out.print("Nhập id (SVxxx, x là chữ số): ");
            id = sc.nextLine().trim().toUpperCase();
            if (!ID_PATTERN.matcher(id).matches()) {
                System.out.println("Id không hợp lệ (phải bắt đầu bằng SV và theo sau 3 chữ số).");
                continue;
            }
            if (idExists(id)) {
                System.out.println("Id đã tồn tại, nhập id khác.");
                continue;
            }
            break;
        }

        String name;
        while (true) {
            System.out.print("Nhập họ tên (chỉ chữ cái và khoảng trắng): ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name rỗng, nhập lại.");
                continue;
            }
            name = name.replaceAll("\\s+", " ");
            if (!NAME_PATTERN.matcher(name).matches()) {
                System.out.println("Name chỉ chứa chữ cái và khoảng trắng. Nhập lại.");
                continue;
            }
            break;
        }

        String phone;
        while (true) {
            System.out.print("Nhập phone (bắt đầu 0 và 10 chữ số): ");
            phone = sc.nextLine().trim();
            if (!PHONE_PATTERN.matcher(phone).matches()) {
                System.out.println("Phone không hợp lệ. Ví dụ: 0912345678");
                continue;
            }
            break;
        }

        String email;
        while (true) {
            System.out.print("Nhập email: ");
            email = sc.nextLine().trim();
            if (!EMAIL_PATTERN.matcher(email).matches()) {
                System.out.println("Email không hợp lệ. Nhập lại.");
                continue;
            }
            break;
        }

        int age = readValidAge(sc); 

        SinhVien sv = new SinhVien(id, name, phone, email, age);
        ds.add(sv);
        System.out.println("Đã thêm sinh viên: " + sv);
    }

    public int readValidAge(Scanner sc) {
        int age = 0;
        boolean ok = false;
        try {
            while (!ok) {
                try {
                    System.out.print("Nhập tuổi (số nguyên > 0): ");
                    age = sc.nextInt();
                    sc.nextLine(); 
                    if (age <= 0) {
                        throw new Exception("Tuổi phải > 0");
                    }
                    ok = true;
                } catch (java.util.InputMismatchException ime) {
                    sc.nextLine(); 
                    System.out.println("Bạn phải nhập số nguyên. Nhập lại.");
                } catch (Exception e) {
                    System.out.println(e.getMessage() + ". Nhập lại.");
                }
            }
        } finally {
            System.out.println("Kết thúc quá trình nhập dữ liệu");
        }
        return age;
    }

    public void printAll() {
        if (ds.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        for (SinhVien s : ds) {
            System.out.println(s);
        }
    }

    public SinhVien findById(String id) {
        if (id == null) {
            return null;
        }
        String k = id.trim();
        for (SinhVien s : ds) {
            if (s.getId().equalsIgnoreCase(k)) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<SinhVien> findByName(String key) {
        ArrayList<SinhVien> res = new ArrayList<>();
        if (key == null) {
            return res;
        }
        String k = key.trim().toLowerCase();
        for (SinhVien s : ds) {
            if (s.getName().toLowerCase().contains(k)) {
                res.add(s);
            }
        }
        return res;
    }

    public boolean updateNameById(String id, String newName) {
        SinhVien s = findById(id);
        if (s == null) {
            return false;
        }
        s.setName(newName.replaceAll("\\s+", " ").trim());
        return true;
    }

    public void processFullName(String rawName) {
        String norm = SinhVien.normalizeNameToUpper(rawName);
        int count = SinhVien.countCharsAfterTrim(rawName);
        System.out.println("Tên sau khi loại bỏ khoảng trắng và in hoa: " + norm);
        System.out.println("Độ dài kí tự của tên đã loại bỏ khoảng trắng: " + count);
    }
}


