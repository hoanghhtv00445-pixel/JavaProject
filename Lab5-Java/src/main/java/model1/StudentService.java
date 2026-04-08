/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model1;

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

public class StudentService {
    private List<Student1> danhSach;
    private final String tenFile;

    public StudentService(String tenFile) {
        this.tenFile = tenFile;
        this.danhSach = new ArrayList<>();
        docTuFile();
    }

    private void docTuFile() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream(tenFile)));

            Object obj = ois.readObject();

            if (obj instanceof List) {
                List<?> list = (List<?>) obj;
                danhSach = new ArrayList<>();
                for (Object item : list) {
                    if (item instanceof Student1 student1) {
                        danhSach.add(student1);
                    }
                }
                System.out.println("Đã tải " + danhSach.size() + " sinh viên từ file.");
            } else {
                System.out.println("[LỖI] Dữ liệu trong file không đúng định dạng.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Chưa có file dữ liệu, bắt đầu danh sách mới.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.err.println("Lỗi khi đóng file: " + e.getMessage());
                }
            }
        }
    }

    public void luuXuongFile() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream(tenFile)));
            oos.writeObject(danhSach);
            System.out.println("Đã lưu " + danhSach.size() + " sinh viên xuống file.");
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

    public void them(Student1 sv) {
        danhSach.add(sv);
        System.out.println("Đã thêm: " + sv);
    }

    public boolean xoa(String ma) {
        return danhSach.removeIf(sv -> sv.getMa().equals(ma));
    }

    public Student1 timTheoMa(String ma) {
        return danhSach.stream()
                .filter(sv -> sv.getMa().equals(ma))
                .findFirst()
                .orElse(null);
    }

    public void hienThi() {
        System.out.println("\n===== DANH SÁCH SINH VIÊN =====");
        if (danhSach.isEmpty()) {
            System.out.println("(Danh sách trống)");
        } else {
            for (int i = 0; i < danhSach.size(); i++) {
                System.out.println((i + 1) + ". " + danhSach.get(i));
            }
        }
        System.out.println("================================");
    }

    public List<Student1> getDanhSach() {
        return danhSach;
    }
}