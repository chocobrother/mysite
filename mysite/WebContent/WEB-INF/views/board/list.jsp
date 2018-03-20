<%@page import="com.cafe24.mysite.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url ="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
				
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>		
					
					<c:forEach items="${list}" var = "vo" varStatus = "status">

					<input type ="hidden" name ="no" value = "${sessionScope.authUser.no }"/>
					<tr>
						<td>${vo.no}</td>
						<td  style = "text-align:left; padding-left:${20*vo.depth}px">
						<c:if test = '${vo.depth gt 1 }' >
						 <img src = "/mysite/assets/images/reply.png"/> 
						 </c:if>
						<a href="/mysite/board?a=view&no=${vo.no}&pg=${requestScope.pg}">${vo.title}</a></td>
						<td>${vo.user_name }</td>
						<td>${vo.hit}</td>
						<td>${vo.write_date}</td>
						<c:if test = "${not empty authUser && sessionScope.authUser.no == vo.user_no}">
						<td>
						<a href="/mysite/board?a=delete&user_no=${sessionScope.authUser.no }&no=${vo.no}" class="del">삭제</a>
						</td>
						</c:if>
					</tr>
						</c:forEach>
						
					<!-- 페이징	-->
					<tr>
						<td colspan ="6" align = "center">
							<c:if test="${requestScope.startPage > 3 }">
							[<a id = "paging" href = "/mysite/board?pg=${requestScope.startPage -1}">이전</a>]	
							</c:if>	
						<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
							<c:if test="${i eq pg }">
								[<a id="currentPaging" href="/mysite/board?pg=${i}">${i}</a>]
							</c:if>
							
							<c:if test="${i ne pg }">
								[<a id="paging" href="/mysite/board?pg=${i}">${i}</a>]
							</c:if>
							</c:forEach>
							<c:if test="${requestScope.endPage < totalP }">
								[<a id = "paging"
								href="/mysite/board?pg=${requestScope.endPage+1 }">다음</a>]
							</c:if>
					</td>
				</tr> 

				</table>
			
				
				<c:if test = "${sessionScope.authUser.no != vo.user_no }">		
				<div class="bottom">
					<a href="/mysite/board?a=write" id="new-book">글쓰기</a>
				</div>				
				</c:if>
			</div>
			
		</div>
			<c:import url ="/WEB-INF/views/includes/navigation.jsp" />
			<c:import url ="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>