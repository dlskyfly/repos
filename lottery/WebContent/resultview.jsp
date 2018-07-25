<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="model.BallRedFilter"%>
<%@ page import="impl.BallRedFilterImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%
		    BallRedFilterImpl ballRedFilterImpl = new BallRedFilterImpl();
		    int countNum = ballRedFilterImpl.getCount();
		    request.setAttribute("countNum", countNum);
		%>
		<c:out value="处理后，共有${countNum}条数据。"></c:out>
		<%
		    List<BallRedFilter> results = ballRedFilterImpl.getRedFromRandom(6);
		    request.setAttribute("results", results);
		%>
		<table width="80%" border="1px" cellpadding="0" cellspacing="0">
			<c:forEach items="${results}" var="result">
				<tr>
					<td>${result.red1}</td>
					<td>${result.red2}</td>
					<td>${result.red3}</td>
					<td>${result.red4}</td>
					<td>${result.red5}</td>
					<td>${result.red6}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>