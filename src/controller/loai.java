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

import bean.loaibean;
import bo.loaibo;

/**
 * Servlet implementation class loai
 */
@WebServlet("/loai")
public class loai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loai() {
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
		HttpSession session = request.getSession();
		loaibo lbo = new loaibo();
		
		String ma=request.getParameter("txtma");
		String tl=request.getParameter("txtten");
		if(request.getParameter("add")!=null) {
			lbo.Themloai(ma, tl);
			
		}
		else if(request.getParameter("xoa")!=null) {
			String xoa=request.getParameter("xoa");
			lbo.Xoa(xoa);
			
		}
		else if (request.getParameter("update")!=null) {
			String ten2=request.getParameter("ten2");
			lbo.Update(ten2, request.getParameter("ml"));
			System.out.println("ten ne: "+ten2);
			System.out.println("up ne: "+request.getParameter("update"));
		}
		ArrayList<loaibean> dsloai = lbo.getloai();
		request.setAttribute("dsloai", dsloai);
		RequestDispatcher rd =request.getRequestDispatcher("addloai.jsp");
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