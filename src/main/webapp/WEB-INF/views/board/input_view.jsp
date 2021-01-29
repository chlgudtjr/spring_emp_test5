<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>사원정보입력</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/resources/demos/style.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#datepicker").datepicker();
		});
	</script>
</head>
<body>
<h1> 사원 정보입력 </h1>
<hr></hr>
	<form action="${pageContext.request.contextPath }/input" method="post">
		사원번호 <input type="text" name="empno"> <br/>
		사원이름 <input type="text" name="ename"> <br/>
		사원직급 <input type="text" name="job"> <br/>
		매니저 <select name="mgr">
			 <c:forEach var="empVO" items="${list}">
				<option value="${empVO.empno}">(${empVO.empno})${empVO.ename}</option>
			 </c:forEach>
			 </select><br/>
		입사일 <input type="text" id="datepicker"><br/>
		급여 <input type="text" name="sal"> <br/>
		커미션 <input type="text" name="comm"> <br/>
		부서 <select name="deptNo">
			<c:forEach var="empVO" items="${list}">
				<option value="${empVO.deptno}">(${empVO.deptno})${empVO.dname} </option>
			</c:forEach>
			</select>
		<br/><input type="submit" value="입력">
	</form>
</body>
</html>
