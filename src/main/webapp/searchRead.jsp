<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page
	import="model.Students,java.util.ArrayList,java.text.SimpleDateFormat;"%>
<html>
<jsp:include page="header.jsp" />
<p>
	<br />
</p>
<p></p>



<div class="row">
	<div class="col">
		<h3>Student List</h3>
	</div>
	<div class="col-md-5">
		<form name="searchForm" action="search" method="GET">
			<input type="text" class="form-control" name="searchVal"
				placeholder="Search (Fullname, Student Id, Firstname or Lastname)"
				value="" />
		</form>
	</div>
	<div class="col col-lg-2">
		<a href="add.jsp" class="disabled btn btn-secondary">Administrator</a>
	</div>
</div>




<%
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	ArrayList<Students> students = new ArrayList<Students>();

	String status = (String) request.getAttribute("utilOutput");
	students = (ArrayList) request.getAttribute("students");
%>

<%
	if (students == null) {
%>
<p class="text-warning">Nothing to show.</p>
<%
	} else {
%>
<%=status%>


<table
	class='table table-bordered table-striped table-hover text-nowrap'>

	<thead>
		<tr>
			<th>#</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Gender</th>
			<!--  <th>Birthday</th>
			<th>Father Firstname</th>
			<th>Mother Firstname</th>
			<th>Mother Lastname</th>
			<th>Faculty</th>
			<th>Department</th>
			<!--  <th>Course</th>
			<th>Level</th>
			<th>Major</th> -->
			<th>Registration</th>
			<th class='text-center'>Action</th>
	</thead>
	<tbody>

		<%
			for (int i = 0; i < students.size(); i++) {
		%>

		<tr>
			<td><%=students.get(i).getId()%></td>

			<td><%=students.get(i).getFirstname()%></td>

			<td><%=students.get(i).getLastname()%></td>

			<td><%=students.get(i).getGender()%></td>

			<!-- <td><%=students.get(i).getBday()%></td>

			<td><%=students.get(i).getFirstfather()%></td>

			<td><%=students.get(i).getFirstmaiden()%></td>
			<td><%=students.get(i).getLastmaiden()%></td> 

			 <td><%=students.get(i).getFaculty().getName()%></td>
			<td><%=students.get(i).getDepartment().getName()%></td>

			<td><%=students.get(i).getCourse()%></td>

			<td><%=students.get(i).getLevel()%></td> 

			<td><%=students.get(i).getMajor().getName()%></td>-->

			<td><%=students.get(i).getLastyear()%></td>

			<td class='text-center'>

				<button type="button" class="btn btn-warning btn-sm"
					onClick="window.open
('view?studentId=<%=students.get(i).getId()%>','window','width=500,height=500')">Check
					Photo</button>
		</tr>

		<%
			}
		%>
	</tbody>
</table>
<%
	}
%>
<jsp:include page="footer.jsp" />
</html>
