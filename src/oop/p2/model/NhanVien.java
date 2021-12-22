package oop.p2.model;

public class NhanVien extends NhanSu{
	TruongPhong truongPhongQuanLy;
	
	public NhanVien() {
		this.setRole("NV");
		this.setLuongMotNgay(100);
		
	}

	public TruongPhong getTruongPhongQuanLy() {
		return truongPhongQuanLy;
	}

	public void setTruongPhongQuanLy(TruongPhong truongPhongQuanLy) {
		this.truongPhongQuanLy = truongPhongQuanLy;
	}
	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		if(null != this.truongPhongQuanLy)
		System.out.println("Trưởng phòng quản lý nhân viên này là: " + this.truongPhongQuanLy.getMaSo());
	}
	
	@Override
	public float tinhLuong() {
		float result = getLuongMotNgay() * getSoNgayLam();
		return result;
	}
	
}
