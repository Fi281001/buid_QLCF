package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.jdi.connect.spi.Connection;

import bean.loaibean;
import bean.cfbean;
public class cfdao {

	public ArrayList<cfbean> getcf() {

		try {
			ArrayList<cfbean> dscf = new ArrayList<cfbean>();
//			   b1: ket noi vao csdl
			   CoSodao cs = new CoSodao();
			   cs.KetNoi();

			//			   b2: Lay du lieu ve
			   String sql = "select * from cafe";
			   PreparedStatement cmd = cs.cn.prepareStatement(sql);
			   ResultSet rs = cmd.executeQuery();
			   while(rs.next()) {
				   String macafe = rs.getString("macafe");
				   String tencafe = rs.getString("tencafe");
				   long soLuong = rs.getLong("soluong");
				   long gia = rs.getLong("gia");
				   String anh = rs.getString("anh");
				   String maLoai = rs.getString("maloai");
				   dscf.add(new	cfbean(macafe, tencafe, soLuong, gia, anh, maLoai));

			   }

			   rs.close();
			   cs.cn.close();

			   return dscf;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
		
		
	}

}
