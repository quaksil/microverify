<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Photo, java.util.Base64"%>

<html>
<jsp:include page="header.jsp" />
<p>
	<br />
</p>
<p></p>



<head>
<meta charset="UTF-8">
<title>Student Photo</title>
</head>
<body>

	<%
		Photo photo = (Photo) request.getAttribute("photo");
	%>

	<p class="fw-light text-center">
		Student ID:
		<%=photo.getStudentId()%></p>


	<img src="data:;base64,<%=photo.getBase64Image()%>"
		class="border border-success border-2 rounded mx-auto d-block" alt="..." width=300 height=300>
</body>
<jsp:include page="footer.jsp" />
</html>