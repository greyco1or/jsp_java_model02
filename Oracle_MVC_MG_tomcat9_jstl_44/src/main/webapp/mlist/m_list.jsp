<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
포워드 경로 /mlist/m_list.jsp 	<br><br>
<a href="${pageContext.request.contextPath}/Min/m_insert_form.ksmart_m">회원가입</a><br><br>
회원 리스트 						<br>
<table width="100%" border="1">
<tr>
	<td>아이디</td><td>비번</td><td>권한</td><td>이름</td><td>이메일</td><td>수정</td><td>삭제</td>
</tr>
<c:forEach items="${alm}" var="alm" varStatus="status">
	<tr>
		<td>${alm.ora_id}</td>
		<td>${alm.ora_pw}</td>
		<td>${alm.ora_level}</td>
		<td>${alm.ora_name}</td>
		<td>${alm.ora_email}</td>
		<td>
<a href="<%= request.getContextPath() %>/mupdate/m_update_form.jsp?send_id=${alm.ora_id}">수정버튼</a>
							<!-- 수정버튼 클릭시 경로 확장자 ksmart_m으로 변경 후 작업 시작 -->			
		</td>
		<td>
<a href="<%= request.getContextPath() %>/mdelete/m_delete_action.jsp?send_id=${alm.ora_id}">삭제버튼</a>
							<!-- 삭제버튼 클릭시 경로 확장자 ksmart_m으로 변경 후 작업 시작 -->			
		</td>	
	</tr>
</c:forEach>
</table>
</body>
</html>