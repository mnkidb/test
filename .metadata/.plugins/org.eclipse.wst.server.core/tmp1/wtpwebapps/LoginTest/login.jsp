<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>

<body>

	<h3>名前とパスワードを入力してください。</h3>

	<s:form action="LoginAction">
		<s:textfield name="userName" label="ユーザー名"/>
		<s:password name="password" label="パスワード"/>
		<s:submit value="送信"/>
	</s:form>

</body>
</html>