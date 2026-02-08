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
class SanPham {
    protected String maSP;
    protected String tenSP;
    protected double donGia;
    protected int soLuong;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, double donGia, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getUnitPrice() {
        return donGia;
    }

    public double thanhTien() {
        return getUnitPrice() * soLuong;
    }

    public void Nhap(Scanner sc) {
        System.out.print("Nhập tên sản phẩm: ");
        this.tenSP = sc.nextLine().trim();
        System.out.print("Nhập đơn giá: ");
        this.donGia = readDouble(sc);
        System.out.print("Nhập số lượng: ");
        this.soLuong = readInt(sc);
    }

    public void Xuat() {
        System.out.printf("Ma:%s | Ten:%s | DonGia:%.2f | SL:%d%n", maSP, tenSP, donGia, soLuong);
    }

    public void capNhat(Scanner sc) {
        System.out.print("Cập nhật tên (" + tenSP + "): ");
        String s = sc.nextLine().trim();
        if (!s.isEmpty()) {
            tenSP = s;
        }
        System.out.print("Cập nhật đơn giá (" + donGia + "): ");
        s = sc.nextLine().trim();
        if (!s.isEmpty()) {
            donGia = Double.parseDouble(s);
        }
        System.out.print("Cập nhật số lượng (" + soLuong + "): ");
        s = sc.nextLine().trim();
        if (!s.isEmpty()) {
            soLuong = Integer.parseInt(s);
        }
    }

    protected int readInt(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Nhập số nguyên hợp lệ: ");
            }
        }
    }

    protected double readDouble(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.print("Nhập số thực hợp lệ: ");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("SanPham[ma=%s, ten=%s, donGia=%.2f, sl=%d]",
                maSP, tenSP, donGia, soLuong);
    }
}


