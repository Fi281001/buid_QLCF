package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import bo.lichsubo;

public class CoSodao {
	public Connection cn;
	public void KetNoi(){
		try {
			//b1: xac dinh he quan tri csdl
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("xong b1");
			cn=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-FF1278R\\SQLEXPRESS:1433;databaseName=QLCF;user=sa; password=123;");
			System.out.println("Ok b2");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String [] ts) {
		try {
			CoSodao cs = new CoSodao();
			
			cs.KetNoi();
			lichsudao xn = new lichsudao();

			lichsubo lsb= new lichsubo();
			System.out.println(lsb.getList(1));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
