<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle var="textsBundle" basename="texts"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="prihlasovanie.okno.titulok" bundle="${textsBundle}"/></title>
	<link href="<c:url value="/styles/main.css"/>" rel="stylesheet" type="text/css"/>
	<script language="JavaScript">
	<!--
		function setFocus() {
			document.getElementById('login_id').focus();
		}
	// -->
	</script>
</head>
<body onload="setFocus();">

<form action="j_security_check" method="POST">

	<table>
	<tr>
		<td align="right"><fmt:message key="prihlasovanie.vstup.meno" bundle="${textsBundle}"/></td>
		<td><input id="login_id" name="j_username"/></td>
	</tr>
	<tr>
		<td align="right"><fmt:message key="prihlasovanie.vstup.heslo" bundle="${textsBundle}"/></td>
		<td><input name="j_password" type="password"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="<fmt:message key="prihlasovanie.tlacidlo.prihlasit" bundle="${textsBundle}"/>"/>
			<c:set var="chyba" scope="page">
				<%=request.getParameter("chyba") %>
			</c:set>
			<c:if test="${chyba=='1'}">
				<fmt:message key="prihlasovanie.chyba" bundle="${textsBundle}"/>
			</c:if>
		</td>
	</tr>
	</table>

</form>

</body>
</html>
