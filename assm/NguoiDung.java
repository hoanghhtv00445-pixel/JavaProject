package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dang
 */
public class NguoiDung {
    private int id;
    private String email;
    private String tenNguoiDung;
    private String gioiTinh;
    private String dienThoai;
    private String diaChi;
    private String quan;

    public NguoiDung(int id, String email, String tenNguoiDung, String gioiTinh, String dienThoai, String diaChi, String quan) {
        this.id = id;
        this.email = email;
        this.tenNguoiDung = tenNguoiDung;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.diaChi = diaChi;
        this.quan = quan;
    }

    public NguoiDung(String email, String tenNguoiDung, String gioiTinh, String dienThoai, String diaChi, String quan) {
        this.email = email;
        this.tenNguoiDung = tenNguoiDung;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.diaChi = diaChi;
        this.quan = quan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }
    @Override
    public String toString() {
        return String.format("ID: %d | Tên: %s | Giới tính: %s | SĐT: %s | Email: %s \nĐịa chỉ: %s, %s", 
                id, tenNguoiDung, gioiTinh, dienThoai, email, diaChi, quan);
    }
}
