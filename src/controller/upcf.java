package controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.cfbean;
import bo.cfbo;

/**
 * Servlet implementation class upcf
 */
@WebServlet("/upcf")
public class upcf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upcf() {
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

		
		
		
		if(request.getContentLength()<=0){
			RequestDispatcher rd = request.getRequestDispatcher("addcafe.jsp");
			rd.forward(request, response);
		}else {
			String ma="";
			String ten="";
			String maloai="";
			long soluong = 0;
			long gia = 0;
			String anh = "./anh/";
			DiskFileItemFactory factory = new DiskFileItemFactory();
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "anh";
			//response.getWriter().println("Vao Roi");
			//response.getWriter().println(dirUrl1);
			try {
				List<FileItem> fileItems = upload.parseRequest(request);//L???y v??? c??c ?????i t?????ng g???i l??n
				//duy???t qua c??c ?????i t?????ng g???i l??n t??? client g???m file v?? c??c control
				for (FileItem fileItem : fileItems) {
					if (!fileItem.isFormField()) {//N???u ko ph???i c??c control=>upfile l??n
					// x??? l?? file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
				        //L???y ???????ng d???n hi???n t???i, ch??? ?? x??? l?? tr??n dirUrl ????? c?? ???????ng d???n ????ng
						String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "anh";
						File dir = new File(dirUrl);
						if (!dir.exists()) {//n???u ko c?? th?? m???c th?? t???o ra
							dir.mkdir();
						}
					    String fileImg = dirUrl + File.separator + nameimg;
					    File file = new File(fileImg);//t???o file
					    try {
					    	fileItem.write(file);//l??u file
					    	 anh += nameimg;
					    	 response.getWriter().println(anh);
					    	} 
					    catch (Exception e) {
					    	e.printStackTrace();
					    	}
						}
					}
					else//Neu la control
					{
						String tentk=fileItem.getFieldName();
						if(tentk.equals("txtmsp")) {
							//response.getWriter().println(fileItem.getString());
							ma = fileItem.getString();
						}
						if(tentk.equals("txttensp")) {
							//response.getWriter().println(fileItem.getString());
							ten = fileItem.getString();
						}
							
							
						if(tentk.equals("txtmh")) {
							//response.getWriter().println(fileItem.getString());
							maloai = fileItem.getString();
						}
							
						if(tentk.equals("txtsl")) {
							//response.getWriter().println(fileItem.getString());
							soluong = Long.parseLong(fileItem.getString());
						}
							
						if(tentk.equals("txtgia")) {
							//response.getWriter().println(fileItem.getString());
							gia = Long.parseLong(fileItem.getString());
						}
							
						
				    	
					}
				}
				spb.them_sp(new cfbean(ma, ten, soluong, gia, anh, maloai));
			} 
			catch (FileUploadException e) {
				e.printStackTrace();
			}
			
		
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
