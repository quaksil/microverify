<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<html>
<jsp:include page="header.jsp" />
<p>
	<br />
</p>
<p></p>
<h3>Add a new Student</h3>
<form name="addForm" action="addStudent" method="GET">

	<div class="mb-3">
		<label for="" class="form-label">Firstname:</label> <input type="text" class="form-control"
			name="firstname" placeholder="Student firstname" value="" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Lastname:</label> <input type="text" class="form-control"
			name="lastname" placeholder="Student lastname" value="" />
	</div>
	<div class="mb-3">
		<label for="gender" class="form-label">Gender:</label> <select class="form-control"
			id="gender" name="gender" placeholder="Male/Female" value="" />
		<option value="Male">Male</option>
		<option value="Female">Female</option>
		</select>

	</div>
	<div class="mb-3">
		<label for="" class="form-label">Birthday:</label> <input type="date" class="form-control"
			name="bday" placeholder="Birthday yyyy-mm-dd" value="" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Father's firstname:</label> <input type="text"
			class="form-control" name="firstfather"
			placeholder="Firstname of the father" value="" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Mother's firstname:</label> <input type="text"
			class="form-control" name="firstmaiden"
			placeholder="Firstname of the mother" value="" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Mother's maiden name:</label> <input type="text"
			class="form-control" name="lastmaiden"
			placeholder="Lastname of the father" value="" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Faculty:</label> <input type="text" class="form-control"
			name="faculty" placeholder="Faculty (ex. NTIC)" value="" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Department:</label> <input type="text" class="form-control"
			name="department" placeholder="Department (ex. TLSI)" value="" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Course:</label> <input type="text" class="form-control"
			name="course" placeholder="Course (ex. Master)" value="" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Level:</label> <input type="text" class="form-control"
			name="level" placeholder="Level (ex. BAC+2)" value="" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Major:</label> <input type="text" class="form-control"
			name="major" placeholder="Major (ex. Génie Logiciel)" value="" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Last registration:</label> <input type="text"
			class="form-control" name="lastyear" placeholder="Registration year"
			value="" />
	</div>
	<button type="submit" class="btn btn-outline-primary">Submit</button>
	<a href="index.jsp" class="btn btn-default">Back</a>

</form>
<jsp:include page="footer.jsp" />
</html>

