<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>
<!-- Reference our style sheet -->
<link type="text/css"
      rel = "stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

   <div id="wrapper">
     <div id="header">
     <h2>CRM - Customer RelationShip Manager</h2>
     </div>
</div>
  
 <div id="container">
   <div id="content">
   <!-- Add customer button -->
   <input type="button" value="AddCustomer" 
   onClick= "window.location.href = 'showFormForAdd';return false;" class="add-button"/>
 <!--  add your htm table here -->
      <table>
          <tr>
            <th>First Name</th>
            <th>LastName</th>
            <th>Email</th>
            <th colspan=2>Action</th>
          </tr>
          <!-- loop over  and print out the customers -->
       <c:forEach var="tempCustomer" items="${customers}">
       <!-- construct an update link with sustomer id -->
       <c:url var="updatelink" value="/customer/showFormForUpdate">
            <c:param name = "customerId" value= "${tempCustomer.id}"/>
       </c:url>
       <c:url var="deleteLink" value="/customer/deleteCustomer">
          <c:param name="customerId" value="${tempCustomer.id}"/>
          </c:url>
        <tr>
             <td>${tempCustomer.firstName}</td>
             <td>${tempCustomer.lastName}</td>
             <td>${tempCustomer.email}</td>
             <!-- Display the update link -->
             <td>
             <a href="${updatelink}">Update</a>
             |
             <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this Customer?'))) return false">Delete</a>
             </td>
             
        </tr>
      </c:forEach>
      </table>
   </div>
 </div>

</body>
</html>