<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<%@include file="include/header.jsp" %>
<main>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<%@include file="include/footer.jsp" %>
</main>
</body>
</html>
