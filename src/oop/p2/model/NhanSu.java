package oop.p2.model;

import java.util.Scanner;

public class NhanSu {
	private String maSo;
	private String hoTen;
	private String soDienThoai;
	private float soNgayLam;
	private float luongMotNgay;
	private String Role;
	
	public NhanSu() {
		
	}
	
	/* constructor */
	
	/*getters and setters*/
	
	
	
	public float tinhluong() {
		return -1;
	}
	
	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public float getSoNgayLam() {
		return soNgayLam;
	}

	public void setSoNgayLam(float soNgayLam) {
		this.soNgayLam = soNgayLam;
	}

	public float getLuongMotNgay() {
		return luongMotNgay;
	}

	public void setLuongMotNgay(float luongMotNgay) {
		this.luongMotNgay = luongMotNgay;
	}

	/*methods*/
	
	public void xuatThongTin() {
		String thongTin = new StringBuilder()
								.append("Mã số: ").append(this.maSo)
								.append("\nHọ tên: ").append(this.hoTen)
								.append("\nSố điện thoại: ").append(this.soDienThoai)
								.append("\nSố ngày làm: ").append(this.soNgayLam)
								.append("\nLương một ngày: ").append(this.luongMotNgay)
								.toString();
		System.out.println(thongTin);
	}
	
	public void nhapThongTin(Scanner sc) {
		System.out.println("Nhap Ma So: ");
		this.maSo = sc.nextLine();
		System.out.println("Nhap Họ Tên: ");
		this.hoTen = sc.nextLine();
		System.out.println("Nhập sdt: ");
		this.soDienThoai = sc.nextLine();
		System.out.println("Nhập số ngày làm: ");
		this.soNgayLam = Float.parseFloat(sc.nextLine());
	}
	
	public float tinhLuong() {
		return -1;
	}
}
