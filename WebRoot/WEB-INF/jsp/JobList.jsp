<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="demo.beans.Job"%>
<%@ page import="demo.dao.JobDAO"%>
<%@ page import="demo.service.JobService"%>
<%@ page import="demo.service.DateFactory"%>
<%!JobService jobService = new JobService();%>
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

<script type="text/javascript">
    
    function openEditWindow(id,empid){
    	var jobType=prompt("工种","BOSS,PROGRAMMER,CLERK");
    	var jobLevel=prompt("等级","1,2,3,4,5");
    	var baseSalary=prompt("基本月工资","10000");
    	var department=prompt("部门","");
    	if(jobType != null && jobType != "" && jobLevel != null && jobLevel != ""
    	 && department != null && department != "" && baseSalary != null && baseSalary != ""){
    		
    		window.location.href='editJob?id=' + id + '&empid=' + empid+ '&jobType=' + jobType + '&jobLevel=' + jobLevel
    		+ '&department=' + department + '&baseSalary=' + baseSalary;
    	}else{
    		alert("属性不能为空！");
    	}
    	
    }
    
    function deleteJob(id){
    	window.location.href='deleteJob?id=' + id;
    }

	function test(){
		alert("test");
	}
</script>
<body style="background: #e1e9eb;">

	<div class="right">
		<div class="current">
			当前位置：<a href="/SimpleEmployeeSystem/index.jsp" style="color:#6E6E6E;">主页</a>
			&gt;<a href="/SimpleEmployeeSystem/getJobList" style="color:#6E6E6E;">JobList
		</div>
		<div class="rightCont">
			<p class="g_title fix">
				刷新 <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
					class="btn03" href="#">删 除</a>
			</p>
			<table class="tab1">
				<tbody>
					<form action="addJob" id="add" method="get">
						编号：<input type="text" name="id" value="" />
						 工号：<input type="text" name="empid" value="" />
						工种：<input type="text" name="jobType" value="BOSS,PROGRAMMER,CLERK" />
						等级：<input type="text" name="jobLevel" value="1,2,3,4,5" />
						部门：<input type="text" name="department" value="" />
						基本月工资：<input type="text" name="baseSalary" value="10000" />
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
							<th>工种(jobType)</th>
							<th>等级(jobLevel)</th>
							<th>基本月工资(baseSalary)</th>
							<th>部门(department)</th>
							<th>操作</th>
						</tr>
						<%
							List<Job> list = (List<Job>) session.getAttribute("list");
						%>
						<%
							for (int i = 0; i < list.size(); i++) {
								Job t = list.get(i);
						%>
						<tr
							<%if (i % 2 == 1) {
					out.print(" style=\"background-color:#ECF6EE;\"");
				}%>>
							<td><input type="checkbox" /></td>
							<td><%=t.getId()%></td>
							<td><%=t.getEmpid()%></td>
							<td><%=t.getJobType()%></td>
							<td><%=t.getJobLevel()%></td>
							<td><%=t.getBaseSalary()%></td>
							<td><%=t.getDepartment()%></td>
							<td><button onClick="openEditWindow(<%=t.getId()%>,<%=t.getEmpid()%>)" class="tabSub">修改</button>&nbsp;&nbsp;&nbsp;
								<button onClick="deleteJob(<%=t.getId()%>)" class="tabSub">删除</button></td>
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