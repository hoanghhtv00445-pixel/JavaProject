/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author dang
 */
public class DanhGia {
    private int maNhaTro;
    private String tenNguoiDanhGia;
    private int chatLuong;
    private String likeDislike;
    private String noiDungDanhGia;
    private Date ngayDanhGia;

    public DanhGia(int maNhaTro, String tenNguoiDanhGia, int chatLuong, String likeDislike, String noiDungDanhGia, Date ngayDanhGia) {
        this.maNhaTro = maNhaTro;
        this.tenNguoiDanhGia = tenNguoiDanhGia;
        this.chatLuong = chatLuong;
        this.likeDislike = likeDislike;
        this.noiDungDanhGia = noiDungDanhGia;
        this.ngayDanhGia = ngayDanhGia;
    }

    public int getMaNhaTro() {
        return maNhaTro;
    }

    public void setMaNhaTro(int maNhaTro) {
        this.maNhaTro = maNhaTro;
    }

    public String getTenNguoiDanhGia() {
        return tenNguoiDanhGia;
    }

    public void setTenNguoiDanhGia(String tenNguoiDanhGia) {
        this.tenNguoiDanhGia = tenNguoiDanhGia;
    }

    public int getChatLuong() {
        return chatLuong;
    }

    public void setChatLuong(int chatLuong) {
        this.chatLuong = chatLuong;
    }

    public String getLikeDislike() {
        return likeDislike;
    }

    public void setLikeDislike(String likeDislike) {
        this.likeDislike = likeDislike;
    }

    public String getNoiDungDanhGia() {
        return noiDungDanhGia;
    }

    public void setNoiDungDanhGia(String noiDungDanhGia) {
        this.noiDungDanhGia = noiDungDanhGia;
    }

    public Date getNgayDanhGia() {
        return ngayDanhGia;
    }

    public void setNgayDanhGia(Date ngayDanhGia) {
        this.ngayDanhGia = ngayDanhGia;
    }
    @Override
    public String toString() {
        return String.format("Phòng ID: %d | Người đánh giá: %s | %d Sao (%s) | Ngày: %s\nNội dung: %s", 
                maNhaTro, tenNguoiDanhGia, chatLuong, likeDislike, ngayDanhGia.toString(), noiDungDanhGia);
    }
    
}
