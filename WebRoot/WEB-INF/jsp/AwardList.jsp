<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="demo.beans.Award"%>
<%@ page import="demo.dao.AwardDAO"%>
<%@ page import="demo.service.AwardService"%>
<%@ page import="demo.service.DateFactory"%>
<%!AwardService attendService = new AwardService();%>
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
<title>AwardList</title>
<link href="<%=basePath%>resources/css/all.css" rel="stylesheet"
	type="text/css" />
</head>

<script type="text/javascript">

	function test(){
		alert("test");
	}
</script>
<body style="background: #e1e9eb;">

	<div class="right">
		<div class="current">
			当前位置：<a href="/SimpleEmployeeSystem/index.jsp" style="color:#6E6E6E;">主页</a>&gt;
			<a href="/SimpleEmployeeSystem/getSalaryList" style="color:#6E6E6E;">SalaryList</a>&gt;
			<a href="/SimpleEmployeeSystem/getAwardList" style="color:#6E6E6E;">AwardList</a>
		</div>
		<div class="rightCont">
			<p class="g_title fix">
				刷新 <a class="" href="#"></a>&nbsp;&nbsp;&nbsp;&nbsp; <a
					class="" href="#"></a>
			</p>
			
			<div class="zixun fix">
				<table class="tab2" width="100%">
					<tbody>
						<tr>
							<th><input type="checkbox" id="all" onclick="" /></th>
							<th>工号(Empid)</th>
							<th>年份(Year)</th>
							<th>全年总津贴(AllBenefit)</th>
							<th>全年总工资(AllSalary)</th>
							<th>年终奖金(Award)</th>
						</tr>
						<%
							List<Award> list = (List<Award>) session.getAttribute("list");
						%>
						<%
							for (int i = 0; i < list.size(); i++) {
								Award t = list.get(i);
						%>
						<tr
							<%if (i % 2 == 1) {
					out.print(" style=\"background-color:#ECF6EE;\"");
				}%>>
							<td><input type="checkbox" /></td>
							<td><%=t.getEmpid()%></td>
							<td><%=DateFactory.getDateToString(t.getYear())%></td>
							<td><%=t.getAllBenefit()%></td>
							<td><%=t.getAllSalary()%></td>
							<td><%=t.getAward()%></td>
						</tr>
						<%
							}
						%>

					</tbody>

				</table>
				<div class='page fix'>
					共 <b><%=list.size()%></b> 条
				</div>
			</div>
		</div>
	</div>

</body>
</html>