package oop.p2.model;

import java.util.Scanner;

public class CongTy {
	private String ten;
	private String maSoThue;
	private float doanhThuThang;
	
	public CongTy() {
		
	}
	/* constructor */
	
	/*methods*/
	
	public void themThongTin(Scanner sc) {
		System.out.print("Hay nhap ten Cong Ty: ");
		setTen(sc.nextLine());
		System.out.print("\nMã số thuế: ");
		setMaSoThue(sc.nextLine());
		System.out.print("\nDoanh thu tháng: ");
		setDoanhThuThang(Float.parseFloat(sc.nextLine()));
		System.out.println("\nBổ sung thông tin thành công");
	}
	
	/* getters and setters*/
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public double getDoanhThuThang() {
		return doanhThuThang;
	}

	public void setDoanhThuThang(float doanhThuThang) {
		this.doanhThuThang = doanhThuThang;
	}
	
}
