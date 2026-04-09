package service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import dbconnection.ConnectSQL;
import model.NhaTro;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dang
 */
public class Caulenh_QuanLyNhaTro {
//hiện danh sách(tất cả)

    public List<NhaTro> layDanhSachNT() {
        List<NhaTro> list = new ArrayList<>();
        String sql = "SELECT * FROM NhaTro";
        try (Connection Con = ConnectSQL.getConnection(); PreparedStatement Ps = Con.prepareStatement(sql); ResultSet Rs = Ps.executeQuery()) {
            while (Rs.next()) {
                NhaTro NT = new NhaTro(
                        Rs.getInt("ID"),
                        Rs.getInt("DienTich"),
                        Rs.getInt("GiaPhong"),
                        Rs.getString("DiaChi"),
                        Rs.getString("Quan"),
                        Rs.getString("MoTaPhongTro"),
                        Rs.getDate("NgayDangTin"),
                        Rs.getInt("MaLoaiNha"),
                        Rs.getInt("MaNguoiDang")
                );
                list.add(NT);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
//thêm một nhà trọ mới

    public boolean themNhaTro(NhaTro nt) {
        String sql = "{call SP_ThemNhaTro(?,?,?,?,?,NULL,?,?)}";
        try (Connection con = ConnectSQL.getConnection(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, nt.getDienTich());
            cs.setInt(2, nt.getGiaPhong());
            cs.setString(3, nt.getDiaChi());
            cs.setString(4, nt.getQuan());
            cs.setString(5, nt.getMoTaPhongTro());
            cs.setInt(6, nt.getMaLoaiNha());
            cs.setInt(7, nt.getMaNguoiDang());
            int result = cs.executeUpdate();
            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
//xóa nhà trọ theo id

    public boolean xoaNhaTro(int id) {
        String sql = "DELETE FROM NhaTro WHERE ID = ?";
        try (Connection con = ConnectSQL.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            System.out.println("Lỗi: không thể xóa");
        }
        return false;
    }
//xoa nhà trọ có dislike vược ngưỡng

    public void xoaNhaTroToxic(int stopDislike) {
        String sql = "{call sp_XoaNhaTroTheoDislike(?)}";
        try (Connection con = ConnectSQL.getConnection(); CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, stopDislike);
            cs.execute();
            System.out.println("Hệ thống đã tự động dọn dẹp các phòng trọ bị Dislike > " + stopDislike);

        } catch (Exception e) {
            System.out.println("Lỗi khi thực hiện dọn dẹp hệ thống!");
        }
    }
//cập nhật giá phòng theo ID

    public boolean updategiaphong(int id, int giamoi) {
        String sql = "update NhaTro set GiaPhong = ? where id = ?";
        try (Connection con = ConnectSQL.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setInt((1), giamoi);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
