/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentgd2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Service {
     private ArrayList<SanPham> ds;
    private static final String MA_PATTERN = "^SP\\d{3}$";

    public Service() {
        ds = new ArrayList<>();
    }

    public ArrayList<SanPham> getAll() {
        return ds;
    }

    public boolean existsMa(String ma) {
        if (ma == null) {
            return false;
        }
        String k = ma.trim();
        for (SanPham s : ds) {
            if (s.getMaSP().equalsIgnoreCase(k)) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(SanPham sp) {
        if (sp == null || sp.getMaSP() == null) {
            return false;
        }
        if (existsMa(sp.getMaSP())) {
            return false;
        }
        ds.add(sp);
        return true;
    }

    public boolean addProductInteractive(Scanner sc) {
        String ma;
        while (true) {
            System.out.print("Nhập mã SP (SPxxx): ");
            ma = sc.nextLine().trim().toUpperCase();
            if (!ma.matches(MA_PATTERN)) {
                System.out.println("Mã không hợp lệ. Phải theo SP + 3 chữ số.");
                continue;
            }
            if (existsMa(ma)) {
                System.out.println("Mã đã tồn tại. Nhập mã khác.");
                continue;
            }
            break;
        }

        System.out.print("Loại (1=DienTu, 2=TieuDung): ");
        String type = sc.nextLine().trim();
        if ("1".equals(type)) {
            SanPhamDienTu dt = new SanPhamDienTu();
            dt.setMaSP(ma);
            dt.Nhap(sc);
            ds.add(dt);
            return true;
        } else {
            SanPhamTieuDung td = new SanPhamTieuDung();
            td.setMaSP(ma);
            td.Nhap(sc);
            ds.add(td);
            return true;
        }
    }

    public void printAll() {
        if (ds.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        for (SanPham s : ds) {
            s.Xuat();
        }
    }

    public ArrayList<SanPhamDienTu> getDienTu() {
        ArrayList<SanPhamDienTu> out = new ArrayList<>();
        for (SanPham s : ds) {
            if (s instanceof SanPhamDienTu) {
                out.add((SanPhamDienTu) s);
            }
        }
        return out;
    }

    public ArrayList<SanPhamTieuDung> getTieuDung() {
        ArrayList<SanPhamTieuDung> out = new ArrayList<>();
        for (SanPham s : ds) {
            if (s instanceof SanPhamTieuDung) {
                out.add((SanPhamTieuDung) s);
            }
        }
        return out;
    }

    public SanPham findByMa(String ma) {
        if (ma == null) {
            return null;
        }
        String k = ma.trim();
        for (SanPham s : ds) {
            if (s.getMaSP().equalsIgnoreCase(k)) {
                return s;
            }
        }
        return null;
    }

    public Double computeTotalByMaAndQty(String ma, int qty) {
        SanPham s = findByMa(ma);
        if (s == null) {
            return null;
        }
        return s.getUnitPrice() * qty;
    }

    public boolean updateByMaInteractive(String ma, Scanner sc) {
        SanPham s = findByMa(ma);
        if (s == null) {
            return false;
        }
        s.capNhat(sc);
        return true;
    }

    public boolean removeByMa(String ma) {
        SanPham s = findByMa(ma);
        if (s == null) {
            return false;
        }
        ds.remove(s);
        return true;
    }

    public void sortByName() {
        Collections.sort(ds, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham a, SanPham b) {
                if (a.getTenSP() == null) {
                    return -1;
                }
                if (b.getTenSP() == null) {
                    return 1;
                }
                return a.getTenSP().compareToIgnoreCase(b.getTenSP());
            }
        });
    }

    public void loadSample() {
        ds.add(new SanPhamDienTu("SP000", "Iphone20", 5000, 10, "12 tháng"));
    }
} 



