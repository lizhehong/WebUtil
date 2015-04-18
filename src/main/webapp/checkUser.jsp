<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用戶查看</title>
</head>
<body>
	<table>
		<tr>
			<th>登录名</th>
			<th>姓名</th>
			<th>学历</th>
			<th>生日</th>
			<th>电话</th>
			<th>爱好</th>
			<th>性别</th>

		</tr>
		<tr>
			<td><s:property value="%{#user.username}" /></td>
			<td><s:property value="%{#user.nick}" /></td>
			<td><s:property value="%{#user.education}" /></td>
			<td><s:property value="%{#user.birthday}" /></td>
			<td><s:property value="%{#user.telephone}" /></td>
			<td><s:property value="#user.hobbies" /></td>
			<td><s:property value="#user.sex==0?'女':'男'" /></td>

		</tr>
		<tr>
			<th>简介</th>

		</tr>
		<tr>
			<td><s:property value="%{#user.remark}" /></td>
		</tr>
		<tr>
			<td><s:url action="dowmloadUserImg" encode="UTF-8"
					escapeAmp="false" var="url">
					<s:param name="filename" value="#user.filename"></s:param>
					<s:param name="path" value="#user.path"></s:param>
				</s:url> <a href="<s:property value='#url'/>">下载</a></td>
		</tr>
		<s:debug />
	</table>
</body>
</html>