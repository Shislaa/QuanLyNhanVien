package oop.p2.model;

import java.util.ArrayList;
import java.util.List;

public class TruongPhong extends NhanSu {
	private int soNhanVien;
	private List quanLyNhanVien;
	
	public TruongPhong() {
		soNhanVien = 0;
		setRole("TP");
		this.setLuongMotNgay(200);
		quanLyNhanVien = new ArrayList<>();
	}

	public int getSoNhanVien() {
		return quanLyNhanVien.size();
	}
//
//	public void setSoNhanVien(int soNhanVien) {
//		this.soNhanVien = soNhanVien;
//	}
	
	public void addNhanVien(NhanVien nv) {
		if(indxNhanVien(nv.getMaSo()) != -1) {
			System.out.println("Nhân Viên đã thuộc quản lý của Trưởng Phòng này rồi");
			return;
		}
		quanLyNhanVien.add(nv);
		System.out.println("Phân bổ nhân viên cho quản lý thành công");
	}
	public void xoaNhanVien(String maso) {
		int indx = indxNhanVien(maso);
		if(indx == -1) {
			System.out.println("Nhân Viên không thuộc quản lý của Trưởng Phòng");
		}
		else {
			quanLyNhanVien.remove(indx);
		}
	}
	private int indxNhanVien(String maso) {
		for(int i = 0; i < quanLyNhanVien.size(); i++) {
			if(((NhanSu) quanLyNhanVien.get(i)).getMaSo().equals(maso)) {
				return i;
			}
		}
		return -1;
	}
	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.println("Số nhân viên dưới trướng: " + quanLyNhanVien.size());
	}
	
	@Override
	public float tinhLuong() {
		float result = (getLuongMotNgay() * getSoNgayLam());
		if(this.soNhanVien != 0) {
			result += (100*this.soNhanVien);
		}
		return result;
	}
	
}
