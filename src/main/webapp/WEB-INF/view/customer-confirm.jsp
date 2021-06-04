<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4 color=red>Customer ${customer.firstName} is add Successfully</h4>
<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
</body>
</html>