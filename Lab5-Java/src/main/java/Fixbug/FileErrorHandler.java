/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fixbug;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;
import model1.Student1;

public class FileErrorHandler {

    public static List<Student1> docAnToan(String tenFile) {
        // ===== TRƯỜNG HỢP 1: File không tồn tại =====
        File file = new File(tenFile);
        if (!file.exists()) {
            System.out.println("[CẢNH BÁO] File '" + tenFile + "' không tồn tại.");
            System.out.println("→ Trả về danh sách rỗng, chương trình tiếp tục bình thường.");
            return new ArrayList<>();
        }

        // ===== TRƯỜNG HỢP 2: File rỗng =====
        if (file.length() == 0) {
            System.out.println("[CẢNH BÁO] File '" + tenFile + "' rỗng, không có dữ liệu.");
            System.out.println("→ Trả về danh sách rỗng, chương trình tiếp tục bình thường.");
            return new ArrayList<>();
        }

        // ===== TRƯỜNG HỢP 3: Dữ liệu không đúng định dạng =====
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            
            Object obj = ois.readObject();

            if (obj instanceof List) {
                List<?> list = (List<?>) obj;
                List<Student1> danhSach = new ArrayList<>();
                for (Object item : list) {
                    if (item instanceof Student1) {
                        danhSach.add((Student1) item);
                    }
                }
                System.out.println("[OK] Đọc thành công " + danhSach.size() + " sinh viên.");
                return danhSach;
            } else {
                System.out.println("[LỖI] Dữ liệu trong file không đúng định dạng.");
            }

        } catch (StreamCorruptedException e) {
            System.out.println("[LỖI] File bị hỏng hoặc không đúng định dạng nhị phân.");
            System.out.println("→ " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[LỖI] Dữ liệu trong file không khớp với class Student1.");
            System.out.println("→ " + e.getMessage());
        } catch (InvalidClassException e) {
            System.out.println("[LỖI] Phiên bản class không tương thích.");
            System.out.println("→ " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[LỖI] Lỗi đọc file: " + e.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.err.println("Lỗi khi đóng file: " + e.getMessage());
                }
            }
        }

        System.out.println("→ Trả về danh sách rỗng, chương trình tiếp tục bình thường.");
        return new ArrayList<>();
    }

    public static void main(String[] args) {

        System.out.println("========== TRƯỜNG HỢP 1: File không tồn tại ==========");
        List<Student1> ds1 = docAnToan("khong_ton_tai.dat");
        System.out.println("Kết quả: " + ds1.size() + " sinh viên\n");

        System.out.println("========== TRƯỜNG HỢP 2: File rỗng ==========");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("file_rong.dat");
        } catch (IOException e) {
            System.err.println("Không tạo được file rỗng: " + e.getMessage());
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    System.err.println("Lỗi khi đóng file: " + e.getMessage());
                }
            }
        }
        List<Student1> ds2 = docAnToan("file_rong.dat");
        System.out.println("Kết quả: " + ds2.size() + " sinh viên\n");

        System.out.println("========== TRƯỜNG HỢP 3: File sai định dạng ==========");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("sai_dinh_dang.dat"));
            bw.write("day la file text, khong phai binary");
        } catch (IOException e) {
            System.err.println("Không tạo được file test: " + e.getMessage());
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.err.println("Lỗi khi đóng file: " + e.getMessage());
                }
            }
        }
        List<Student1> ds3 = docAnToan("sai_dinh_dang.dat");
        System.out.println("Kết quả: " + ds3.size() + " sinh viên\n");

        System.out.println("========== TRƯỜNG HỢP 4: File hợp lệ ==========");
        List<Student1> danhSachGoc = new ArrayList<>();
        danhSachGoc.add(new Student1("SV001", "Nguyen Van An", 3.5));
        danhSachGoc.add(new Student1("SV002", "Tran Thi Bich", 3.8));
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream("hop_le.dat")));
            oos.writeObject(danhSachGoc);
        } catch (IOException e) {
            System.err.println("Không tạo được file hợp lệ: " + e.getMessage());
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.err.println("Lỗi khi đóng file: " + e.getMessage());
                }
            }
        }
        List<Student1> ds4 = docAnToan("hop_le.dat");
        System.out.println("Kết quả: " + ds4.size() + " sinh viên");
        ds4.forEach(sv -> System.out.println("  " + sv));
    }
}