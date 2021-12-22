package oop.p2.model;

import java.util.Scanner;

public class GiamDoc extends NhanSu {
	private float soCoPhan;
	public GiamDoc() {
		setRole("GD");
		this.setLuongMotNgay(300);
	}
	
	/* methods */
	
	@Override
	public void nhapThongTin(Scanner sc) {
		super.nhapThongTin(sc);
		System.out.println("Số cổ phần: ");
		float cP = Float.parseFloat(sc.nextLine());
		if(cP > 100 || cP < 0) {
			System.out.println("Số cổ phần không được vượt quá 100");
			return;
		}
		this.soCoPhan = cP;
	}
	
	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.println("Số cổ phần: " + this.soCoPhan);
	}
	
	@Override
	public float tinhLuong() {
		float result = getLuongMotNgay() * getSoNgayLam();
		return result;
	}
	/*getters and setters*/

	public float getSoCoPhan() {
		return soCoPhan;
	}

	public void setSoCoPhan(float soCoPhan) {
		this.soCoPhan = soCoPhan;
	}
	
}
