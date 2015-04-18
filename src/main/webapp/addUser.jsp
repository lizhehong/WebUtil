<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
	<s:form action="signIn" enctype="multipart/form-data" method="post">

		<s:textfield name="username" label="用户名" />
		<s:password name="password" label="密码" />
		<s:textfield name="nick" label="用戶姓名" />
		<s:radio list="#{'1':'男','0':'女'} " value='1' name="sex" label="性別" />
		<s:select list="#{'研究生':'研究生','本科':'本科','专科':'专科','高中':'高中' }"
			headerKey="" headerValue="请选择" label="学历" name="education" />
		<s:textfield name="birthday" label="出生日期" />
		<s:textfield name="telephone" label="電話號碼" />
		<s:checkboxlist list="#{'足球':'足球','篮球':'篮球','乒乓球':'乒乓球','羽毛球':'羽毛球'}"
			name="hobbies" label="爱好" />
		<s:file name="image" label="照片" />
		<s:textarea label="簡介" name="remark" />
		<s:submit value="保存" />
		<s:reset value="重置" />

	</s:form>
</body>
</html>