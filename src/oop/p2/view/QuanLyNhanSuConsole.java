package oop.p2.view;

import java.util.Scanner;

import oop.p2.controller.QuanLyNhanSuController;
import oop.p2.model.CongTy;
import oop.p2.model.GiamDoc;
import oop.p2.model.NhanSu;
import oop.p2.model.NhanVien;
import oop.p2.model.TruongPhong;

public class QuanLyNhanSuConsole {
	private QuanLyNhanSuController controller;
	private Scanner sc;
	
	/* Constructor*/
	
	public QuanLyNhanSuConsole() {
		controller = new QuanLyNhanSuController();
		sc = new Scanner(System.in);
	}
	
	public void start() {
		int option;
		do {
			inMenu();
			option = Integer.parseInt(sc.nextLine());
		} while(xuLyMenu(option));
	}
	
	public void inMenu() {
		System.out.println("-- Chương trình quản lý nhân sự --");
		System.out.println("\t1. Nhập thông tin công ty");
		System.out.println("\t2. Thêm nhân sự");
		System.out.println("\t3. Xóa nhân sự");
		System.out.println("\t4. Danh Sách nhân viên trong công ty");
		System.out.println("\t5. Phân bổ nhân viên cho Trưởng Phòng");
		System.out.println("\t6. Xuất tổng lương của công ty");
		System.out.println("\t7. Xuất thông tin nhân viên có lương cao nhất");
		System.out.println("\t8. Xuất thông tin trưởng phòng đang quản lý nhiều nhân viên nhất");
		System.out.println("\t9. Sắp xếp nhân viên theo thứ tự abc");
		System.out.println("\t10. Sắp xếp nhân viên theo thứ tự lương giảm dần");
		System.out.println("\t11. Xuất ra giám đốc có cổ phần cao nhất");
		System.out.println("\t12. Xuất ra tổng thu nhập của từng giám đốc");
		System.out.println("\t0. Thoát");
		System.out.print("Lựa chọn: ");
	}
	
	public boolean xuLyMenu(int option) {
		boolean isContinue = true;
		
		switch (option) {
			// Thoát
			case 0:{
				isContinue = false;
				break;
			}
			// Nhập thông tin công ty
			case 1:{
				controller.themInfoCTy(sc);
				break;
			}
			// Thêm nhân sự
			case 2: {
				themNhanSu();
				break;
			}
			// Xóa nhân sự
			case 3: {
				System.out.println("Hãy nhập mã số Nhân Viên cần xóa");
				String ms = sc.nextLine();
				controller.xoa(ms);
				break;
			}
			// Danh Sách nhân viên trong công ty
			case 4: {
				controller.xuatDanhSach();
				break;
			}
			// Phân bổ nhân viên cho Trưởng Phòng
			case 5: {
				controller.themNvToTruongPhong(sc);
				break;
			}
			//6. Xuất tổng lương của công ty
			case 6: {
				System.out.println(new StringBuilder().
				           append("Tổng lương của công ty là: ")
				           .append(controller.xuatTongLuong())
				           .toString()         
				);
				break;
			}
			//7. Xuất thông tin nhân viên có lương cao nhất
			case 7: {
				controller.topLuongNV();
				break;
			}
			//8. Xuất thông tin trưởng phòng đang quản lý nhiều nhân viên nhất
			case 8: {
				controller.topTruongPhong();
				break;
			}
			//9. Sắp xếp nhân viên theo thứ tự abc
			case 9:{
				controller.sapXepAlpha();
				controller.xuatDanhSach();
				break;
			}
			//10. Sắp xếp nhân viên theo thứ tự lương giảm dần
			case 10: {
				controller.sapXepTheoLuong();
				controller.xuatDanhSach();
				break;
			}
			//11. Xuất ra giám đốc có cổ phần cao nhất
			case 11: {
				controller.topGD();
				break;
			}
			//12. Xuất ra tổng thu nhập của từng giám đốc
			case 12: {
				controller.tongThuNhapGD();
				break;
			}
			default: {
				System.out.println("Cú pháp không hợp lệ, xin hãy thử lại");
			}
		}
		
		return isContinue;
	}
	
	private void themNhanSu() {
		NhanSu ns;
		System.out.println("-- Thêm nhân sự --");
		System.out.println("\t1. Thêm Nhân viên");
		System.out.println("\t2. Thêm Trưởng Phòng");
		System.out.println("\t3. Thêm Giám Đốc");
		System.out.print("Lựa chọn: ");
		int option = Integer.parseInt(sc.nextLine());
		
		switch (option) {
			// Thêm Nhân viên
			case 1: {
				ns = new NhanVien();
				ns.nhapThongTin(sc);
				controller.them(ns);
				break;
			}
			//Thêm Trưởng Phòng
			case 2: {
				ns = new TruongPhong();
				ns.nhapThongTin(sc);
				controller.them(ns);
				break;
			}
			// Thêm Giám Đốc
			case 3: {
				ns = new GiamDoc();
				ns.nhapThongTin(sc);
				controller.them(ns);
				break;
			}
			default:{
				System.out.println("Hãy chọn lại chức năng");
				
			}
			
			
		}
	}
	
}
