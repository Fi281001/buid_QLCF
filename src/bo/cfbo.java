package bo;

import java.util.ArrayList;

import bean.cfbean;
import dao.cfdao;

public class cfbo {
	cfdao cfdao = new cfdao();
	ArrayList<cfbean> ds;
	
	public ArrayList<cfbean> getsach(){
		ds = cfdao.getsach();
		
		return ds;
	}
	
	public ArrayList<cfbean> timKiemTheoLoai(ArrayList<cfbean> ds ,String maLoai) {
		ArrayList<cfbean> dsCungMa = new ArrayList<cfbean>();
		for (cfbean item: ds) {
			if (item.getMaLoai().equals(maLoai)) {
				dsCungMa.add(item);
			}
		}
		
		return dsCungMa;
	}
	
	public ArrayList<cfbean> timKiemTheoTen(ArrayList<cfbean> ds ,String tencf) {
		ArrayList<cfbean> dsCungTen = new ArrayList<cfbean>();
		for (cfbean item: ds) {
			if (item.getTencafe().toLowerCase().trim().contains(tencf.toLowerCase().trim())
			 || item.getMaLoai().toLowerCase().trim().contains(tencf.toLowerCase().trim())
			 )	{
				dsCungTen.add(item);
			}
		}
		
		return dsCungTen;
	}
}
