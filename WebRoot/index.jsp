<!DOCTYPE html>
<!-- saved from url=(0038)https://pages-themes.github.io/cayman/ -->
<html lang="en-us">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<title>SimpleEmployeeSystem</title>
<meta name="description"
	content="Cayman is a clean, responsive theme for GitHub Pages.">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="theme-color" content="#157878">
<link href="<%=basePath%>resources/css/css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="<%=basePath%>resources/css/style.css">
</head>
<body>
	<section class="page-header">
		<h1 class="project-name">SimpleEmployeeSystem</h1>
		<h2 class="project-tagline">This is a simple employee manage system powered by SSM framework.</h2>

		<a href="getEmployeeList" class="btn">EmployeeList</a>
		<a href="getAttendList" class="btn">AttendList</a>
		<a href="getBenefitList" class="btn">BenefitList</a>
		<a href="getJobList" class="btn">JobList</a>
		<a href="getSalaryList" class="btn">SalaryList</a>
	</section>

	<section class="main-content">
		<p>
			Text can be <strong>bold</strong>, <em>italic</em>, or
			<del>strikethrough</del>
			.
		</p>

		<p>
			<a href="https://pages-themes.github.io/cayman/another-page">Link
				to another page</a>.
		</p>

		<p>There should be whitespace between paragraphs.</p>

		<p>There should be whitespace between paragraphs. We recommend
			including a README, or a file with information about your project.</p>

		<h1 id="header-1">
			工资管理系统
		</h1>

		<h2 id="header-2">
			1.系统功能的基本要求
		</h2>
		
		<blockquote>
			<p>员工每个工种基本工资的设定；</p>
			<p>加班津贴管理，根据加班时间和类型给予不同的加班津贴；</p>
			<p>按照不同工种的基本工资情况、员工的考勤情况产生员工的每月的月工资；</p>
			<p>员工年终奖金的生成，员工的年终奖金计算公式＝（员工本年度的工资总和＋津贴的总和）/12；</p>
			<p>能够查询单个员工的工资情况、每个部门的工资情况、按月的工资统计；</p>
		</blockquote>

		<h2 id="header-2">
			2.数据库要求：在数据库中至少应该包含下列数据表
		</h2>
		
		<blockquote>
			<p>1.employee员工基本信息表；</p>
			<p>2.attend员工考勤情况表：出勤时间、出勤类型;</p>
			<p>3.benefit员工津贴信息表，反映员工的加班时间，加班类别、加班天数、津贴情况等;</p>
			<p>4.job员工工种情况表，反映员工的工种、等级，基本工资等信息；</p>
			<p>5.salary员工月工资表;</p>
		</blockquote>
		
		<h3 id="header-3">
			1.employee员工基本信息表
		</h3>
		
		<div class="language-sql highlighter-rouge"><pre class="highlight">
			<code>
<span class="kd">CREATE TABLE</span> employee(
id <span class="kd">int</span>,
name <span class="kd">VARCHAR(14)</span>,
age <span class="kd">int</span>,
sex <span class="kd">VARCHAR(1)</span>,
<span class="kd">PRIMARY KEY</span>(id)
);
			</code></pre>
		</div>
		
		<h3 id="header-3">
			2.attend员工考勤情况表
		</h3>
		
		<div class="language-sql highlighter-rouge"><pre class="highlight">
			<code>
<span class="kd">CREATE TABLE</span> attend(
id <span class="kd">int</span>,
empid <span class="kd">int</span>,
attendDATE <span class="kd">DATE</span>,
attendType <span class="kd">int</span>,
<span class="kd">PRIMARY KEY</span>(id),
key empid (empid),
<span class="kd">foreign key</span> (empid) <span class="kd">references</span> employee(id)
);
            </code></pre>
		</div>
		
		<h3 id="header-3">
			3.benefit员工津贴信息表
		</h3>

        <div class="language-sql highlighter-rouge"><pre class="highlight">
			<code>
<span class="kd">CREATE TABLE</span> benefit(
id <span class="kd">int</span>,
empid <span class="kd">int</span>,
mounth <span class="kd">DATE</span>,
overtime <span class="kd">int</span>,
<span class="kd">PRIMARY KEY</span>(id),
key empid (empid),
<span class="kd">foreign key</span> (empid) <span class="kd">references</span> employee(id)
);
            </code></pre>
		</div>
		
		<h3 id="header-3">
			4.job员工工种情况表
		</h3>

        <div class="language-sql highlighter-rouge"><pre class="highlight">
			<code>
<span class="kd">CREATE TABLE</span> job(
id <span class="kd">int</span>,
empid <span class="kd">int</span>,
jobType VARCHAR(14),
jobLevel <span class="kd">int</span>,
baseSalary <span class="kd">int</span>,
department VARCHAR(14),
<span class="kd">PRIMARY KEY</span>(id),
key empid (empid),
<span class="kd">foreign key</span> (empid) <span class="kd">references</span> employee(id)
);
            </code></pre>
		</div>
		
		<h3 id="header-3">
			5.salary员工月工资表
		</h3>

        <div class="language-sql highlighter-rouge"><pre class="highlight">
			<code>
<span class="kd">CREATE TABLE</span> salary(
id <span class="kd">int</span>,
empid <span class="kd">int</span>,
mounth <span class="kd">DATE</span>,
salary <span class="kd">int</span>,
<span class="kd">PRIMARY KEY</span>(id),
key empid (empid),
<span class="kd">foreign key</span> (empid) <span class="kd">references</span> employee(id)
);
            </code></pre>
		</div>


		<footer class="site-footer">

			<span class="site-footer-owner"><a
				href="https://github.com/pages-themes/cayman">cayman</a> is
				maintained by <a href="https://github.com/pages-themes">pages-themes</a>.</span>

			<span class="site-footer-credits">This page was generated by <a
				href="https://pages.github.com/">GitHub Pages</a>.
			</span>
		</footer>
	</section>




</body>
</html>