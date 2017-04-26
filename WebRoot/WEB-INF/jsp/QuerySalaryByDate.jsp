<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="demo.beans.Salary"%>
<%@ page import="demo.dao.SalaryDAO"%>
<%@ page import="demo.service.SalaryService"%>
<%@ page import="demo.service.DateFactory"%>
<%!SalaryService salaryService = new SalaryService();%>
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
<title>QuerySalaryByDate</title>
<link href="<%=basePath%>resources/css/all.css" rel="stylesheet"
	type="text/css" />
</head>

<script type="text/javascript">
    
    function openEditWindow(id,empid){
    	var mounth=prompt("月份","2017-04-01");
    	var salary=prompt("月工资","");
    	if(mounth != null && mounth != "" && salary != null && salary != ""){
    		
    		window.location.href='editSalary?id=' + id + '&empid=' + empid+ '&mounth=' + mounth + '&salary=' + salary;
    	}else{
    		alert("属性不能为空！");
    	}
    	
    }
    
    function deleteSalary(id){
    	window.location.href='deleteSalary?id=' + id;
    }
    
    function queryEmployeeSalary(){
    	var empid=prompt("工号","");
    	if(empid != null && empid != ""){
    		window.location.href='queryEmployeeSalary?empid=' + empid;
    	}else{
    		alert("属性不能为空！");
    	}
    }
    
    function queryDepartmentSalary(){
    	var department=prompt("部门","");
    	if(department != null && department != ""){
    		window.location.href='queryDepartmentSalary?department=' + department;
    	}else{
    		alert("属性不能为空！");
    	}
    }

	function test(){
		alert("test");
	}
</script>
<body style="background: #e1e9eb;">

	<div class="right">
		<div class="current">
			当前位置：<a href="/SimpleEmployeeSystem/index.jsp" style="color:#6E6E6E;">主页</a>
			&gt;<a href="/SimpleEmployeeSystem/getSalaryList" style="color:#6E6E6E;">SalaryList
		</div>
		<div class="rightCont">
			<p class="g_title fix">
				刷新 <a class="btn03" onclick="queryEmployeeSalary()">查询员工工资</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
					class="btn03" onclick="queryDepartmentSalary()">查询部门工资</a>
			</p>
			<table class="tab1">
				<tbody>
					<form action="addSalary" id="add" method="get">
						编号：<input type="text" name="id" value="" />
						 工号：<input type="text" name="empid" value="" />
						 月份：<input type="text" name="mounth" value="2017-04-01" />
						月工资：<input type="text" name="salary" value="" />
							 <input type="submit" class="tabSub" value="插入" />
					</form>
				</tbody>
			</table>
			<div class="zixun fix">
				<table class="tab2" width="100%">
					<tbody>
						<tr>
							<th><input type="checkbox" id="all" onclick="" /></th>
							<th>编号(id)</th>
							<th>工号(empid)</th>
							<th>月份(mounth)</th>
							<th>月工资(salary)</th>
							<th>操作</th>
						</tr>
						<%
							List<Salary> list = (List<Salary>) session.getAttribute("list");
						%>
						<%
							for (int i = 0; i < list.size(); i++) {
								Salary t = list.get(i);
						%>
						<tr <%if (i % 2 == 1) {out.print(" style=\"background-color:#ECF6EE;\"");}%>>
							<td><input type="checkbox" /></td>
							<td><%=t.getId()%></td>
							<td><%=t.getEmpid()%></td>
							<td><%=DateFactory.getDateToString(t.getMounth())%></td>
							<td><%= t.getSalary() %></td>
							<td><button onClick="openEditWindow(<%=t.getId()%>,<%=t.getEmpid()%>)" class="tabSub">修改</button>&nbsp;&nbsp;&nbsp;
								<button onClick="deleteSalary(<%=t.getId()%>)" class="tabSub">删除</button></td>
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