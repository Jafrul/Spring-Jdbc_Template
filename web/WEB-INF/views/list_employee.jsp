 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Address</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
       

   <td>${emp.employeeId}</td>  
   <td>${emp.name}</td>  
   <td>${emp.salary}</td>  
   <td>${emp.address}</td>  
     
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="add_employee_form">Add New Employee</a>  