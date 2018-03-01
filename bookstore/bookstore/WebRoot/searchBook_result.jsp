<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>网上书店</title>
	<link href="css/bookstore.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<div class="list_box">
				<div class="list_bk">
					<s:action name="browseCatalog" executeResult="true"></s:action>
				</div>
			</div>
		</div>
		<div class="right">
			<div class="right_box">
				<s:set name="books" value="#request.books"></s:set>
				<s:if test="#books.size!=0">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="blue"><h3>所有符合条件的图书</h3></font><br>
				<s:iterator value="#books" id="book">
					<table width="600" border="0">
						<tr>
							<td width="200" align="center">
								<img src="/bookstore/picture/<s:property value="#book.picture"/>" width="100">
							</td>
							<td valign="top" width="400">
								<table>
									<tr>
										<td>
										书名：<s:property value="#book.bookname"/><br>
										</td>
									</tr>
									<tr>
										<td>
										价格：<s:property value="#book.price"/>元
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<img src="/bookstore/picture/buy.gif">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</s:iterator>
			</s:if>	
			<s:else>
				对不起，没有合适的图书！
			</s:else>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>