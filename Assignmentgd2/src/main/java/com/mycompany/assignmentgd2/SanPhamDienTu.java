/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentgd2;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class SanPhamDienTu extends SanPham {

    private String ngayBaoHanh;

    public SanPhamDienTu() {
        super();
    }

    public SanPhamDienTu(String maSP, String tenSP, double donGia, int soLuong, String ngayBaoHanh) {
        super(maSP, tenSP, donGia, soLuong);
        this.ngayBaoHanh = ngayBaoHanh;
    }

    public String getNgayBaoHanh() {
        return ngayBaoHanh;
    }

    public void setNgayBaoHanh(String ngayBaoHanh) {
        this.ngayBaoHanh = ngayBaoHanh;
    }

    @Override
    public void Nhap(Scanner sc) {
        System.out.print("Nhập tên sản phẩm: ");
        this.tenSP = sc.nextLine().trim();
        System.out.print("Nhập đơn giá: ");
        this.donGia = readDouble(sc);
        System.out.print("Nhập số lượng: ");
        this.soLuong = readInt(sc);
        System.out.print("Nhập thời hạn bảo hành (ví dụ '12 tháng'): ");
        this.ngayBaoHanh = sc.nextLine().trim();
    }

    @Override
    public void Xuat() {
        System.out.printf("DienTu | Ma:%s | Ten:%s | DonGia:%.2f | SL:%d | BH:%s%n",
                maSP, tenSP, donGia, soLuong, ngayBaoHanh);
    }

    @Override
    public String toString() {
        return String.format("DienTu[ma=%s, ten=%s, donGia=%.2f, sl=%d, BH=%s]",
                maSP, tenSP, donGia, soLuong, ngayBaoHanh);
    }
}


