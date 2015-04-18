<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
</head>
<body>

	<s:form action="login" method="post">
		<s:textfield label="登陆名称" name="username" />
		<s:password label="密码" name="password" />
		<s:submit value="登陆" />
		<s:reset value="清除" />
	</s:form>
	<hr />
	<a href="${pageContext.request.contextPath}/addUser.jsp">请注册</a>
	<s:debug />
</body>
</html>