<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有的用户</title>
</head>
<body>
<body style="text-align: center;">
	<table width="88%">
		<tr>
			<td><s:form action="queryConditionUser">
					<s:textfield name="username" label="用戶名" />
					<s:select list="#{'0':'女','1':'男'}" name="sex" label="性別"
						headerValue="请选择" headerKey="" />
					<s:select list="#{'研究生':'研究生','本科':'本科','专科':'专科','高中':'高中' }"
						headerKey="" headerValue="请选择" label="学历" name="education" />
					<s:submit value="查询" />
				</s:form></td>
		</tr>
		<tr>
			<td align="center">用戶列表</td>
		</tr>
		<tr align="right">
			<td><a href="${pageContext.request.contextPath}/addUser.jsp">添加用戶</a>
			</td>
		</tr>
		<tr>
			<td>
				<table frame="border" width="100%">
					<tr>
						<th>用戶名</th>
						<th>姓名</th>
						<th>性別</th>
						<th>聯繫電話</th>
						<th>學歷</th>
						<th>編輯</th>
						<th>查看</th>
						<th>刪除</th>
					</tr>
					<s:iterator value="#users" var="user" status="vs">
						<tr bgcolor="<s:property value='#vs.even?"#A6A6A6":"#627c8c"'/>">
							<td><s:property value="#user.username" /></td>
							<td><s:property value="#user.nick" /></td>
							<td><s:property value="#user.sex==0?'女':'男'" /></td>
							<td><s:property value="#user.telephone" /></td>
							<td><s:property value="#user.education" /></td>
							<td>
							<s:url action="editUIUser" var="url">
								<s:param name="userId" value="#user.id" />
							</s:url>
							<a href='<s:property value="url"/>'>编辑</a>
							</td>
							<td>查看</td>
							<td><s:url action="delUser" var="url">
									<s:param name="userId" value="#user.id" />
								</s:url>
								<a href="<s:property value='url'/>">刪除</a>
							</td>
						</tr>
					</s:iterator>
				</table>
			</td>
		</tr>
	</table>
</body>
</body>
</html>
