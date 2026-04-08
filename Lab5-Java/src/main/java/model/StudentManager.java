/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    public static void luuDanhSach(String tenFile, List<Student> danhSach) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream(tenFile)));
            oos.writeObject(danhSach);
            System.out.println("Lưu thành công " + danhSach.size() + " sinh viên vào: " + tenFile);
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu file: " + e.getMessage());
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.err.println("Lỗi khi đóng file: " + e.getMessage());
                }
            }
        }
    }

    public static List<Student> docDanhSach(String tenFile) {
        List<Student> danhSach = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream(tenFile)));

            Object obj = ois.readObject();

            if (obj instanceof List) {
                List<?> list = (List<?>) obj;
                danhSach = new ArrayList<>();
                for (Object item : list) {
                    if (item instanceof Student) {
                        danhSach.add((Student) item);
                    }
                }
                System.out.println("Đọc thành công " + danhSach.size() + " sinh viên từ: " + tenFile);
            } else {
                System.out.println("[LỖI] Dữ liệu trong file không đúng định dạng.");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file: " + tenFile);
        } catch (IOException e) {
            System.err.println("Lỗi IO: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi class: " + e.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.err.println("Lỗi khi đóng file: " + e.getMessage());
                }
            }
        }
        return danhSach;
    }

    public static void hienThiDanhSach(List<Student> danhSach) {
        System.out.println("\n===== DANH SÁCH SINH VIÊN =====");
        if (danhSach.isEmpty()) {
            System.out.println("(Danh sách trống)");
            return;
        }
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println((i + 1) + ". " + danhSach.get(i));
        }
        System.out.println("================================");
    }
}