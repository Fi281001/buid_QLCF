package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.khachhangbo;

/**
 * Servlet implementation class dangky
 */
@WebServlet("/dangky")
public class dangky extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangky() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hoten = request.getParameter("fullname");
		String diachi = request.getParameter("diachi");
		
		String email = request.getParameter("email");
		String tk = request.getParameter("tk");
		String matkhau = request.getParameter("password");
		String matkhau2 = request.getParameter("password2");
		if (hoten != null && diachi != null && request.getParameter("sodt") != null && email != null && tk != null && matkhau != null && matkhau2 != null ) {
			 khachhangbo kh = new khachhangbo();
			 long sodt = Long.parseLong(request.getParameter("sodt"));
			if(matkhau.equals(matkhau2)) {
				
				if( kh.themkhachhang(hoten, diachi, sodt, email, hoten, matkhau2)== false) {
					RequestDispatcher rd = request.getRequestDispatcher("dangky.jsp");
					rd.forward(request, response);
				}else {
						RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
						rd.forward(request, response);
						}
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("dangky.jsp");
				rd.forward(request, response);
			}
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("dangky.jsp");
			rd.forward(request, response);
		}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
