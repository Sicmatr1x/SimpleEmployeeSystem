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
<title>Cayman theme</title>
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
		<a href="https://github.com/pages-themes/cayman/tarball/master" class="btn">Download .tar.gz</a>
		<a href="https://github.com/pages-themes/cayman/tarball/master" class="btn">Download .tar.gz</a>
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
			<a href="https://pages-themes.github.io/cayman/#header-1"></a>Header
			1
		</h1>

		<p>This is a normal paragraph following a header. GitHub is a code
			hosting platform for version control and collaboration. It lets you
			and others work together on projects from anywhere.</p>

		<h2 id="header-2">
			<a href="https://pages-themes.github.io/cayman/#header-2"></a>Header
			2
		</h2>

		<blockquote>
			<p>This is a blockquote following a header.</p>

			<p>When something is important enough, you do it even if the odds
				are not in your favor.</p>
		</blockquote>

		


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