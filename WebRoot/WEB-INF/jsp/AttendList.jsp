<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="demo.beans.Attend"%>
<%@ page import="demo.dao.AttendDAO"%>
<%@ page import="demo.service.AttendService"%>
<%@ page import="demo.service.DateFactory"%>
<%!AttendService attendService = new AttendService();%>
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
<title>AttendList</title>
<link href="<%=basePath%>resources/css/all.css" rel="stylesheet"
	type="text/css" />
</head>

<script type="text/javascript">
    
    function openEditWindow(id,empid){
    	var attendDate=prompt("出勤日期","2017-01-01");
    	var overtime=prompt("加班天数","");
    	var dayoff=prompt("请假天数","");
    	if(attendDate != null && attendDate != "" && overtime != null && overtime != "" && dayoff != null && dayoff != ""){
    		
    		window.location.href='editAttend?id=' + id + '&empid=' + empid + '&attendDate=' + attendDate + '&overtime=' + overtime + '&dayoff=' + dayoff;
    	}else{
    		alert("属性不能为空！");
    	}
    	
    }
    
    function deleteAttend(id){
    	window.location.href='deleteAttend?id=' + id;
    }

	function test(){
		alert("test");
	}
</script>
<body style="background: #e1e9eb;">

	<div class="right">
		<div class="current">
			当前位置：<a href="/SimpleEmployeeSystem/index.jsp" style="color:#6E6E6E;">主页</a>
			&gt;<a href="/SimpleEmployeeSystem/getAttendList" style="color:#6E6E6E;">AttendList</a>
		</div>
		<div class="rightCont">
			<p class="g_title fix">
				刷新 <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
					class="btn03" href="#">删 除</a>
			</p>
			<table class="tab1">
				<tbody>
					<form action="addAttend" id="add" method="get">
						编号：<input type="text" name="id" value="" />
						 工号：<input type="text" name="empid" value="" />
						 出勤日期：<input type="text" name="attendDate" value="2017-01-01" />
						加班天数：<input type="text" name="overtime" value="" />
						请假天数：<input type="text" name="dayoff" value="" />
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
							<th>出勤日期(attendDate)</th>
							<th>加班天数(overtime)</th>
							<th>请假天数(dayoff)</th>
							<th>操作</th>
						</tr>
						<%
							List<Attend> list = (List<Attend>) session.getAttribute("list");
						%>
						<%
							for (int i = 0; i < list.size(); i++) {
								Attend t = list.get(i);
						%>
						<tr
							<%if (i % 2 == 1) {
					out.print(" style=\"background-color:#ECF6EE;\"");
				}%>>
							<td><input type="checkbox" /></td>
							<td><%=t.getId()%></td>
							<td><%=t.getEmpid()%></td>
							<td><%=DateFactory.getDateToString(t.getAttendDate())%></td>
							<td><%=t.getOvertime()%></td>
							<td><%=t.getDayoff()%></td>
							<td><button onClick="openEditWindow(<%=t.getId()%>,<%=t.getEmpid()%>)" class="tabSub">修改</button>&nbsp;&nbsp;&nbsp;
								<button onClick="deleteAttend(<%=t.getId()%>)" class="tabSub">删除</button></td>
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