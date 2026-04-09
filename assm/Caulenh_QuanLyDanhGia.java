/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dbconnection.ConnectSQL;
import model.DanhGia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dang
 */
public class Caulenh_QuanLyDanhGia {
    // xem tất cả đánh giá 

    public List<DanhGia> xemDDTheoPhong(int idPhong) {
        List<DanhGia> list = new ArrayList<>();
        String sql = "SELECT dg.MaNhaTro, nd.TenNguoiDung, dg.ChatLuong, dg.LikeDislike, dg.NoiDungDanhGia, dg.NgayDanhGia "
                + "FROM DanhGia dg "
                + "JOIN NguoiDung nd ON dg.MaNguoiDanhGia = nd.ID "
                + "WHERE dg.MaNhaTro = ? "
                + "ORDER BY dg.NgayDanhGia DESC";
        try (Connection Con = ConnectSQL.getConnection(); PreparedStatement Ps = Con.prepareStatement(sql)) {
            Ps.setInt(1, idPhong);
            try (ResultSet Rs = Ps.executeQuery()) {
                while (Rs.next()) {
                    DanhGia dg = new DanhGia(
                            Rs.getInt("MaNhaTro"),
                            Rs.getString("TenNguoiDung"),
                            Rs.getInt("ChatLuong"),
                            Rs.getString("LikeDislike"),
                            Rs.getString("NoiDungDanhGia"),
                            Rs.getDate("NgayDanhGia")
                    );
                    list.add(dg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
// tìm đánh giá mới nhất

    public DanhGia timDDMoiNhat() {
        String sql = "SELECT TOP 1 dg.MaNhaTro, nd.TenNguoiDung, dg.ChatLuong, dg.LikeDislike, dg.NoiDungDanhGia, dg.NgayDanhGia "
                + "FROM DanhGia dg "
                + "JOIN NguoiDung nd ON dg.MaNguoiDanhGia = nd.ID "
                + "ORDER BY dg.NgayDanhGia DESC, dg.ID DESC";
        try (Connection Con = ConnectSQL.getConnection(); PreparedStatement Ps = Con.prepareStatement(sql); ResultSet Rs = Ps.executeQuery()) {
            if (Rs.next()) {
                return new DanhGia(
                        Rs.getInt("MaNhaTro"),
                        Rs.getString("TenNguoiDung"),
                        Rs.getInt("ChatLuong"),
                        Rs.getString("LikeDislike"),
                        Rs.getString("NoiDungDanhGia"),
                        Rs.getDate("NgayDanhGia")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
// xem tất cả các đánh giá có trên hệ thống

    public List<DanhGia> xemTatCaDanhGia() {
        List<DanhGia> list = new ArrayList<>();
        String sql = "SELECT dg.MaNhaTro, nd.TenNguoiDung, dg.ChatLuong, dg.LikeDislike, dg.NoiDungDanhGia, dg.NgayDanhGia "
                + "FROM DanhGia dg "
                + "JOIN NguoiDung nd ON dg.MaNguoiDanhGia = nd.ID "
                + "ORDER BY dg.NgayDanhGia DESC";

        try (Connection Con = ConnectSQL.getConnection(); PreparedStatement Ps = Con.prepareStatement(sql); ResultSet Rs = Ps.executeQuery()) {
            while (Rs.next()) {
                DanhGia dg = new DanhGia(
                        Rs.getInt("MaNhaTro"),
                        Rs.getString("TenNguoiDung"),
                        Rs.getInt("ChatLuong"),
                        Rs.getString("LikeDislike"),
                        Rs.getString("NoiDungDanhGia"),
                        Rs.getDate("NgayDanhGia")
                );
                list.add(dg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean themDanhGia(int maNguoiDG, int maPhong, int chatLuong, String likeDislike, String noiDung) {
        String sql = "{call SP_ThemDanhGia(?, ?, ?, ?, ?, NULL)}";
        try (Connection con = ConnectSQL.getConnection(); CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, maNguoiDG);
            cs.setInt(2, maPhong);
            cs.setInt(3, chatLuong);
            cs.setString(4, likeDislike);
            cs.setString(5, noiDung);

            int result = cs.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            System.out.println("Lỗi: Không thể thêm đánh giá. Vui lòng kiểm tra lại ID Người dùng hoặc ID Phòng!");
        }
        return false;
    }

    public boolean CapNhatDanhGia(int idDG, int SoMoi, String ThaiDoMoi, String NoiDungMoi) {
        String sql = "UPDATE DanhGia SET ChatLuong = ?, LikeDislike = ?, NoiDungDanhGia = ?, NgayDanhGia = GETDATE() WHERE ID = ?";
        try (Connection con = ConnectSQL.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, SoMoi);

            ps.setString(2, ThaiDoMoi);

            ps.setString(3, NoiDungMoi);

            ps.setInt(4, idDG);

            int resualt = ps.executeUpdate();
            return resualt > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
