<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>员工添加</title>
<meta name="keywords"
	content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
	<article class="page-container"> <!-- 添加员工，跳转到adduser.do -->
	<form class="form form-horizontal" id="form-admin-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>用户id：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" onfocus=this.blur() value="<%=request.getParameter("id") %>" placeholder=""
					id="adminId" name="adminId">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>用户姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="<%=request.getParameter("name") %>" placeholder=""
					id="adminName" name="adminName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>用户密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="password" class="input-text" autocomplete="off"
					value="" placeholder="密码" id="password" name="password">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>所在部门：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				机构：
				<select name="branch" id="branch" onchange="branch_dept()">
					<c:forEach items="${branchList}" var="list">
						<c:if test="${list.tBranchinfoId==branchId}">
							<option value="${list.tBranchinfoId}" selected>
									${list.tBranchinfoName}
							</option>
						</c:if>
						<c:if test="${list.tBranchinfoId!=branchId}">
							<option value="${list.tBranchinfoId}">
									${list.tBranchinfoName}
							</option>
						</c:if>
					</c:forEach>
					<c:if test="${departid==0}">
						<option value="0" selected>
							无机构所属
						</option>
					</c:if>
				</select>
				部门：
				<select name="depart" id="depart">
					<c:forEach items="${departList}" var="list">
						<c:if test="${list.tDepartinfoId==departid}">
							<option value="${list.tDepartinfoId}" selected>
									${list.tDepartinfoName}
							</option>
						</c:if>
						<c:if test="${list.tDepartinfoId!=departid}">
							<option value="${list.tDepartinfoId}">
									${list.tDepartinfoName}
							</option>
						</c:if>
					</c:forEach>
					<c:if test="${departid==0}">
						<option value="0" selected>
							无部门
						</option>
					</c:if>
				</select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>性别：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<select name="sex" id="sex">
					<c:if test="${gender=='男'}">
						<option value="男" selected>
								男
						</option>
						<option value="女">
							女
						</option>
					</c:if>
					<c:if test="${gender=='女'}">
						<option value="男">
							男
						</option>
						<option value="女" selected>
							女
						</option>
					</c:if>
				</select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>用户角色：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<select name="role" id="role">
					<c:if test="${roleid==1}">
						<option value="1" selected>
							系统管理员
						</option>
						<option value="2">
							普通用户
						</option>
					</c:if>
					<c:if test="${roleid==2}">
						<option value="1" >
							系统管理员
						</option>
						<option value="2" selected>
							普通用户
						</option>
					</c:if>
				</select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>用户状态：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<select name="state" id="state">
					<c:if test="${stateid==1}">
						<option value="1" selected>
							正常状态
						</option>
						<option value="0">
							被屏蔽
						</option>
					</c:if>
					<c:if test="${stateid==0}">
						<option value="1">
							正常状态
						</option>
						<option value="0" selected>
							被屏蔽
						</option>
					</c:if>
				</select>
			</div>
		</div>
	</form>
		<br><br>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<button class="btn btn-success radius" id="admin-role-save1"
						name="admin-role-save">
					<i class="icon-ok"></i> 确定
				</button>
			</div>
		</div>
	</article>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript">
		$('#admin-role-save1').on('click', function() {
			var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
			//$("#lcform").submit();
			var depart = $('#depart').val();
			if(depart==""||depart==null){
				depart=0;
			}
			var pwd = $('#password').val();
			if (pwd==""||pwd==null){
				alert("密码不能为空");
				return;
			}
			$.ajax({
				type : 'post', //post方式
				url : "userupdate.do", //发送的接收地址。
				data : {
					"tUserinfoId" : $('#adminId').val(),
					"tUserinfoName" : $('#adminName').val(),
					"tUserinfoPassword" : $('#password').val(),
					"tDepartinfoId" : depart,
					"tUserinfoGender" : $('#sex').val(),
					"tRoleinfoId" : $('#role').val(),
					"tUserstateId" : $('#state').val()
				},
				success : function(data) {
					var obj = JSON.parse(data);
					if(obj.number==200){
						alert("修改成功")
						parent.location.reload();//父页面刷新

						var index = parent.layer.getFrameIndex(window.name);
						parent.layer.close(index);
					}else{
						alert("更新失败");
					}


				},
				error : function() {

				},

			});

		});
		function branch_dept() {

			$.ajax({
				type : 'post', //post方式
				url : "depart.do", //发送的接收地址。
				data : {
					"tBranchinfoId" : $('#branch').val()
				},
				success : function(data) {
					var arr = JSON.parse(data)
					$("#depart").empty()
					for ( n in arr) {
						var obj=arr[n];
						var opt = document.createElement("option");
						opt.setAttribute("value",obj.tDepartinfoId);
						opt.innerText=obj.tDepartinfoName;
						document.getElementById("depart").appendChild(opt);

					}
				}

			});
		}
	</script>

</body>
</html>