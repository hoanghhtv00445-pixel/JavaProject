/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author haghe
 */
public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Vui lòng nhập điểm:");

        for (int i = 0; i < 5; i++) {
            System.out.print("điểm " + (i + 1) + ": ");
            String input = sc.nextLine();

            if (input.isEmpty()) {
                list.add(null);
            } else {
                list.add(Integer.valueOf(input)); 
            }
        }

        System.out.println("Danh sách điểm: " + list);

        double sum = 0;
        int count = 0;

        for (Integer d : list) {
            if (d != null) { 
                sum += d; 
                count++;
            }
        }

        double avg = (count == 0) ? 0 : sum/count;
        System.out.println("Điểm TB: " + avg);

        if (avg >= 8) System.out.println("Giỏi");
        else if (avg >= 6.5) System.out.println("Khá");
        else System.out.println("Trung bình");
    }
}
