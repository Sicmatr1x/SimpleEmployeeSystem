<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="demo.beans.Benefit"%>
<%@ page import="demo.dao.BenefitDAO"%>
<%@ page import="demo.service.BenefitService"%>
<%@ page import="demo.service.DateFactory"%>
<%!BenefitService benefitService = new BenefitService();%>
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
<title>BenefitList</title>
<link href="<%=basePath%>resources/css/all.css" rel="stylesheet"
	type="text/css" />
</head>

<script type="text/javascript">
    
    function openEditWindow(id,empid){
    	var mounth=prompt("该月加班记录","2017-01-01");
    	var bene=prompt("该月津贴","");
    	if(mounth != null && mounth != "" && bene != null && bene != ""){
    		
    		window.location.href='editBenefit?id=' + id + '&empid=' + empid+ '&mounth=' + mounth + '&bene=' + bene;
    	}else{
    		alert("属性不能为空！");
    	}
    	
    }
    
    function deleteBenefit(id){
    	window.location.href='deleteBenefit?id=' + id;
    }

	function test(){
		alert("test");
	}
</script>
<body style="background: #e1e9eb;">

	<div class="right">
		<div class="current">
			当前位置：<a href="/SimpleEmployeeSystem/index.jsp" style="color:#6E6E6E;">主页</a>
			&gt;<a href="/SimpleEmployeeSystem/getBenefitList" style="color:#6E6E6E;">BenefitList
		</div>
		<div class="rightCont">
			<p class="g_title fix">
				刷新 <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
					class="btn03" href="#">删 除</a>
			</p>
			<table class="tab1">
				<tbody>
					<form action="addBenefit" id="add" method="get">
						编号：<input type="text" name="id" value="" />
						 工号：<input type="text" name="empid" value="" />
						该月加班记录：<input type="text" name="mounth" value="2017-01-01" />
						该月津贴：<input type="text" name="bene" value="" />
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
							<th>该月加班记录(mounth)</th>
							<th>该月津贴(bene)</th>
							<th>操作</th>
						</tr>
						<%
							List<Benefit> list = (List<Benefit>) session.getAttribute("list");
						%>
						<%
							for (int i = 0; i < list.size(); i++) {
								Benefit t = list.get(i);
						%>
						<tr
							<%if (i % 2 == 1) {
					out.print(" style=\"background-color:#ECF6EE;\"");
				}%>>
							<td><input type="checkbox" /></td>
							<td><%=t.getId()%></td>
							<td><%=t.getEmpid()%></td>
							<td><%=DateFactory.getDateToString(t.getMounth())%></td>
							<td><%=t.getBene()%></td>
							<td><button onClick="openEditWindow(<%=t.getId()%>,<%=t.getEmpid()%>)" class="tabSub">修改</button>&nbsp;&nbsp;&nbsp;
								<button onClick="deleteBenefit(<%=t.getId()%>)" class="tabSub">删除</button></td>
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