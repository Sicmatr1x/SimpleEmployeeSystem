<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<title>EmployeeList</title>
<link href="<%=basePath%>resources/css/all.css" rel="stylesheet"
	type="text/css" />
</head>

<script type="text/javascript">
    
    function openEditWindow(id){
    	var name=prompt("姓名","");
    	var age=prompt("年龄","");
    	var sex=prompt("性别","");
    	if(name != null && name != "" && age != null && age != "" && sex != null && sex != ""){
    		
    		window.location.href='editEmployee?id=' + id + '&name=' + name+ '&age=' + age + '&sex=' + sex;
    	}else{
    		alert("属性不能为空！");
    	}
    	
    }
    
    function deleteEmployee(id){
    	window.location.href='deleteEmployee?id=' + id;
    }

	function test(){
		alert("test");
	}
</script>
<body style="background: #e1e9eb;">

	<div class="right">
		<div class="current">
			当前位置：<a href="/SimpleEmployeeSystem/index.jsp" style="color:#6E6E6E;">主页</a>
			&gt;<a href="/SimpleEmployeeSystem/getEmployeeList" style="color:#6E6E6E;">EmployeeList
		</div>
		<div class="rightCont">
			<p class="g_title fix">
				刷新 <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
					class="btn03" href="#">删 除</a>
			</p>
			<table class="tab1">
				<tbody>
					<form action="addEmployee" id="add" method="get">
						工号： <input type="text" name="id" value="" /> 姓名： <input
							type="text" name="name" value="" /> 年龄： <input type="text"
							name="age" value="" /> 性别： <input type="text" name="sex"
							value="" /> <input type="submit" class="tabSub" value="插入" />
					</form>
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
							List<Employee> list = (List<Employee>) session.getAttribute("list");
						%>
						<%
							for (int i = 0; i < list.size(); i++) {
								Employee emp = list.get(i);
						%>
						<tr
							<%if (i % 2 == 1) {
					out.print(" style=\"background-color:#ECF6EE;\"");
				}%>>
							<td><input type="checkbox" /></td>
							<td><%=emp.getId()%></td>
							<td><%=emp.getName()%></td>
							<td><%=emp.getAge()%></td>
							<td><%=emp.getSex()%></td>
							<td><button onClick="openEditWindow(<%=emp.getId()%>)" class="tabSub">修改</button>&nbsp;&nbsp;&nbsp;
								<button onClick="deleteEmployee(<%=emp.getId()%>)" class="tabSub">删除</button></td>
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

</body>
</html>