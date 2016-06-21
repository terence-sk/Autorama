<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ page import="java.text.MessageFormat"%>
<%@ page import="java.util.ResourceBundle"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle var="textsBundle" basename="texts"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="chyba.okno.titulok" bundle="${textsBundle}"/></title>
	<link href="<c:url value="/styles/main.css"/>" rel="stylesheet" type="text/css"/>
	<script language="JavaScript">
	<!--
		function setFocus() {
			document.getElementById('back_id').focus();
		}
	// -->
	</script>
</head>
<body onload="setFocus();">

	<br/>
	<%= exception.getMessage() %><br/>
	<br/>
	<br/>
	<input id="back_id" type="button" value="<fmt:message key="chyba.tlacidlo.naspat" bundle="${textsBundle}"/>"
			onclick="javascript:history.go(-1);"/>
	<br/>
	<br/>

</body>
</html>
