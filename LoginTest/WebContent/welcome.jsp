<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>WELCOME</title>
</head>

<body>

	<h3><s:property value="userName"/>さん、ようこそ！</h3>

	<br>

	<table>
		<tbody>
			<tr>
				<th>USERNAME</th>
				<th>PASSWORD</th>
			</tr>
			<tr>
				<td><s:property value="userName"/></td>
				<td><s:property value="password"/></td>
			</tr>
		</tbody>
	</table>
</body>
</html>