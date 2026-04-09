/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.NhaTro;
import service.Caulenh_QuanLyNhaTro;
import service.Caulenh_QuanLyDanhGia;
import service.Caulenh_QuanLyNguoiDung;
import model.DanhGia;
import model.NguoiDung;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dang
 */
public class main {

    // Khởi tạo các Service dùng chung
    static Caulenh_QuanLyNhaTro code = new Caulenh_QuanLyNhaTro();
    static Caulenh_QuanLyDanhGia DG = new Caulenh_QuanLyDanhGia();
    static Caulenh_QuanLyNguoiDung ND = new Caulenh_QuanLyNguoiDung();
    static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= HỆ THỐNG QUẢN LÝ NHÀ TRỌ =========");
            System.out.println("1. Đăng nhập với quyền QUẢN LÝ");
            System.out.println("2. Đăng nhập với quyền NHÂN VIÊN");
            System.out.println("0. Thoát chương trình");
            System.out.print("=> Chọn vai trò: ");

            int vaiTro = Integer.parseInt(Sc.nextLine());

            switch (vaiTro) {
                case 1:
                    menuQuanLy();
                    break;
                case 2:
                    menuNhanVien();
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // --- Menu Dành Cho Quản Trị Viên ---
    public static void menuQuanLy() {
        while (true) {
            System.out.println("\n----- [QUẢN LÝ] Bảng Điều Khiển -----");
            System.out.println("1. Xem danh sách nhà trọ");
            System.out.println("2. Cập nhật giá phòng theo thị trường");
            System.out.println("3. Thêm nhà trọ mới");
            System.out.println("4. Xóa nhà trọ theo ID");
            System.out.println("5. Xem danh sách Người dùng");
            System.out.println("6. Xóa nhà trọ 'Toxic' (Dislike cao)");
            System.out.println("7. Xóa người dùng chuyển đi");
            System.out.println("0. Đăng xuất");
            System.out.print("=> Chọn chức năng: ");

            int chon = Integer.parseInt(Sc.nextLine());
            if (chon == 0) {
                break;
            }

            switch (chon) {
                case 1:
                    hienThiDanhSachNhaTro();
                    break;
                case 2:
                    System.out.print("Nhập ID phòng trọ cần đổi giá: ");
                    int idSua = Integer.parseInt(Sc.nextLine());
                    System.out.print("Nhập giá mới: ");
                    int giaMoi = Integer.parseInt(Sc.nextLine());
                    if (code.updategiaphong(idSua, giaMoi)) {
                        System.out.println("Cập nhật thành công!");
                    } else {
                        System.out.println("Không tìm thấy ID cần sửa!");
                    }
                    break;
                case 3:
                    themNhaTroMoi();
                    break;
                case 4:
                    System.out.print("Nhập ID nhà trọ cần xóa: ");
                    int idXoa = Integer.parseInt(Sc.nextLine());
                    if (code.xoaNhaTro(idXoa)) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Xóa thất bại!");
                    }
                    break;
                case 5:
                    hienThiDanhSachNguoiDung();
                    break;
                case 6:
                    System.out.print("Nhập ngưỡng Dislike để xóa (Ví dụ: 5): ");
                    int nguong = Integer.parseInt(Sc.nextLine());
                    code.xoaNhaTroToxic(nguong);
                    break;
                case 7:
                    xoaNguoiDungKhoiHeThong();
                    break;
            }
        }
    }

    // ---Menu Dành Cho Người Dùng---
    public static void menuNhanVien() {
        while (true) {
            System.out.println("\n----- [NGƯỜI DÙNG] Giao Diện Chức Năng -----");
            System.out.println("1. Xem danh sách nhà trọ");
            System.out.println("2. Xem tất cả đánh giá");
            System.out.println("3. Viết đánh giá mới");
            System.out.println("4. Đăng ký thành viên mới (Người dùng)");
            System.out.println("5. Cập nhật lại đánh giá");
            System.out.println("0. Đăng xuất");
            System.out.print("=> Chọn chức năng: ");
            
            int chon = -1;
            try{
                 chon = Integer.parseInt(Sc.nextLine());
            }catch(Exception e){
                System.out.println("Lỗi : nhập không đúng");
                continue;
            }           
            if (chon == 0) {
                break;
            }

            switch (chon) {
                case 1:
                    hienThiDanhSachNhaTro();
                    break;
                
                case 2:
                    List<DanhGia> dsDG = DG.xemTatCaDanhGia();
                    if (dsDG == null || dsDG.isEmpty()) {
                        System.out.println("Không có đánh giá nào!");
                    } else {
                        for (DanhGia dg : dsDG) {
                            System.out.println(dg);
                        }
                    }
                    break;
                case 3:
                    vietDanhGia();
                    break;
                case 4:
                    themNguoiDungMoi();
                    break;
                case 5:
                    capNhatDanhGia();
            }
        }
    }

    // --- Hàm Rút Ngắn ---
    private static void hienThiDanhSachNhaTro() {
        List<NhaTro> ds = code.layDanhSachNT();
        if (ds.isEmpty()) {
            System.out.println("Database trống!");
        } else {
            for (NhaTro nt : ds) {
                System.out.println(nt);
            }
        }
    }

    private static void hienThiDanhSachNguoiDung() {
        List<NguoiDung> ds = ND.layDanhSachNguoiDung();
        if (ds.isEmpty()) {
            System.out.println("Chưa có người dùng nào!");
        } else {
            for (NguoiDung nguoi : ds) {
                System.out.println(nguoi);
            }
        }
    }

    private static void themNhaTroMoi() {
        System.out.print("Diện tích: ");
        int dt = Integer.parseInt(Sc.nextLine());
        System.out.print("Giá: ");
        int gia = Integer.parseInt(Sc.nextLine());
        System.out.print("Địa chỉ: ");
        String dc = Sc.nextLine();
        System.out.print("Quận: ");
        String q = Sc.nextLine();
        System.out.print("Mô tả: ");
        String mt = Sc.nextLine();
        System.out.print("Mã loại (1-5): ");
        int ml = Integer.parseInt(Sc.nextLine());
        System.out.print("ID người đăng: ");
        int nd = Integer.parseInt(Sc.nextLine());
        if (code.themNhaTro(new NhaTro(dt, gia, dc, q, mt, ml, nd))) {
            System.out.println("Thêm thành công!");
        } else {
            System.out.println("Thêm thất bại!");
        }
    }

    private static void themNguoiDungMoi() {
        System.out.print("Email: ");
        String e = Sc.nextLine();
        System.out.print("Tên: ");
        String t = Sc.nextLine();
        System.out.print("Giới tính (Nam/Nữ): ");
        String g = Sc.nextLine();
        System.out.print("SĐT: ");
        String s = Sc.nextLine();
        System.out.print("Địa chỉ: ");
        String d = Sc.nextLine();
        System.out.print("Quận: ");
        String q = Sc.nextLine();
        if (ND.themNguoiDung(new NguoiDung(e, t, g, s, d, q))) {
            System.out.println("Đăng ký thành công!");
        } else {
            System.out.println("Thất bại!");
        }
    }

    private static void vietDanhGia() {
        System.out.print("ID Người dùng: ");
        int nd = Integer.parseInt(Sc.nextLine());
        System.out.print("ID Phòng: ");
        int p = Integer.parseInt(Sc.nextLine());
        System.out.print("Sao (1-5): ");
        int s = Integer.parseInt(Sc.nextLine());
        System.out.print("Thái độ (Like/Dislike): ");
        String td = Sc.nextLine();
        System.out.print("Nội dung: ");
        String n = Sc.nextLine();
        if (DG.themDanhGia(nd, p, s, td, n)) {
            System.out.println("Ghi nhận đánh giá!");
        } else {
            System.out.println("Lỗi đánh giá!");
        }
    }
    private static void capNhatDanhGia() {
        System.out.println("\n--- CẬP NHẬT ĐÁNH GIÁ ---");
        System.out.print("Nhập ID của bài đánh giá cần sửa: ");
        int idDG = Integer.parseInt(Sc.nextLine());
        
        System.out.print("Số sao mới (1-5): ");
        int sao = Integer.parseInt(Sc.nextLine());
        System.out.print("Thái độ mới (Like/Dislike): ");
        String thaiDo = Sc.nextLine();
        System.out.print("Nội dung đánh giá mới: ");
        String noiDung = Sc.nextLine();

        if (DG.CapNhatDanhGia(idDG, sao, thaiDo, noiDung)) {
            System.out.println("Đã cập nhật đánh giá thành công!");
        } else {
            System.out.println("Thất bại. Không tìm thấy ID đánh giá này!");
        }
    }
    private static void xoaNguoiDungKhoiHeThong() {
        System.out.print("\nNhập ID người dùng cần xóa: ");
        int idXoa = Integer.parseInt(Sc.nextLine());
        
        System.out.print("Bạn có chắc chắn muốn xóa người dùng này? (Y/N): ");
        String xacNhan = Sc.nextLine();
        
        if (xacNhan.equalsIgnoreCase("Y")) {
            if (ND.xoaNguoiDung(idXoa)) {
                System.out.println("Đã xóa người dùng thành công!");
            } else {
                System.out.println("Xóa thất bại. Kiểm tra lại ID!");
            }
        } else {
            System.out.println("Đã hủy thao tác xóa.");
        }
    }
}
