<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>网上购书系统</title>
	<link href="css/bookstore.css" rel="stylesheet" type="text/css">
</head>
<body>
	<ul class="point02">
		<li>
			<strong>图书分类</strong>
		</li>
		<s:iterator value="#request['catalogs']" id="catalog">
			<li>
				<a href="browseBookPaging.action?catalogid=<s:property value="#catalog.catalogid"/>" target="_self">
					<s:property value="#catalog.catalogname"/>
				</a>
			</li>
		</s:iterator>
	</ul>
</body>
</html>