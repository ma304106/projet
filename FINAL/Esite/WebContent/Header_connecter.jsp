<%@ page language="java" contentType="text/html; charset= UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%@page import="main.Connexion"%>
	<%
  String nb= Connexion.nbArticle((String)request.getSession().getAttribute("id"));
  String sum=Connexion.sommePanier((String)request.getSession().getAttribute("id"));
%>

	<div class="header">
		<div class="container">
			<div class="header-top">
				<div class="logo">
					<a href="index.jsp"><img src="images/logo.png" alt="" /></a>
				</div>
				<div class="header_right">
					<ul class="social">
						<li><a href=""> <i class="fb"> </i>
						</a></li>
						<li><a href=""><i class="tw"> </i> </a></li>
						<li><a href=""><i class="utube"> </i> </a></li>
						<li><a href=""><i class="pin"> </i> </a></li>
						<li><a href=""><i class="instagram"> </i> </a></li>
					</ul>
					<div class="lang_list">
						<select tabindex="4" class="dropdown">
							<option value="" class="label" value="">En</option>
							<option value="1">English</option>
							<option value="2">French</option>
							<option value="3">German</option>
						</select>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="index-banner">
				<div class="wmuSlider example1">
					<div class="wmuSliderWrapper">
						<article style="position: relative; width: 100%; opacity: 1;">
						<div class="banner-wrap">
							<div class="bannertop_box">
								<ul class="login">
									<li class="login_text"><a href="index.jsp"><%=session.getAttribute("id")%></a></li>
									<li class="wish"><a href="Deconnection.jsp">Log out</a></li>
									<div class='clearfix'></div>
								</ul>
								<div class="cart_bg">
									<ul class="cart">
										<i class="cart_icon"></i>
										<p class="cart_desc">
											$<%=sum%><br>
											<span class="yellow"><%=nb%> items</span>
										</p>
										<div class='clearfix'></div>
									</ul>
									<ul class="product_control_buttons">
										<li><a href="#"><img src="images/close.png" alt="" /></a></li>
										<li><a href="#">Edit</a></li>
									</ul>
									<div class='clearfix'></div>
								</div>
								<ul class="quick_access">
									<li class="view_cart"><a href="checkout.jsp">View Cart</a></li>
									<li class="check"><a href="paiement.jsp">Checkout</a></li>
									<div class='clearfix'></div>
								</ul>
								<form action="recherche" method="post">
									<div class="search">
										<input type="text" value="Search" onfocus="this.value = '';"
											onblur="if (this.value == '') {this.value = 'Search';}"
											name="search"> <input type="submit" value="">
									</div>
								</form>
								<div class="welcome_box">
									<h2>Welcome to Surfhouse</h2>
									<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
										elit, sed diam nonummy nibh euism</p>
								</div>
							</div>
							<div class="banner_right">
								<h1>
									Mutation<br> 2014
								</h1>
								<p>Ut wisi enim ad minim veniam, quis nostrud exerci tation
									ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo.</p>
								<a href="#" class="banner_btn">Buy Now</a>
							</div>
							<div class='clearfix'></div>
						</div>
						</article>
					</div>
				</div>
				<script src="js/jquery.wmuSlider.js"></script>
			</div>
		</div>
	</div>
</body>
</html>