<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
<script>
	function addAttendBySQLAdd(){
		var sql = document.getElementById("text").valueOf();
		
	}
</script>
<title>EmployeeList</title>
</head>
	<body>
		<form action="addAttendBySQLAdd" id="add" method="post">
			SQL语句： <input type="text" name="sql" value="" />
			<input type="submit" value="submit" />
		</form>
	</body>
</html>