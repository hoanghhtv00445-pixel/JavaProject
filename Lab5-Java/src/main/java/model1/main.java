/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model1;

import model.*;

/**
 *
 * @author haghe
 */
public class main {
    public static void main(String[] args) {
        String tenFile = "students.dat";

        // Khởi động: tự động đọc file
        StudentService service = new StudentService(tenFile);

        // Thêm sinh viên
        service.them(new Student1("SV001", "Nguyen Van An", 3.5));
        service.them(new Student1("SV002", "Tran Thi Bich", 3.8));
        service.them(new Student1("SV003", "Le Van Cuong", 2.9));

        // Hiển thị
        service.hienThi();

        // Tìm kiếm
        Student1 found = service.timTheoMa("SV002");
        System.out.println("\nTìm SV002: " + (found != null ? found : "Không tìm thấy"));

        // Xóa
        boolean xoaOk = service.xoa("SV001");
        System.out.println("Xóa SV001: " + (xoaOk ? "Thành công" : "Không tìm thấy"));

        // Hiển thị sau khi xóa
        service.hienThi();

        // Kết thúc: tự động lưu file
        service.luuXuongFile();
    }
}
