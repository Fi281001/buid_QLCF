package bo;

import java.util.ArrayList;

import bean.khachhangbean;
import dao.khachhang;

public class khachhangbo {
	khachhang khgdao = new khachhang();
	ArrayList<khachhangbean> dskhg;
	public ArrayList<khachhangbean> getdskhachhang(){
		dskhg = khgdao.getdskhachhang();
		return dskhg;
	}
	
	public khachhangbean kiemtradangnhap(String un, String pass) {
		dskhg = khgdao.getdskhachhang();
		for(khachhangbean kh:dskhg) {
			if (un.equals(kh.getTendangnhap()) && pass.equals(kh.getMatkhau()))
				return kh;
		}
		return null;
	}
	
	public boolean themkhachhang(String hoten, String diachi,String email, String tendangnhap, String matkhau) {
		try {
			dskhg = khgdao.getdskhachhang();
			for(khachhangbean kh:dskhg) {
				if(email.equals(kh.getEmail()) || tendangnhap.equals(kh.getTendangnhap())) {
					return false;
				}
			}
			
			int kt =khgdao.ThemKhachHang(hoten, diachi, email, tendangnhap, matkhau);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
	
	
	}
}
