<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle var="textsBundle" basename="texts"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="studenti.okno.titulok" bundle="${textsBundle}"/></title>
	<link href="<c:url value="/styles/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<table>
<tr>
	<th><fmt:message key="studenti.tabulka.meno_priezvisko" bundle="${textsBundle}"/></th>
	<th><fmt:message key="studenti.tabulka.zac_studia" bundle="${textsBundle}"/></th>
</tr>
<c:forEach var="student" items="${studenti}">
<tr>
	<td><a href="studentiServlet?id=${student.id}">${student.meno} ${student.priezvisko}</a></td>
	<td>${student.zaciatokStudia}</td>
</tr>
</c:forEach>
</table>

</body>
</html>
