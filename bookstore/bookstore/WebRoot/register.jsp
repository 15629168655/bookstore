<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>网上书店</title>
	<script type="text/javascript" src="dwr/engine.js"></script>
	<script type="text/javascript" src="dwr/util.js"></script>
	<script type="text/javascript" src="dwr/interface/UserDAOAjax.js"></script>
	<script type="text/javascript">
		function show(boolean) {
			if(boolean){
				alert("用户已经存在！");
			}
		}
		function validate() {
			var name=form1.name.value;
			if(name==""){
				alert("用户名不能为空！");
				return;
			}
			UserDAOAjax.exitUser(name,show);
		}
	</script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<div class="list_box">
				<div class="list_bk">
					<s:action name="browserCatalog" executeResult="true"></s:action>
				</div>
			</div>
		</div>
		<div class="right">
			<div class="right_box">
				<div class="info_bk1">
					<div align="center">
						<form action="register.action" method="post" name="form1">
							用户注册<br>
							用户名：<input type="text" id="name" name="user.username" onblur="validate()" size="20"><br>
							密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="user.password" size="20"><br>
							性&nbsp;&nbsp;&nbsp;&nbsp;别：<input type="text" name="user.sex" size="20"><br>
							年&nbsp;&nbsp;&nbsp;&nbsp;龄：<input type="text" name="user.age" size="20"><br>
							<input type="submit" value="注册">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>