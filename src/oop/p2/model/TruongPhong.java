package oop.p2.model;

public class TruongPhong extends NhanSu {
	private int soNhanVien;
	
	public TruongPhong() {
		soNhanVien = 0;
		setRole("TP");
		this.setLuongMotNgay(200);
	}

	public int getSoNhanVien() {
		return soNhanVien;
	}

	public void setSoNhanVien(int soNhanVien) {
		this.soNhanVien = soNhanVien;
	}
	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.println("Số nhân viên dưới trướng: " + this.soNhanVien);
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
