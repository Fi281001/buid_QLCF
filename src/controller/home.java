package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.cfbean;
import bean.loaibean;
import bo.cfbo;
import bo.loaibo;
import dao.loaidao;

/**
 * Servlet implementation class home
 */
@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		loaibo lbo = new loaibo();
		ArrayList<loaibean> dsloai = lbo.getloai();
		
		request.setAttribute("dsloai", dsloai);
		
		cfbo sbo = new cfbo();
		ArrayList<cfbean> ds = sbo.getsach();
		
		
		 if (request.getParameter("search")!=null){
			 ds = sbo.timKiemTheoTen(ds, request.getParameter("search"));
			
		} 
		 else if(request.getParameter("ml")!=null)
			 
		 { ds = sbo.timKiemTheoLoai(ds,request.getParameter("ml"));
		 
		  }
		 int trang;
			if(request.getParameter("trang") == null) {
				trang = 1;
			}else trang = Integer.parseInt(request.getParameter("trang"));
			
			request.setAttribute("trang", trang);
		 
		request.setAttribute("ds", ds);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
