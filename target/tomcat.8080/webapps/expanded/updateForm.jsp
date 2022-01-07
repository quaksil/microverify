<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ page import="model.Students,java.text.SimpleDateFormat"%>
<% 	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
Students student = (Students) request.getAttribute("student");%>
<html>
<jsp:include page="header.jsp" />
<p>
	<br />
</p>
<p></p>
<h3>Update a Student Record</h3>
<form name="updateForm" action="updateStudent" method="GET">

	<!--<input type="hidden" name="id" value="<%=student.getId()%>"/>-->

	<div class="mb-3">
		<label for="studentId" class="form-label">Student ID:</label> <input
			type="text" class="form-control" id="studentId" name="id"
			value="<%=student.getId()%>" readonly />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Student firstname:</label> <input
			type="text" class="form-control" name="firstname"
			value="<%=student.getFirstname()%>" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Student lastname:</label> <input
			type="text" class="form-control" name="lastname"
			value="<%=student.getLastname()%>" />
	</div>

	<div class="mb-3">
		<label for="gender" class="form-label">Gender:</label> <select
			class="form-control" id="gender" name="gender"
			value="<%=student.getGender()%>">
			<option value="Male">Male</option>
			<option value="Female">Female</option>
		</select>

	</div>

	<div class="mb-3">
		<label for="" class="form-label">Birthday:</label> <input type="date"
			class="form-control" name="bday" value="<%=student.getBday()%>" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Father's firstname:</label> <input
			type="text" class="form-control" name="firstfather"
			value="<%=student.getFirstfather()%>" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Mother's firstname:</label> <input
			type="text" class="form-control" name="firstmaiden"
			value="<%=student.getFirstmaiden()%>" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Mother's maiden name:</label> <input
			type="text" class="form-control" name="lastmaiden"
			value="<%=student.getLastmaiden()%>" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Faculty:</label> <input type="text"
			class="form-control" name="faculty"
			value="<%=student.getFaculty().getName()%>" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Department:</label> <input
			type="text" class="form-control" name="department"
			value="<%=student.getDepartment().getName()%>" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Course:</label> <input type="text"
			class="form-control" name="course" value="<%=student.getCourse()%>" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Level:</label> <input type="text"
			class="form-control" name="level" value="<%=student.getLevel()%>" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Major:</label> <input type="text"
			class="form-control" name="major"
			value="<%=student.getMajor().getName()%>" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Last registration:</label> <input
			type="text" class="form-control" name="lastyear"
			value="<%=student.getLastyear()%>" />
	</div>
	<button type="submit" class="btn btn-warning">Update</button>
	<a href="index.jsp" class="btn btn-default">Back</a>

</form>

<jsp:include page="footer.jsp" />
</html>
