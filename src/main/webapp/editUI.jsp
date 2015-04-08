<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用戶</title>
</head>
<body>
	<s:form action="editUser" enctype="multipart/form-data" method="post">
		<s:hidden value="%{#user.id}" name="userId"/>
		<s:textfield name="username" label="用户名" value="%{#user.username}" />
		<s:password name="password" label="密码" />
		<s:textfield name="nick" label="用戶姓名" value="%{#user.nick}" />
		<s:radio list="#{'1':'男','0':'女'} " name="sex" value="#user.sex"
			label="性別" />
		<s:select list="#{'研究生':'研究生','本科':'本科','专科':'专科','高中':'高中' }"
			headerKey="" headerValue="请选择" label="学历" name="education"
			value="%{#user.education}" />
		<s:textfield name="birthday" label="出生日期" value="user.birthday"
			value="%{#user.birthday}" />
		<s:textfield name="telephone" label="電話號碼" value="user.telephone"
			value="%{#user.telephone}" />
		<s:checkboxlist list="#{'足球':'足球','篮球':'篮球','乒乓球':'乒乓球','羽毛球':'羽毛球'}"
			name="hobbies" label="爱好" value="#user.hobbies" />
		<s:file name="image" label="照片" />
		<s:textarea label="簡介" name="remark" value="user.remark"
			value="%{#user.remark}" />
		<s:submit value="保存" />
		<s:reset value="重置" />

	</s:form>
</body>
</html>