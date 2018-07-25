<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="impl.BallHistoryImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
.dropdown {
	position: relative;
	display: inline-block;
}

.div2 {
	position: absolute;
	top: 220px;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 80px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	padding: 12px 16px;
	height: 180px;
}

.dropdown:hover .dropdown-content {
	display: block;
}

select {
	border: none;
	outline: none;
	width: 100%;
	height: 100%;
	-moz-appearance: button;
	padding-left: 60px;
}

span {
	background-color: #ffcc00;
	display: -moz-inline-box;
	display: inline-block;
	width: 150px;
}
</style>
</head>
<body>
	<form action="FilterServlet" method="post">
		<div class="dropdown">
			<span>大小比</span> <select name="bigsmall" multiple="true"
				class="dropdown-content">
				<option value="0">0:6</option>
				<option value="1">1:5</option>
				<option value="2">2:4</option>
				<option value="3">3:3</option>
				<option value="4">4:2</option>
				<option value="5">5:1</option>
				<option value="6">6:0</option>
			</select>
		</div>
		<div class="dropdown">
			<span>重号</span> <select name="repeatnumber" multiple="true"
				class="dropdown-content">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
			</select>
		</div>
		<div class="dropdown">
			<span>中奖期号</span>
			<%
			    BallHistoryImpl ballHistoryImpl = new BallHistoryImpl();
			    List<Integer> listDates = ballHistoryImpl.getHistoryDate();
			    request.setAttribute("listDates", listDates);
			%>
			<select name="historydate" class="dropdown-content">
				<c:forEach items="${listDates}" var="listDate" varStatus="status">
					<option value="${listDate.dateNo}">${listDate.dateNo}</option>
				</c:forEach>
			</select>
		</div>
		<div class="dropdown">
			<span>和值</span> <select name="sumvalue" multiple="true"
				class="dropdown-content">
				<option value="0">21-60</option>
				<option value="1">60-70</option>
				<option value="2">71-80</option>
				<option value="3">81-90</option>
				<option value="4">91-100</option>
				<option value="5">101-110</option>
				<option value="6">111-120</option>
				<option value="7">121-130</option>
				<option value="8">131-140</option>
				<option value="9">141-150</option>
				<option value="10">151-160</option>
				<option value="11">161-183</option>
			</select>
		</div>
		<div class="dropdown">
			<span>连号</span> <select name="consecutivenumber" multiple="true"
				class="dropdown-content">
				<option value="0">无连号</option>
				<option value="1">1组两连号</option>
				<option value="2">2组两连号</option>
				<option value="3">3组两连号</option>
				<option value="4">1组三连号</option>
				<option value="5">2组三连号</option>
				<option value="6">四连号</option>
			</select>
		</div>
		<div class="div2">
			<div class="dropdown">
				<span>奇偶比</span> <select name="parityratio" multiple="true"
					class="dropdown-content">
					<option value="0">0:6</option>
					<option value="1">1:5</option>
					<option value="2">2:4</option>
					<option value="3">3:3</option>
					<option value="4">4:2</option>
					<option value="5">5:1</option>
					<option value="6">6:0</option>
				</select>
			</div>
			<div class="dropdown">
				<span>质合</span> <select name="primecomposite" multiple="true"
					class="dropdown-content">
					<option value="0">0:6</option>
					<option value="1">1:5</option>
					<option value="2">2:4</option>
					<option value="3">3:3</option>
					<option value="4">4:2</option>
					<option value="5">5:1</option>
					<option value="6">6:0</option>
				</select>
			</div>
			<div class="dropdown">
				<span>跳号</span> <select name="jumpnumber" multiple="true"
					class="dropdown-content">
					<option value="0">0</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>
			</div>
			<div class="dropdown">
				<span>同尾号(组)</span> <select name="tailNumber1" class="dropdown-content">
					<option value="0">0</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>
				</div>
				<div class="dropdown">
				<span>同尾号(每组最多)</span> <select name="tailNumber2" class="dropdown-content">
					<option value="1">不限制</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
			</div>
			<div class="div2">
				<input type="checkbox" name="init" value="0" />重新初始化&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" value="提交">
			</div>
		</div>
	</form>

</body>
</html>