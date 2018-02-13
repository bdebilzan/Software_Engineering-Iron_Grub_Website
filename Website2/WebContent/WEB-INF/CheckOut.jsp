
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style><%@include file="/WEB-INF/navBar.css"%></style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>CheckOut</title>
</head>
<body>


<div class="topnav">
<a href="Introduction">ABOUT US</a>
  <a href="CheckOrder">MY ORDER</a>
  <a class="active" href="Homepage">SHOP</a>
</div>

	<div class="container">

		<div class=page-header>
			
				<p>
				<span style="text-align: left">
					<img class="logo-img"
						src='https://i.pinimg.com/736x/33/04/e3/3304e35f47f81180e8c8b896b5d57332--knifes-forks.jpg'
						width='80' height='80'>
						 <font color="#FF7D33" size="5">Welcome to Checkout</font>
						 </span>
						 
				<span style="float: right">
				<font color="#FF7D33" size="5">CLEAN, FAST, EASY.</font>
				</span>
						
				</p>
			
		</div>
		
		<div class="row">

				<div class="col-sm-4">
					<div class="img">
						<a href="FoodWeb?id=${pickFood.id}"> 
						<img src="${pickFood.image}" width = "320" height = "320"></a>
					</div>
				</div>
				
				<br>
			
				<div class="col-sm-6">
					<p><font size="6">You Are Ordering:</font><br>
					 <br><font color="#FF7D33" size="6">${pickFood.name}</font></p>
					<p> <font color="#333333" size="4">${pickFood.description}</font></p> <br>
				 	<p><font color="#333333"  size="4"> <c:if test="${FoodSize == 2}"><b>Large Size:</b> $ ${tPrice}</c:if></font></p>
					<p> <font color="#333333"  size="4"><c:if test="${FoodSize == 0}"><b>Regular Size:</b> $ ${tPrice}</c:if></font></p>
				</div>
				
		</div>		 
				


				<form action="CheckOut" method="post">
					
					  	<c:if test = "${isEmptyAlert==false}">
					  	<h5><font color="red">Please fill out all information.</font></h5>
   					    </c:if>
   					    <c:if test = "${isCreditValid==false}">
   					    <h5><font color="red">Invalid Credit Card Information</font></h5>
   					    </c:if>
					    

   					    
   					    <div class="form-group row">
							<br><br><label class="col-sm-1 col-form-label"> <font color="black" size="3" face="Time New Roman"><b>Address:</b></font></label> 
							<div class="col-sm-5">
							<input class="form-control" type="text" name="Address"><br>
							</div>
						
						</div>
						    
						<div class="form-group row">
							<label class="col-sm-1 col-form-label"> <font color="black" size="3" face="Time New Roman"><b>Credit Card Name:</b></font></label>
							<div class="col-sm-5">
							<input class="form-control" type="text" name="PaymentInformation"> <br> 
							</div>
						</div>
				
						<div class="form-group row">
							<label class="col-sm-1 col-form-label"> <font color="black" size="3" face="Time New Roman"><b>Credit Card Number:</b></font></label> 
							<div class="col-sm-5">
							<input class="form-control" type="text" name="CreditCardNumber"><br> 
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-1 col-form-label"> <font color="black" size="3" face="Time New Roman"><b>Security Code:</b></font></label> 
							 <div class="col-sm-5">
							<input class="form-control" type="text" name="CardSecurityCode"><br>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-1 col-form-label"> <font color="black" size="3" face="Time New Roman"><b>Name:</b></font></label> 
							<div class="col-sm-5">
							<input class="form-control" type="text" name="fName"><br> 
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-1 col-form-label"> <font color="black" size="3" face="Time New Roman"><b>Email:</b></font></label> 
							<div class="col-sm-5">
							<input class="form-control" type="text" name="eMail"><br> 
							</div>
						</div>
						
						
					<div class="form-group row ">
					
					<label class="col-sm-1 col-form-label">
					
						<button type="submit" class="btn" value="Confirm Order" style="background-color: #D2691E; color: white">Confirm Order</button>
						
						</label>
					</div>
				</form>
			</div>

</body>

<footer>
<div class="footer">
	<p>
		<span style="float: left;">  &copy; 2017 Iron Grub Inc., All Rights
			Reserved
		</span> <span style="float: right;"><img
			src="https://sassets.evoice.com/evoiceImages/contact_sales.png"
			width='15' height='15' /> &nbsp;323-555-5787 <br> <img
			src='https://n6-img-fp.akamaized.net/free-icon/email-envelope-outline-shape-with-rounded-corners_318-49938.jpg?size=338&ext=jpg'
			width='15' height='15' /> &nbsp;info@irongrub.com <br> <img
			src='https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Building_font_awesome.svg/2000px-Building_font_awesome.svg.png'
			width='15' height='15' /> 5151 State University Dr, <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Los
			Angeles, CA 90032</span>
	</p>
</div>
</footer>
</html>