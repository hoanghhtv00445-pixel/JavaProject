/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author haghe
 */
public class CharacterStream {

    public static void ghiDanhSach(String tenFile, List<String> danhSach) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(tenFile));
            for (String ten : danhSach) {
                writer.write(ten);
                writer.newLine();
            }
            System.out.println("Ghi file thành công: " + tenFile);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Lỗi khi đóng file: " + e.getMessage());
                }
            }
        }
    }

    public static void docDanhSach(String tenFile) {
        System.out.println("\nNội dung file \"" + tenFile + "\":");
        System.out.println("-------------------------------------");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(tenFile));
            String dong;
            int stt = 1;
            while ((dong = reader.readLine()) != null) {
                System.out.println(stt++ + ". " + dong);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close(); 
                } catch (IOException e) {
                    System.out.println("Lỗi khi đóng file: " + e.getMessage());
                }
            }
        }
    }
}