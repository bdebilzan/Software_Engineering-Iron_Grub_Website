<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${currentFood}</title>
</head>
<body>
    
    Your Previous order (${orderedEmail})): <br>
    <c:forEach items="${listFood}" var="food" varStatus="rowStatus">
        <c:forEach items="${listBFood}" var="foodId" varStatus="rowCount">
           <c:if test = "${food.id == foodId.id}">
           
           ${food.name} Amount:  ${foodId.amountBought}<br>
           
           </c:if>
        </c:forEach>
    </c:forEach>
    
</body>
</html>