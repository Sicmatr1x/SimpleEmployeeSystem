﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="demo.beans.Employee"%>
<%@ page import="demo.dao.EmployeeDAO"%>
<%@ page import="demo.service.EmployeeService"%>
<html>
<body>
<form action="edit">
	<% int id=request.getAttribute("id"); %>
	<input id="id" value="#{employee.id}"/>
</form>
</body>
</html>