/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab7;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author haghe
 */
public class Main {
    public static void main(String[] args){
        EmployeeRepository er = new EmployeeRepository();
        Scanner sc = new Scanner(System.in);
        int chon;
        
        while(true){
            System.out.println("\n---------Quản lý nhân viên---------");
            System.out.println("1.Hiển thị danh sách nhân viên ");
            System.out.println("2.Thêm nhân viên mới");
            System.out.println("3.Tìm kiếm theo mã nhân viên");
            System.out.println("0.Thoát");
            System.out.println("Mời bạn chọn chức năng: ");
            chon = sc.nextInt();

        try{
            switch(chon){
                case 1:
                    System.out.println("\n---Danh sách nhân viên---");
                    List<Employee> list = er.getAll();
                    if(list.isEmpty()){
                        System.out.println("Danh sách trống!");
                    }else{
                        list.forEach(System.out::println);
                    }
                    break;
                case 2:
                    System.out.println("\n---Thêm nhân viên mới---");
                    System.out.println("Nhập ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập tên:");
                    String name = sc.nextLine();
                    System.out.println("Nhập lương:");
                    double salary = sc.nextDouble();
                    
                    Employee emp = new Employee(id,name,salary);
                    if(er.add(emp)){
                        System.out.println("Thêm thành công");
                    }else{
                        System.out.println("Thêm thất bại!");
                    }
                    break;
                case 3:
                    System.out.println("\n Nhập ID cần tìm:");
                    int idSearch = sc.nextInt();
                    Employee e = er.findById(idSearch);
                    if (e != null){
                        System.out.println("Tìm kiếm thành công:" + e);
                    }else{
                        System.out.println("Tìm kiếm thất bại! Không tìm thấy ID:" + idSearch);
                    }
                    break;
                case 0:
                    System.out.println("Thoát.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chọn không đúng! Vui lòng chọn lại.");
            }
        }
        catch(Exception e){
            System.out.println("Đã xảy ra lỗi:" + e.getMessage());
        }
    } 
}
}