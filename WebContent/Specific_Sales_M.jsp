<%@ page import="inventory_services.*" %>
<%@ page import="inventory_connection.*" %>
<%@ page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html lang="zxx">
<head>
<title>Specific Manager View</title>
<!-- custom-theme -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Esteem Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //custom-theme -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="css/table-style.css" />
<link rel="stylesheet" type="text/css" href="css/basictable.css" />
<link href="css/component.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style_grid.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome-icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome-icons -->
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
</head>
<body>
<!-- banner -->
<div class="wthree_agile_admin_info">
		  <!-- /w3_agileits_top_nav-->
		  <!-- /nav-->
		  
		 <div class="wthree_agile_admin_info">
		  <!-- /w3_agileits_top_nav-->
		  <!-- /nav-->
		
		  	  <div class="w3_agileits_top_nav">
		  	  <form action="Specific_Sales_M.jsp" method="post"> 
			<ul id="gn-menu" class="gn-menu-main">
			  		 <!-- /nav_agile_w3l -->
				<li class="gn-trigger">
					<a class="gn-icon gn-icon-menu"><i class="fa fa-bars" aria-hidden="true"></i><span>Menu</span></a>
					<nav class="gn-menu-wrapper">
						<div class="gn-scroller scrollbar1">
							<ul class="gn-menu agile_menu_drop">
								<li><a href="main_Page.html"> <i class="fa fa-tachometer"></i> Dashboard</a></li>
								<li>
									<a href="raw_Material.html"><i class="fa fa-cogs" aria-hidden="true"></i>Raw Material<i class="fa fa-angle-down" aria-hidden="true"></i></a> 
								</li>
								<li>
									<a href="stock.html"> <i class="fa fa-bitbucket" aria-hidden="true"></i>Stock <i class="fa fa-angle-down" aria-hidden="true"></i></a> 
								
								</li>
								
									<li>
									<a href="issued_raw.html"> <i class="fa fa-circle-o-notch" aria-hidden="true"></i>Issued Raw Material<i class="fa fa-angle-down" aria-hidden="true"></i></a> 
								
								</li>
								<li>
									<a href="issued_stock.html"> <i class="fa fa-circle-o-notch" aria-hidden="true"></i>Issued Stock Material<i class="fa fa-angle-down" aria-hidden="true"></i></a> 
								
								</li>
								
									<li>
									<a href="invoice.html"> <i class="fa fa-file-text-o" aria-hidden="true"></i>Invoice <i class="fa fa-angle-down" aria-hidden="true"></i></a> 
								
								</li>
								
									<li>
									<a href="customer.html"> <i class="fa fa-usres" aria-hidden="true"></i>Customer Records <i class="fa fa-angle-down" aria-hidden="true"></i></a> 
								
								</li>
								
									<li>
									<a href="sales.html"> <i class="fa fa-shopping-cart" aria-hidden="true"></i>Sales Manager<i class="fa fa-angle-down" aria-hidden="true"></i></a> 
								
								</li>
								<li>
									<a href="index.html"> <i class="fa fa-logout" aria-hidden="true"></i>logout<i class="fa fa-angle-down" aria-hidden="true"></i></a> 
								
								</li>
					
							</ul>
						</div><!-- /gn-scroller -->
					</nav>
				</li>
				<!-- //nav_agile_w3l -->
				<li class="second logo"><h1><a href="main_Page.html"><i class="fa fa-graduation-cap" aria-hidden="true"></i>TFI admin </a></h1></li>
					<li class="second admin-pic">
				       <ul class="top_dp_agile">
									<li class="dropdown profile_details_drop">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
											
										</a>
										<ul class="dropdown-menu drp-mnu">
											<li> <a href="setting.html"><i class="fa fa-cog"></i> Settings</a> </li> 
											<li> <a href="about.html"><i class="fa fa-user"></i> Profile</a> </li> 
											<li> <a href="index.html"><i class="fa fa-sign-out"></i> Logout</a> </li>
										</ul>
									</li>
									
						</ul>
				</li>
				<li class="second top_bell_nav">
				   <ul class="top_dp_agile ">
									<li class="dropdown head-dpdn">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-plus" aria-hidden="true"></i> </a>
										<ul class="dropdown-menu">
											<li>
												<div class="notification_header">
													<h3>add Sales Manager </h3>
												</div>
											</li>
								
											 <li>
												<div class="notification_bottom">
													<a href="sales.html">Add Sales Manager</a>
												</div> 
											</li>
										</ul>
									</li>
									
						</ul>
				</li>
				<li class="second top_bell_nav">
				   <ul class="top_dp_agile ">
									<li class="dropdown head-dpdn">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-eye" aria-hidden="true"></i></a>
										<ul class="dropdown-menu">
											<li>
												<div class="notification_header">
													<h3>View all IManager</h3>
												</div>
											</li>
											 <li>
												<div class="notification_bottom">
													<a href="View_Sales_M.jsp">View Sales Manager</a>
												</div> 
											</li>
										</ul>
									</li>
									
						</ul>
				</li>
				<li class="second top_bell_nav">
				   <ul class="top_dp_agile ">
				       <li class="dropdown head-dpdn">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-search"></i>></a>
										<ul class="dropdown-menu">
											<li>
												<div class="notification_header">
													<h3>Remove sales manager</h3>
												</div>
											</li>
											<li>
												<div class="notification_bottom">
													<a href="remove_Sales_M.html">Remove</a>
												</div> 
											</li>
										</ul>
									</li>	
								</ul>
				</li>

				<li class="second w3l_search">
					
				</li>
				<li class="second full-screen">
					<section class="full-top">
						<button id="toggle"><i class="fa fa-arrows-alt" aria-hidden="true"></i></button>	
					</section>
				</li>

			</ul>
			<!-- //nav -->
			
		</div>
	</div>
		<div class="clearfix"></div>
		<!-- //w3_agileits_top_nav-->
		
		<!-- /inner_content-->
				<div class="inner_content">
				    <!-- /inner_content_w3_agile_info-->

					<!-- breadcrumbs -->
						<div class="w3l_agileits_breadcrumbs">
							<div class="w3l_agileits_breadcrumbs_inner">
								<ul>
									<li><a href="main_Page.html">Home</a><span>«</span></li>
									
								
								</ul>
							</div>
						</div>
					<!-- //breadcrumbs -->

					<div class="inner_content_w3_agile_info two_in">
					  <h2 class="w3_inner_tittle">Search By GSTIN</h2>
									
										<div class="signin-form profile admin">
													<h2>Specific Sales Manager </h2>
													<div class="login-form">
														<form action="Specific_Sales_M.jsp" method="post">
															
															<input type="text" name="s_email" placeholder="Email_ID" required="">
															<input type="password" name="s_pass" placeholder="Password" required="">
															
															<div class="tp">
																<input type="submit" value="Submit">
															</div>
															
															
													
													</div>
									
													 <h6><a href="main_Page.html">Back To Main Page</a><h6>
 
												</div>
												   
    <%
    	String s_email=request.getParameter("s_email");
   		String s_pass=request.getParameter("s_pass");
    		if(s_email!=null && s_pass!=null)
    		{
    %>
    	
											<table id="table">
											<thead>
											  <tr>
												<th>ID</th>
												<th>ManagerName</th>
												<th>City</th>
												<th>Contact Number</th>
												<th>Password</th>
												<th>Joining date</th>
											
											  </tr>
											</thead>
											
												  
		   	<%
			   	
				try
				{
					Connection con=ConnectDB.connect();
					PreparedStatement ps1=con.prepareStatement("select * from sales_tbl where s_email=? and s_pass=?");
					ps1.setString(1, s_email);
					ps1.setString(1, s_pass);
					ResultSet rs1=ps1.executeQuery();
					while(rs1.next())
					{
		   	%>
		    	    	  <tr>
		    	    	    <td><%= rs1.getInt("s_id")%></td>
		    	    	    <td><%= rs1.getString("s_name")%></td>
		    	    	     <td><%= rs1.getString("s_city")%></td>
		    	    	      <td><%= rs1.getString("s_email")%></td>
		    	    	    <td><%= rs1.getString("s_contact")%></td>
		    	    	    <td><%= rs1.getString("s_pass")%></td>
		    	    	    <td><%= rs1.getInt("s_date")%></td>
		    	    	 
		    	    	  </tr>
		    	    	  
		    <% 
		    		}
			   	}
	    	
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
    	}
		    %>   	  
				</tbody>
		  </table>
		    <br>   <br>   <br>
		  	<a href="sales.html"> Back </a> 
					
								</div>
								        </form>
						</div>
							<!-- //tables -->
					
							<!-- /social_media-->
					
						<!-- //social_media-->
				    </div>
					<!-- //inner_content_w3_agile_info-->
				 </div>
		<!-- //inner_content-->
<!--copy rights start here-->
<div class="copyrights">
	 <p>© 2023 TFI. All Rights Reserved | </p>
</div>	
<!--copy rights end here-->
<!-- js -->

          <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
		  <script src="js/modernizr.custom.js"></script>
		
		   <script src="js/classie.js"></script>
		  <script src="js/gnmenu.js"></script>
		  <script>
			new gnMenu( document.getElementById( 'gn-menu' ) );
		 </script>
<!-- tables -->

<script type="text/javascript" src="js/jquery.basictable.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
      $('#table').basictable();

      $('#table-breakpoint').basictable({
        breakpoint: 768
      });

      $('#table-swap-axis').basictable({
        swapAxis: true
      });

      $('#table-force-off').basictable({
        forceResponsive: false
      });

      $('#table-no-resize').basictable({
        noResize: true
      });

      $('#table-two-axis').basictable();

      $('#table-max-height').basictable({
        tableWrapper: true
      });
    });
</script>
<!-- //js -->
<script src="js/screenfull.js"></script>
		<script>
		$(function () {
			$('#supported').text('Supported/allowed: ' + !!screenfull.enabled);

			if (!screenfull.enabled) {
				return false;
			}

			

			$('#toggle').click(function () {
				screenfull.toggle($('#container')[0]);
			});	
		});
		</script>
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>

<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>


</body>
</html>