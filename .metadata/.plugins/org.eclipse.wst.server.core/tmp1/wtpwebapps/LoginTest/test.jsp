<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>新規登録完了</title>
</head>

<body>
	<br>
	<h3>以下の新規ユーザーが登録されました。</h3>
	<br>
<table>
<tbody>
	<tr>
		<th>USERNAME</th>
		<th>PASSWORD</th>
	</tr>
	<s:iterator value="#session.loginDTOList">
	<tr>
		<td><s:property value="userName"/></td>
		<td><s:property value="password"/></td>
	</tr>
	</s:iterator>
</tbody>
</table>

</body>
</html>