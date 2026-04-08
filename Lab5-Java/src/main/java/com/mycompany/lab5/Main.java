/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5;

import static com.mycompany.lab5.CharacterStream.docDanhSach;
import static com.mycompany.lab5.CharacterStream.ghiDanhSach;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haghe
 */

public class Main {
    public static void main(String[] args) {
        List<String> danhSachSV = new ArrayList<>();
        danhSachSV.add("Nguyen Van An");
        danhSachSV.add("Tran Thi Bich");
        danhSachSV.add("Le Van Cuong");
        danhSachSV.add("Pham Thi Dung");
        danhSachSV.add("Hoang Van Em");
        String tenFile = "danh_sach_sv.txt";
        ghiDanhSach (tenFile, danhSachSV);
        docDanhSach (tenFile);
    }
}
