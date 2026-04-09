package service;

import dbconnection.ConnectSQL;
import dbconnection.ConnectSQL;
import model.NguoiDung;
import model.NguoiDung;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dang
 */
public class Caulenh_QuanLyNguoiDung {

    // 1. Lấy danh sách toàn bộ người dùng
    public List<NguoiDung> layDanhSachNguoiDung() {
        List<NguoiDung> list = new ArrayList<>();
        String sql = "SELECT * FROM NguoiDung";

        try (Connection Con = ConnectSQL.getConnection(); PreparedStatement Ps = Con.prepareStatement(sql); ResultSet Rs = Ps.executeQuery()) {

            while (Rs.next()) {
                NguoiDung nd = new NguoiDung(
                        Rs.getInt("ID"),
                        Rs.getString("Email"),
                        Rs.getString("TenNguoiDung"),
                        Rs.getString("GioiTinh"),
                        Rs.getString("DienThoai"),
                        Rs.getString("DiaChi"),
                        Rs.getString("Quan")
                );
                list.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. Thêm người dùng mới (Gọi Stored Procedure)
    public boolean themNguoiDung(NguoiDung nd) {
        String sql = "{call SP_ThemNguoiDung(?, ?, ?, ?, ?, ?)}";

        try (Connection con = ConnectSQL.getConnection(); CallableStatement cs = con.prepareCall(sql)) {

            cs.setString(1, nd.getEmail());
            cs.setString(2, nd.getTenNguoiDung());
            cs.setString(3, nd.getGioiTinh());
            cs.setString(4, nd.getDienThoai());
            cs.setString(5, nd.getDiaChi());
            cs.setString(6, nd.getQuan());

            int result = cs.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            System.out.println("Lỗi: Không thể thêm người dùng. Vui lòng kiểm tra định dạng Số điện thoại hoặc Email có bị trùng không!");
        }
        return false;
    }

    public boolean xoaNguoiDung(int id) {
        
        String sql = "delete from NguoiDung where Id = ?";

        try (Connection con = ConnectSQL.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int result = ps.executeUpdate();
            return result > 0; 

        } catch (Exception e) {
            
            System.out.println("Lỗi: Không thể xóa người dùng này vì họ đang đứng tên đăng phòng hoặc có bài đánh giá!");
        }
        return false;
    }
}
