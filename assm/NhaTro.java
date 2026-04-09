package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Date;

/**
 *
 * @author dang
 */
public class NhaTro {
    private int id; 
    private int dienTich;
    private int giaPhong;
    private String diaChi;
    private String quan;
    private String moTaPhongTro;
    private Date ngayDangTin;
    private int maLoaiNha; 
    private int maNguoiDang;

    public NhaTro(int id, int dienTich, int giaPhong, String diaChi, String quan, String moTaPhongTro, Date ngayDangTin, int maLoaiNha, int maNguoiDang) {
        this.id = id;
        this.dienTich = dienTich;
        this.giaPhong = giaPhong;
        this.diaChi = diaChi;
        this.quan = quan;
        this.moTaPhongTro = moTaPhongTro;
        this.ngayDangTin = ngayDangTin;
        this.maLoaiNha = maLoaiNha;
        this.maNguoiDang = maNguoiDang;
    }

    public NhaTro(int dienTich, int giaPhong, String diaChi, String quan, String moTaPhongTro, int maLoaiNha, int maNguoiDang) {
        this.dienTich = dienTich;
        this.giaPhong = giaPhong;
        this.diaChi = diaChi;
        this.quan = quan;
        this.moTaPhongTro = moTaPhongTro;
        this.maLoaiNha = maLoaiNha;
        this.maNguoiDang = maNguoiDang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public int getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(int giaPhong) {
        this.giaPhong = giaPhong;
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

    public String getMoTaPhongTro() {
        return moTaPhongTro;
    }

    public void setMoTaPhongTro(String moTaPhongTro) {
        this.moTaPhongTro = moTaPhongTro;
    }

    public Date getNgayDangTin() {
        return ngayDangTin;
    }

    public void setNgayDangTin(Date ngayDangTin) {
        this.ngayDangTin = ngayDangTin;
    }

    public int getMaLoaiNha() {
        return maLoaiNha;
    }

    public void setMaLoaiNha(int maLoaiNha) {
        this.maLoaiNha = maLoaiNha;
    }

    public int getMaNguoiDang() {
        return maNguoiDang;
    }

    public void setMaNguoiDang(int maNguoiDang) {
        this.maNguoiDang = maNguoiDang;
    }
    @Override
    public String toString() {
        return String.format("ID: %d | Diện tích: %dm2 | Giá: %d VND | Địa chỉ: %s, %s | Loại nhà: %d", 
                id, dienTich, giaPhong, diaChi, quan, maLoaiNha);
    }
}
