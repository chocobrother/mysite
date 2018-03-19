<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
				<c:import url ="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="user">

				<form id="modify-form" name="modifyform" method="post" action="/mysite/user">
					<input type ="hidden" name ="a" value = "modify"/> 
					<input type ="hidden" name ="no" value = "${sessionScope.authUser.no }"/>
					<input type = "hidden" name = "email" value = "${sessionScope.authUser.email }"/>
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="${sessionScope.authUser.name }">
					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="${sessionScope.authUser.email }">
					
					
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">
					
					<fieldset>
						<legend>성별</legend>
						<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
						<label>남</label> <input type="radio" name="gender" value="male">
					</fieldset>
					
					<input type="submit" value="변경하기">
					
				</form>
			</div>
		</div>
		<c:import url ="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url ="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>