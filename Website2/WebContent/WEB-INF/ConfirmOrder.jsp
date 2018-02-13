<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style><%@include file="/WEB-INF/navBar.css"%></style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Confirm Order</title>
</head>
<body> 
    <div class="topnav">
<a href="Introduction">ABOUT US</a>
  <a href="CheckOrder">MY ORDER</a>
  <a class="active" href="Homepage">SHOP</a>
</div>
<div class="container">
        <div class="row">
        
        <div class=page-header>
            
                <p>
                <span style="text-align: left">
                    <img class="logo-img"
                        src='https://i.pinimg.com/736x/33/04/e3/3304e35f47f81180e8c8b896b5d57332--knifes-forks.jpg'
                        width='80' height='80'>
                         <font color="#FF7D33" size="5">Confirm Order</font>
                         </span>
                         
                <span style="float: right">
                <font color="#FF7D33" size="5">CLEAN, FAST, EASY.</font>
                </span>
                        
                </p>
            
        </div>
        <div class="col-sm-4">
                <div class="img">
                    <a href="FoodWeb?id=${pickFood.id}"> <img src=${pickFood.image} width= '320' height='320'> <br>
</a>
                </div>
            </div>
            <div class="col-sm-6">
                <br> <br>
                 <p><font  size="6">You have Ordered:<br> ${pickFood.name}</font></p>
                <font  size="4">${pickFood.description}</font> <br>
                
            </div>
            </div>
  <br>
  <br> 
  
  <div class="form-group row">
                            <label class="col-form-label"> <font color="black" size="3" face="Time New Roman"><b> Address : ${address}<br></b></font></label>
                            
                            </div>
<div class="form-group row">
<label class="col-form-label"> <font color="black" size="3" face="Time New Roman"><b>  Your name : ${personName}<br></b></font></label>
</div>
<div class="form-group row">
<label class="col-form-label"> <font color="black" size="3" face="Time New Roman"><b>   Ordered Date : ${orderedDate} <br></b></font></label>
</div>
<div class="form-group row">
<label class="col-form-label"> <font color="black" size="3" face="Time New Roman"><b>    Credit Card Num : ${confirmCardNum}<br></b></font></label>
</div>
<div class="form-group row">
<label class="col-form-label"> <font color="black" size="3" face="Time New Roman"><b>     Credit Card Type : ${cCardType}<br></b></font></label>
</div>
<div class="form-group row">
<label class="col-form-label"> <font color="black" size="3" face="Time New Roman"><b>      Your Food will be arriving at your door in 2 days, 12pm - 5 pm <br></b></font></label>
</div>
 <br>
 
 <a href = "Homepage">Back to Home</a>
 
 </div>
 
</body>
<footer>
<div class = "footer"><p><span style="float:left;">
<br>
&copy; 2017 Iron Grub Inc., All Rights Reserved</span>
<span style="float:right;"><img src = "https://sassets.evoice.com/evoiceImages/contact_sales.png" width= '15' height='15'/> &nbsp;323-555-5787
<br> <img src = 'https://n6-img-fp.akamaized.net/free-icon/email-envelope-outline-shape-with-rounded-corners_318-49938.jpg?size=338&ext=jpg' width= '15' height='15'/> &nbsp;info@irongrub.com
<br><img src = 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Building_font_awesome.svg/2000px-Building_font_awesome.svg.png' width='15' height = '15'/> 5151 State University Dr, 
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Los Angeles, CA 90032</span></p></div>
</footer>
</html>