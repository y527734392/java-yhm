<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
	<script type="text/javascript">
		$(function(){
			$.post("${pageContext.request.contextPath}/ProductServlet",{method:"findAllCategory"},function(data){
				if(data!=""){
					$(data).each(function(i,m){
						//alert(m['cname']);
						var temp="<li><a href='${pageContext.request.contextPath}/ProductServlet?method=allProductByCid&pageNumber=1&cid="+m['cid']+"'>"+m['cname']+"<span class='sr-only'>(current)</span></a></li>";
							$("#ulid").append(temp);
					})
				}
			},"json");	
		});
		
		
		
		
	</script>
<!--
         	描述：菜单栏
         -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="${pageContext.request.contextPath}/img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<li><a href="${pageContext.request.contextPath}/login.jsp">登录</a></li>
			<li><a href="${pageContext.request.contextPath}/register.jsp">注册</a></li>
			<li><a href="${pageContext.request.contextPath}/cart.jsp">购物车</a></li>
		</ol>
	</div>
</div>
							<!--
					         	描述：导航条
					         -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">首页</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<!-- 
						-------工具栏-------
					 -->
				<ul class="nav navbar-nav" id="ulid">
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>

			</div>
		</div>
	</nav>
</div>