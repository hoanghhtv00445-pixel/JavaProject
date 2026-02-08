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
public class SanPhamTieuDung extends SanPham {

    private double giamGia; // 0.1 = 10%
    private String hanSuDung;

    public SanPhamTieuDung() {
        super();
    }

    public SanPhamTieuDung(String maSP, String tenSP, double donGia, int soLuong,
            double giamGia, String hanSuDung) {
        super(maSP, tenSP, donGia, soLuong);
        this.giamGia = giamGia;
        this.hanSuDung = hanSuDung;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public String getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(String hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    @Override
    public void Nhap(Scanner sc) {
        System.out.print("Nhập tên sản phẩm: ");
        this.tenSP = sc.nextLine().trim();
        System.out.print("Nhập đơn giá: ");
        this.donGia = readDouble(sc);
        System.out.print("Nhập số lượng: ");
        this.soLuong = readInt(sc);
        System.out.print("Nhập tỉ lệ giảm giá (0.1 cho 10%): ");
        this.giamGia = readDouble(sc);
        System.out.print("Nhập hạn sử dụng (ví dụ 2024-12-31): ");
        this.hanSuDung = sc.nextLine().trim();
    }

    @Override
    public double getUnitPrice() {
        return donGia * (1.0 - giamGia);
    }

    @Override
    public double thanhTien() {
        return getUnitPrice() * soLuong;
    }

    @Override
    public void Xuat() {
        System.out.printf("TieuDung | Ma:%s | Ten:%s | DonGia:%.2f | SL:%d | Giam:%.2f | HSD:%s%n",
                maSP, tenSP, donGia, soLuong, giamGia, hanSuDung);
    }

    @Override
    public String toString() {
        return String.format("TieuDung[ma=%s, ten=%s, donGia=%.2f, sl=%d, giam=%.2f, hsd=%s]",
                maSP, tenSP, donGia, soLuong, giamGia, hanSuDung);
    }
}


