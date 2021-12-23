package oop.p2.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import oop.p2.model.CongTy;
import oop.p2.model.GiamDoc;
import oop.p2.model.NhanSu;
import oop.p2.model.NhanVien;
import oop.p2.model.TruongPhong;

public class QuanLyNhanSuController {
	private List danhSachNhanSu;
	private CongTy cTy;
	
	public QuanLyNhanSuController(){
		this.danhSachNhanSu = new ArrayList<>();
		cTy = new CongTy();
	}
	
	/* method*/
	// Nhập thông tin công ty
	public void themInfoCTy(Scanner sc) {
		cTy.themThongTin(sc);
	}
	// Thêm nhân sự
	public boolean them(NhanSu ns) {
		if(danhSachNhanSu.isEmpty()) {
			return danhSachNhanSu.add(ns);
		}
		String maSo = ns.getMaSo();
		for(int i =0; i < danhSachNhanSu.size(); i++) {
			if(((NhanSu) danhSachNhanSu.get(i)).getMaSo().equals(maSo)) {
				System.out.println("Mã số đã tồn tại");
				return false;
			}
		}
		System.out.println("Thêm thành công");
		return danhSachNhanSu.add(ns);
	}
	// Xóa nhân sự	
	public boolean xoa(String maSo) {
		
		for(int i =0; i < danhSachNhanSu.size(); i++) {
			if(((NhanSu) danhSachNhanSu.get(i)).getMaSo().equals(maSo)) {
				System.out.println(new StringBuilder()
										.append("Nhân viên: ")
										.append(((NhanSu) danhSachNhanSu.get(i)).getHoTen())
										.append(" \nMã số: ")
										.append(((NhanSu) danhSachNhanSu.get(i)).getMaSo())
										.append(" \nĐã xóa khỏi dữ liệu thành công")
										.toString()
						);
				if("NV".equals(((NhanSu) danhSachNhanSu.get(i)).getRole())) {
					NhanVien nVTemp = (NhanVien) danhSachNhanSu.get(i);
					if(null != nVTemp.getTruongPhongQuanLy()) {
//						int soNV = nVTemp.getTruongPhongQuanLy().getSoNhanVien();
//						int indxTP = getIndex(nVTemp.getTruongPhongQuanLy().getMaSo());
//						((TruongPhong) danhSachNhanSu.get(indxTP)).setSoNhanVien(soNV - 1);
						int indxTP = getIndex(nVTemp.getTruongPhongQuanLy().getMaSo());
						((TruongPhong) danhSachNhanSu.get(indxTP)).xoaNhanVien(nVTemp.getMaSo());
					}
				}
				else if("TP".equals(((NhanSu) danhSachNhanSu.get(i)).getRole())) {
					for(int j = 0; j < danhSachNhanSu.size(); j++) {
						if("NV".equals(((NhanSu) danhSachNhanSu.get(j)).getRole())) {
							NhanVien nVTemp = (NhanVien) danhSachNhanSu.get(j);
							if(null != nVTemp.getTruongPhongQuanLy()) {
								TruongPhong tP = (TruongPhong) danhSachNhanSu.get(i);
								if(nVTemp.getTruongPhongQuanLy().getMaSo() == tP.getMaSo()) {
									((NhanVien) danhSachNhanSu.get(j)).setTruongPhongQuanLy(null);
								}
							}
						}
					}
				}
				danhSachNhanSu.remove(i);
				return true;
			}
		}
		System.out.println("Không thể tìm thấy nhân viên, xin hãy thử lại");
		return false;
	}
	// Danh Sách nhân viên trong công ty
	public void xuatDanhSach() {
		
		if(danhSachNhanSu.isEmpty()) {
			System.out.println("Danh sách trống");
		}
		else {
			System.out.println("Danh sách nhân viên của công ty");
			System.out.println("-----------------------------");
			for(int i = 0; i < danhSachNhanSu.size(); i ++) {
				((NhanSu) danhSachNhanSu.get(i)).xuatThongTin();
				System.out.println("Lương: " + ((NhanSu) danhSachNhanSu.get(i)).tinhLuong());
				System.out.println("-----------------------------");

			}
		}
		
		
	}
	// Phân bổ nhân viên cho Trưởng Phòng	
	public void themNvToTruongPhong(Scanner sc) {
		if(danhSachNhanSu.isEmpty()) {
			System.out.println("Danh sách trống");
			return;
		}
		System.out.println("Nhập Mã Số Nhân Viên: ");
		String mSNV = sc.nextLine();
		System.out.println("Nhập mã số trưởng phòng");
		String msTP = sc.nextLine();
		int indexNV = getIndex(mSNV);
		int indexTP = getIndex(msTP);
		if(getIndex(mSNV) != -1) {
			System.out.println("Đã tìm thấy Nhân Viên");
			if(indexTP != -1) {
				System.out.println("Đã tìm thấy trưởng phòng");
			}
			else {
				System.out.println("Không tìm thấy trưởng phòng");
				return;
			}
			((NhanVien) danhSachNhanSu.get(indexNV)).setTruongPhongQuanLy((TruongPhong)danhSachNhanSu.get(indexTP));
//			System.out.println("Đã phân bổ nhân viên thành công");
//			int soNVofTP = ((TruongPhong) danhSachNhanSu.get(indexTP)).getSoNhanVien();
//			((TruongPhong) danhSachNhanSu.get(indexTP)).setSoNhanVien(soNVofTP + 1);
			((TruongPhong) danhSachNhanSu.get(indexTP)).addNhanVien((NhanVien) danhSachNhanSu.get(indexNV));
		}
		else {
			System.out.println("Mã số không hợp lệ");
		}
		
	}
	//Xuất tổng lương của công ty
	public float xuatTongLuong() {
		if(danhSachNhanSu.isEmpty()) {
			System.out.println("Danh sách trống");
			return -1;
		}
		float result = 0;
		for(int i = 0; i < danhSachNhanSu.size(); i++) {
			result += ((NhanSu) danhSachNhanSu.get(i)).tinhLuong();
		}
		return result;
	}
	//7. Xuất thông tin nhân viên có lương cao nhất
	public void topLuongNV() {
		if(danhSachNhanSu.isEmpty()) {
			System.out.println("Danh sách trống");
			return;
		}
		float compare = 0;
		int indx = 0;
		for(int i = 0; i < danhSachNhanSu.size(); i++) {
			if(((NhanSu) danhSachNhanSu.get(i)).getRole().equals("NV")) {
				if(compare < ((NhanSu) danhSachNhanSu.get(i)).tinhLuong()) {
					compare = ((NhanSu) danhSachNhanSu.get(i)).tinhLuong();
					indx = i;
				}
			}
		}
		if(compare == 0.0) {
			System.out.println("Danh sách không có nhân viên, hoặc nhân viên chưa làm được ngày nào");
			System.out.println("Xin thử lại sau");
			return;
		}
		System.out.println("--------------------------------");
		System.out.println("Nhân viên có lương cao nhất là: ");
		
		((NhanSu) danhSachNhanSu.get(indx)).xuatThongTin();
		System.out.print(new StringBuilder()
						.append("Với số lương là: ")
						.append(compare)
						.append("\n")
						.toString()
				);
	}
	//8. Xuất thông tin trưởng phòng đang quản lý nhiều nhân viên nhất
	public void topTruongPhong() {
		if(danhSachNhanSu.isEmpty()) {
			System.out.println("Danh sách trống");
			return;
		}
		int compare = 0;
		int indx = 0;
		for(int i = 0; i < danhSachNhanSu.size(); i++) {
			if(((NhanSu) danhSachNhanSu.get(i)).getRole().equals("TP")) {
				if(compare < ((TruongPhong) danhSachNhanSu.get(i)).getSoNhanVien()) {
					compare = ((TruongPhong) danhSachNhanSu.get(i)).getSoNhanVien();
					indx = i;
				}
			}
		}
		
		if(compare == 0.0) {
			System.out.println("Chưa có trưởng phòng nào được phân bổ nhân viên");
			System.out.println("Xin thử lại sau");
			return;
		}
		System.out.println("--------------------------------");
		System.out.println("Trưởng phòng quản lý nhiều nhân viên nhất là: ");
		
		((NhanSu) danhSachNhanSu.get(indx)).xuatThongTin();
		System.out.print(new StringBuilder()
						.append("Với số lượng nhân viên là: ")
						.append(compare)
						.append("\n")
						.toString()
				);
	}
	//9. Sắp xếp nhân viên theo thứ tự abc
	public void sapXepAlpha() {
		if(danhSachNhanSu.isEmpty()) {
			System.out.println("Danh sách trống");
			return;
		}
		danhSachNhanSu.sort(new Comparator<NhanSu>() {
			@Override
			public int compare(NhanSu nv1, NhanSu nv2) {
				return nv1.getHoTen().compareTo(nv2.getHoTen());
			}
		});
		System.out.println("Đã sắp xếp thành công theo thứ tự Alphabet");
	}
	//10. Sắp xếp nhân viên theo thứ tự lương giảm dần
	//10. Sắp xếp nhân viên theo thứ tự lương giảm dần
	public void sapXepTheoLuong() {
		if(danhSachNhanSu.isEmpty()) {
			System.out.println("Danh sách trống");
			return;
		}
		danhSachNhanSu.sort(new Comparator<NhanSu>() {
			@Override
			public int compare(NhanSu nv1, NhanSu nv2) {
				return nv1.tinhLuong() > nv2.tinhLuong() ? -1 : 1;
			}
		});
		System.out.println("Đã sắp xếp thành công theo thứ tự lương giảm dần");
	}
	//11. Xuất ra giám đốc có lương cao nhất
	//
	public void topGD() {
		if(danhSachNhanSu.isEmpty()) {
			System.out.println("Danh sách trống");
			return;
		}
		float compare = 0;
		int indx = 0;
		for(int i = 0; i < danhSachNhanSu.size(); i++) {
			if(((NhanSu) danhSachNhanSu.get(i)).getRole().equals("GD")) {
				if(compare < ((GiamDoc) danhSachNhanSu.get(i)).getSoCoPhan()) {
					compare = ((GiamDoc) danhSachNhanSu.get(i)).getSoCoPhan();
					indx = i;
				}
			}
		}
		
		if(compare == 0.0) {
			System.out.println("Danh sách chưa có Giám Đốc nào");
			System.out.println("Xin thử lại sau");
			return;
		}
		
		System.out.println("Giám đốc có nhiều số cổ phần nhất là: ");
		System.out.println("--------------------------------");
		((NhanSu) danhSachNhanSu.get(indx)).xuatThongTin();
		System.out.print(new StringBuilder()
						.append("Với số cổ phần là: ")
						.append(compare)
						.toString()
				);
		
	}
	//12. Xuất ra tổng thu nhập của từng giám đốc
	public void tongThuNhapGD() {
		if(danhSachNhanSu.isEmpty()) {
			System.out.println("Danh sách trống");
			return;
		}
		if(this.cTy.getTen() == null) {
			System.out.println("Hãy nhập thông tin cho công ty trước");
			return;
		}
		float loiNhuanCTy = (float) (cTy.getDoanhThuThang() - xuatTongLuong());
		for(int i = 0; i < danhSachNhanSu.size(); i++) {
			if("GD".equals(((NhanSu) danhSachNhanSu.get(i)).getRole())) {
				System.out.println("--------------------");
				((GiamDoc) danhSachNhanSu.get(i)).xuatThongTin();
				float luongThang = ((GiamDoc) danhSachNhanSu.get(i)).tinhLuong();
				float soCP = ((GiamDoc) danhSachNhanSu.get(i)).getSoCoPhan() / 100;
				float thuNhap = luongThang + loiNhuanCTy*soCP;
				System.out.print("Tổng thu nhập: ");
				System.out.println(thuNhap);
			}
		}
	}
	private int getIndex(String mSNV) {
		for(int i = 0; i < danhSachNhanSu.size(); i++) {
			String msNVTemp = ((NhanSu) danhSachNhanSu.get(i)).getMaSo();
			if(msNVTemp.equals(mSNV)) {
				return i;
			}
		}
		return -1;
	}
}
