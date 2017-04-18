﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="demo.beans.Employee"%>
<%@ page import="demo.dao.EmployeeDAO"%>
<%@ page import="demo.service.EmployeeService"%>
<%!EmployeeService employeeService = new EmployeeService();%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
<title>内容列表页面</title>
<link href="<%=basePath%>resources/css/all.css" rel="stylesheet"
	type="text/css" />
</head>
<script>
	//获得XMLHttpRequest对象
	function createXMLHttpRequest() {
		var xmlHttp;
		if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
			if (xmlHttp.overrideMimeType)
				xmlHttp.overrideMimeType('text/xml');
		} else if (window.ActiveXObject) {
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}
		return xmlHttp;
	}


	function addEmployee() {
		var id = document.getElementById("add_id");
		var name = document.getElementById("add_name");
		var age = document.getElementById("add_age");
		var sex = document.getElementById("add_sex");
		alert(id.toString() + ";" + name.toString() + ";" + age.toString() + ";" + sex.toString());
		xmlHttp = createXMLHttpRequest();
		var url = "http://localhost:8080/SimpleEmployeeSystem/addEmployee?id=" + id +
		"&name=" + name + "&age=" + age + "&sex=" + sex;
		xmlHttp.open("GET", url, true);// 异步处理返回   
		xmlHttp.onreadystatechange = callback;
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;");
		xmlHttp.send();
	}
	
	function test(){
		alert("test");
	}
</script>
<body style="background: #e1e9eb;">
	<form action="" id="mainForm" method="post">
		<div class="right">
			<div class="current">
				当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a>
				&gt; 内容列表
			</div>
			<div class="rightCont">
				<p class="g_title fix">
					内容列表 <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn03" href="#">删 除</a>
				</p>
				<table class="tab1">
					<tbody>
						<tr>
							<td width="90" align="right">工号：</td>
							<td><input type="text" id="add_id" value="" /></td>
							<td width="90" align="right">姓名：</td>
							<td><input type="text" id="add_name" value="" /></td>
							<td width="90" align="right">年龄：</td>
							<td><input type="text" id="add_age" value="" /></td>
							<td width="90" align="right">性别：</td>
							<td><input type="text" id="add_sex" value="" /></td>
							<td width="90" align="right"><input type="button"
								onClick="addEmployee()" class="tabSub" value="插入" /></td>
						</tr>
					</tbody>
				</table>
				<div class="zixun fix">
					<table class="tab2" width="100%">
						<tbody>
							<tr>
								<th><input type="checkbox" id="all" onclick="" /></th>
								<th>工号(id)</th>
								<th>姓名(name)</th>
								<th>年龄(age)</th>
								<th>性别(sex)</th>
								<th>操作</th>
							</tr>
							<%
								//List<Employee> list = employeeService.getAllEmployee();
													List<Employee> list = (List<Employee>)session.getAttribute("list");
							%>
							<%
								for (int i = 0; i < list.size(); i++) {
														Employee emp = list.get(i);
							%>
							<tr
								<%if(i%2==1){out.print(" style=\"background-color:#ECF6EE;\"");}%>>
								<td><input type="checkbox" /></td>
								<td><%=emp.getId()%></td>
								<td><%=emp.getName()%></td>
								<td><%=emp.getAge()%></td>
								<td><%=emp.getSex()%></td>
								<td><a
									href="/SimpleEmployeeSystem/edit?id=<%=emp.getId()%>">修改</a>&nbsp;&nbsp;&nbsp;
									<a href="#">删除</a></td>
							</tr>
							<%
								}
							%>
							
						</tbody>
						
					</table>
					<div class='page fix'>
						共 <b><%=list.size()%></b> 条 <a href='###' class='first'>首页</a> <a
							href='###' class='pre'>上一页</a> 当前第<span>1/1</span>页 <a href='###'
							class='next'>下一页</a> <a href='###' class='last'>末页</a> 跳至&nbsp;<input
							type='text' value='1' class='allInput w28' />&nbsp;页&nbsp; <a
							href='###' class='go'>GO</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>