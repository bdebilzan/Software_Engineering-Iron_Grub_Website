<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style><%@include file="/WEB-INF/index.css"%></style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="https://i.pinimg.com/736x/33/04/e3/3304e35f47f81180e8c8b896b5d57332--knifes-forks.jpg" type="image/gif" sizes="16x16">
<title>Iron Grub | Clean, Fast, Easy.</title>
</head>
<body>
<div class="topnav">
<a href="Introduction">ABOUT US</a>
  <a href="CheckOrder">MY ORDER</a>
  <a class="active" href="Homepage">SHOP</a>
</div>
<div class = "container2"><img class = "logo-img" src = 'https://i.pinimg.com/736x/33/04/e3/3304e35f47f81180e8c8b896b5d57332--knifes-forks.jpg' width= '130' height='120'></div>
<div class="align-right2"> <br><h3>CLEAN, FAST, EASY.</h3></div>
<h1>SHOP</h1>
<br>
<div class = "container2"><h3>Iron Grub</h3></div>
<div class = "crop"><img src = 'https://mealprepempire.com/wp-content/uploads/2014/07/IMG_0323-1500x542.jpg'></div>
<h4><center>HOW IT WORKS...</center></h4>

<div class = "container3">
  <div class="align-left">
  <img src="https://image.freepik.com/iconos-gratis/monitorear-y-telefono-celular-resume-en-un-circulo_318-57688.jpg" width= '80' height='80' alt="logo1" />
  <h4>YOU CHOOSE</h4>
  </div>
  
  <div class="align-center">
  <img src="https://image.freepik.com/free-icon/logistics-delivery-truck-in-movement_318-61800.jpg" width= '80' height='80' alt="logo2" />
  <h4>WE COOK & DELIVER</h4>
  </div>
  
  <div class="align-right">
  <img src="http://freevector.co/wp-content/uploads/2009/11/55267-cross-of-fork-and-knife-on-a-plate-to-not-eat.png" width= '80' height='80' alt="logo3" />
  <h4>YOU ENJOY</h4>
  </div>
 </div>
 <br>
 <br>
 <br>
<center><h1><font color = "#777">FEATURED MEALS</font></center></h1>


<table border="0">
  <c:forEach items="${listFood}" var="listFood" varStatus="rowCounter">
    <c:if test="${rowCounter.count % 4 == 1}">
      <tr>
    </c:if>
    	<td><center><div class="img"><a href="FoodWeb?id=${listFood.id}"> <img src="${listFood.image}" width = "200" height = "200"></a></div>
			<br><a style= "text-transform: uppercase; font-size: 12px; text-decoration: none; color: #696969"; href="FoodWeb?id=${listFood.id}">${listFood.name}</a>
    			<br><font size: 12px; color="green">$${listFood.price}</font>
    			<br><a href="FoodWeb?id=${listFood.id}"><button class="button" type="button">Buy Now</button></a></center><br>
    	</td>
    <c:if test="${rowCounter.count % 4 == 0}">
      </tr>
    </c:if>
  </c:forEach >
</table>

<footer>
<div class = "footer"><p><span style="float:left;">
<br>
<br>&copy; 2017 Iron Grub Inc., All Rights Reserved</span>

<span style="float:right;"><img src = "https://sassets.evoice.com/evoiceImages/contact_sales.png" width= '15' height='15'/> &nbsp;323-555-5787
<br> <img src = 'https://n6-img-fp.akamaized.net/free-icon/email-envelope-outline-shape-with-rounded-corners_318-49938.jpg?size=338&ext=jpg' width= '15' height='15'/> &nbsp;info@irongrub.com
<br><img src = 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Building_font_awesome.svg/2000px-Building_font_awesome.svg.png' width='15' height = '15'/> 5151 State University Dr, 
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Los Angeles, CA 90032</span></p></div>
</footer>

</body>
</html>