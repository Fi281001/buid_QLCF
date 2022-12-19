<%@page import="bo.giohangbo"%>
<%@page import="bean.khachhangbean"%>
<%@page import="bean.cfbean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<%@page import="bo.loaibo"%>
<%@page import="bo.cfbo"%>

<%@page import="java.util.ArrayList"%>

<%@page import="bean.loaibean"%>
<%@page import="dao.loaidao"%>
<%@page import="bean.cfbean"%>
<%@page import="dao.cfdao"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <!-- basic -->
         <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>Grand Coffee</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- bootstrap css -->
      <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
      <!-- owl stylesheets --> 
      <link rel="stylesheet" href="css/owl.carousel.min.css">
      <link rel="stylesheet" href="css/owl.theme.default.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
     	<style>
     	
  		.search2	 {
  			    margin: 5px;
  		}
  		.but {
		  	padding-top: 3px;
		    padding-bottom: 3px;
		
		    
		    padding-left: 18px;
		    padding-right: 18px;
		    color: gray;
		    background: #f76d37;
  		}
  	
  		
  		.img {
  		    width: 227px;
   			height: 178px;
  		}
  		.anhbuy{
  		width: 100px;
    	height: 50ppx;
  		}
  		.li{
  			width: 200px;
  		}
  		.ul{
  		width: 200px;
  		}
  		.ht{
  			display: flex;
  			margin: 40px;
    		justify-content: space-evenly;
  		}
  		.page-active .page-link 	 {
  			background: #f76d37;
  			color: #252525;
  			    margin-bottom: 50px;
  		}
  		.pagination{
  			justify-content: center;
  			
  		}
  		.w{
  			height: 100;
  		}
  	</style>
   </head>
   <body>
  <% giohangbo gh = (giohangbo) session.getAttribute("gio"); 	
  ArrayList<cfbean> ds = (ArrayList<cfbean>)request.getAttribute("ds");
	int st = (ds.size()/10 == 0) ? 1 : ds.size()/10;
	
	if(ds.size()/10 != 0) st++;
  khachhangbean kh = (khachhangbean) session.getAttribute("kh"); %>
      <!--header section start -->
      <div class="header_section">
         <div class="container-fluid">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
               <div class="logo"><a href="home"><img src="images/logo.png"></a></div>
               <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav"aria-expanded="false" aria-label="Toggle navigation">
               <span class="navbar-toggler-icon"></span>
               </button>
               <div class="collapse navbar-collapse" id="navbarNav">
                  <ul class="navbar-nav ml-auto">
                     <li class="nav-item">
                        <a class="nav-link" href="home">Home</a>
                     </li>
                     <li class="nav-item">
                     
                        <a class="nav-link" href="giohang">Cart
                         <% if (gh != null){
			    	  if (gh.count() == 0)
				    		out.print("");
				    	else{
				    		out.print("(" + gh.count() + ")");
				    	} 
			      }
			      else{
			    	  out.print("");
			      }
			      
			      %>
                        </a>
                        
			      	
                     </li>
                    
                     <li class="nav-item">
                        <a class="nav-link" href="lichsu">History</a>
                     </li>
                     <li>
                       <form class="search2" action="home">
					      <input type="text" placeholder="Search." name="search" value="<%=request.getParameter("search") == null ? " " : request.getParameter("search")%>">
					      <button class="but" type="submit"><i class="fa fa-search"></i></button>
					    </form>
					 </li>
					<li>
					
			      <% if (session.getAttribute("kh") == null){ %>
			    	 <a  class="nav-link" href="ktdn"></span>Log In</a>
			      <%}else{ %>
			    	 <a  a class="nav-link" href="#"><span class="glyphicon glyphicon-user">
			    	 	<%=kh.getHoten() %>
			    	 </a>
			      <%} %>
			      
			      </a></li>
			        <li><a class="nav-link" href="remove.jsp"><i class="fa fa-sign-out" style="font-size:24px"></i></a></li>
                  </ul>
                  
					  
                    
               </div>
            </nav>
         </div>
      </div>
      <!--header section end -->
     <!--  banner section start -->
      <div class="banner_section layout_padding">
         <div class="container">
            <div id="main_slider" class="carousel slide" data-ride="carousel">
               <div class="carousel-inner">
                  <div class="carousel-item active">
                     <div class="row">
                        <div class="col-sm-12">
                           <div class="banner_taital">
                              <h1 class="outstanding_text">Outstanding</h1>
                              <h1 class="coffee_text">Coffee Shop</h1>
                              <p class="there_text">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, </p>
                              
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="carousel-item">
                     <div class="row">
                        <div class="col-sm-12">
                           <div class="banner_taital">
                              <h1 class="outstanding_text">Outstanding </h1>
                              <h1 class="coffee_text">Coffee Shop</h1>
                              <p class="there_text">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, </p>
                              
                           </div>
                        </div>
                     </div>
                  </div>
                
               </div>
               
            </div>
         </div>
      </div>
      <!-- banner section end -->
     	 <!--hiển thị-->	
       <div class="w">     
      <div class="about_section layout_padding">
         <div class="container">
            	<div>
		<h1 style="text-align: center; font-size: 57px;; color: #f76d37">Products</h1>
			<div class="ht">
			<div>
		    <ul class="ul" >
		    
				<%
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("uft-8");
				//loaibo loai = new loaibo();
				ArrayList<loaibean> loai = (ArrayList<loaibean>)request.getAttribute("dsloai");
					for(loaibean l: loai/*loai.getloai()*/){%>
						<li class="li" ><a class="list-group-item" href="home?ml=<%=l.getMaLoai()%>">
						<%=l.getTenLoai()%></a></li>
					<%
					}
				%>
		    </ul>
		    </div>
		    <div style="text-align:  center">
		    <table width="1000px" style="padding: 0 25px">
		    		
		    		
		   		    <% 
		   		    
		   		 	int trang = (int)request.getAttribute("trang");
		   		    int start = (trang-1)*10;
		   		    int end = (trang)*10;
		   		 	if(trang  == ds.size()/10 +1){
	   					if(ds.size()%10 != 0)end = (trang -1)*10 + ds.size()%10;
	   				} 
		   		 	if(ds.isEmpty()){%>
		   		 		<h3 style="font-size: 28px; text-align: center;">Không có sản phẩm cần tìm</h3>
		   		 		<br>
		   		 		<a  class="btn-action-1" href="home">Quay lại trang chủ</a>
		   		 	<%}
		   		 	else
			   		    for(int i=start; i < end;i++){
			   		    	cfbean s = ds.get(i);
			   		%> 
			   		     <tr>
				   		      <td  style="text-align: center;">
					   		  	 <img class="img" style="border-radius: 6px" src="<%=s.getAnh() %>"> <br>
					   		     <%=s.getTencafe() %> <br>
					   		     <%=s.getGia() %>Đ<br>
					   		     
					   		     <a href="giohang?add=true&mcf=<%=s.getMacafe()%>&ten=<%=s.getTencafe()%>&gia=<%=s.getGia()%>&anh=<%=s.getAnh()%>">
					   		     	<img class="anhbuy" src="anhbuy.png"/>
					   		     </a>
					   		  </td>
				   		   	
				   		   	  <% i++; 
				   		   	  if(i<	ds.size()){
				   		      		s = ds.get(i);%>
				   		     		<td style="text-align: center;">
							   		    <img class="img" style="border-radius: 6px" src="<%=s.getAnh() %>"> <br>
							   		    <%=s.getTencafe()%> <br>
							   	     	
							   		    <%=s.getGia() %>Đ<br>
							   		    <a href="giohang?add=true&mcf=<%=s.getMacafe()%>&ten=<%=s.getTencafe()%>&gia=<%=s.getGia()%>&anh=<%=s.getAnh()%>">
					   		     	<img class="anhbuy" src="anhbuy.png"/>
					   		     </a>
						   		     </td>
					   		
				   		     <%} %>
				   		      <% i++; 
				   		   	  if(i<	ds.size()){
				   		      		s = ds.get(i);%>
				   		     		<td style="text-align: center;">
							   		    <img class="img" style="border-radius: 6px" src="<%=s.getAnh() %>"> <br>
							   		    <%=s.getTencafe()%> <br>
							   	     	
							   		    <%=s.getGia() %>Đ<br>
							   		    <a href="giohang?add=true&mcf=<%=s.getMacafe()%>&ten=<%=s.getTencafe()%>&gia=<%=s.getGia()%>&anh=<%=s.getAnh()%>">
					   		     	<img class="anhbuy" src="anhbuy.png"/>
					   		     </a>
						   		     </td>
					   		
				   		     <%} %>
				   		  </tr>
				   	<%} 
				   	%>
	   		 </table>
	   		 </div>
	   		 </div>
			  <nav aria-label="Page navigation example">
				  <ul class="pagination">
						<%                //Button Previous
					        int back = 0;
					        if (trang == 0 || trang == 1) {
					            back = 1;//Luon la page 1
					        } else {
					            back = trang - 1;//Neu pages tu 2 tro len thi back tru 1
					        }
					    %>
				<li class="page-item"><a class="page-link" href="home?trang=<%=back%>">Previous</a></li>
				    	<%for(int i = 1; i< st; i++){%>
				 		<li class="page-item <%=(trang ==i ) ? "page-active":""%>"><a class="page-link" href="home?trang=<%=i %>"><%=i %></a></li>
				    <%} %>
				    
							     <%                //Button Previous
						        int next = 0;
						        if(trang == st){
						        	next= st;
						        }else{
						        	next = trang + 1;
						        }
						   
						    %>
				    <li class="page-item"><a class="page-link" href="home?trang=<%=next%>">Next</a></li>
				    
				  </ul>
				</nav> 
	</div>
         </div>
      </div>
       </div><!-- end hiển thị -->
      <!-- gallery section end -->
      
   <!--    <!-- footer section start -->
      <div class="footer_section layout_padding">
         <div class="container">
            <div class="row">
               <div class="col-lg-3 col-sm-6">
                  <h3 class="useful_text">About</h3>
                  <p class="footer_text">consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation u</p>
               </div>
               <div class="col-lg-3 col-sm-6">
                  <h3 class="useful_text">Menu</h3>
                  <div class="footer_menu">
                     <ul>
                        <li><a >Home</a></li>
                        <li><a >Giỏ hàng</a></li>
                        <li><a ></a></li>
                        <li><a >Services</a></li>
                        <li><a >Contact Us</a></li>
                     </ul>
                  </div>
               </div>
               <div class="col-lg-3 col-sm-6">
                  <h1 class="useful_text">Useful Link</h1>
                  <p class="dummy_text">Adipiscing Elit, sed do Eiusmod Tempor incididunt </p>
               </div>
               <div class="col-lg-3 col-sm-6">
                  <h1 class="useful_text">Contact Us</h1>
                  <div class="location_text">
                     <ul>
                        <li>
                           <a href="#">
                           <i class="fa fa-map-marker" aria-hidden="true"></i><span class="padding_left_10">Address : Huế</span>
                           </a>
                        </li>
                        <li>
                           <a href="#">
                           <i class="fa fa-phone" aria-hidden="true"></i><span class="padding_left_10">Call : +8476312***</span>
                           </a>
                        </li>
                        <li>
                           <a href="#">
                           <i class="fa fa-envelope" aria-hidden="true"></i><span class="padding_left_10">Email pctrungmagic@gmail.com</span>
                           </a>
                        </li>
                     </ul>
                  </div>
               </div>
            </div>
         </div>
      </div> 
      <!-- footer section end -->
      <!-- copyright section start -->
     
      <!-- copyright section end -->
      <!-- Javascript files-->
      <script src="js/jquery.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.bundle.min.js"></script>
      <script src="js/jquery-3.0.0.min.js"></script>
      <script src="js/plugin.js"></script>
      <!-- sidebar -->
      <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
      <script src="js/custom.js"></script>     
   </body>
</html>