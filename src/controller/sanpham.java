package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.cfbean;
import bean.loaibean;
import bo.cfbo;
import bo.loaibo;

/**
 * Servlet implementation class sanpham
 */
@WebServlet("/sanpham")
public class sanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sanpham() {
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
		cfbo spb = new cfbo();
	
		HttpSession ss= request.getSession();

		

		if(request.getParameter("update2")!=null){
			String ten = request.getParameter("ten");
			String maloai = request.getParameter("ml");
			long soluong = Long.parseLong(request.getParameter("sl"));
			long gia = Long.parseLong(request.getParameter("gia"));
			spb.sua(ten, maloai, soluong, gia,request.getParameter("update2"));
		}
		 if(request.getParameter("xoa2") != null) {
			spb.xoa(request.getParameter("xoa2"));
			
		}
		
		
			ss.setAttribute("dssanpham", spb.getcf());
		
		RequestDispatcher rd = request.getRequestDispatcher("addcafe.jsp");
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
