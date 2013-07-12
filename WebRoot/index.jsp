<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="include/taglibs.jsp" %>
<!DOCTYPE html>
<head>
  <%@include file="include/layout.jsp"%>
</head>

<body>
<div class="container-fluid">
    <div style="clear:both;height:20px">&nbsp;</div>
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						 <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a> <a href="#" class="brand">RainSoft</a>
						<div class="nav-collapse collapse navbar-responsive-collapse">
							<ul class="nav">
								<li class="active">
									<a href="javascript:void(0)">Home</a>
								</li>
								<li>
									<a href="web/test/">例子</a>
								</li>
								<li>
									<a href="javascript:void(0)">Link</a>
								</li>
								<li class="dropdown">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0)">Dropdown<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="javascript:void(0)">Action</a>
										</li>
										<li>
											<a href="javascript:void(0)">Another action</a>
										</li>
										<li>
											<a href="javascript:void(0)">Something else here</a>
										</li>
										<li class="divider">
										</li>
										<li class="nav-header">
											Nav header
										</li>
										<li>
											<a href="javascript:void(0)">Separated link</a>
										</li>
										<li>
											<a href="javascript:void(0)">One more separated link</a>
										</li>
									</ul>
								</li>
							</ul>
							<ul class="nav pull-right">
								<li>
									<a href="javascript:void(0)">Link</a>
								</li>
								<li class="divider-vertical">
								</li>
								<li class="dropdown">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0)">Dropdown<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="javascript:void(0)">Action</a>
										</li>
										<li>
											<a href="javascript:void(0)">Another action</a>
										</li>
										<li>
											<a href="javascript:void(0)">Something else here</a>
										</li>
										<li class="divider">
										</li>
										<li>
											<a href="javascript:void(0)">Separated link</a>
										</li>
									</ul>
								</li>
							</ul>
						</div>
						
					</div>
				</div>
				
			</div>
			<div class="hero-unit">
				<h1>
					Hello, hero!
				</h1>
				<p>
					该小型框架由Mr.Horse定制 and 由Mr.zhang在的要求完成的。只要你敢用！
				</p>
				<p>
					<a class="btn btn-primary btn-large" href="javascript:void(0)">框架文档</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span4">
			<h2>
				SpringMVC
			</h2>
			<p>
				用它可以记跳转Action更Easy!
			</p>
			<p>
				<a class="btn" href="javascript:void(0)">查看详细 »</a>
			</p>
		</div>
		<div class="span4">
			<h2>
				Ibatis
			</h2>
			<p>
				jdbc的性能，配置分明的文件，是雨人人Java工程师都知道咋用的！
			</p>
			<p>
				<a class="btn" href="javascript:void(0)">查看详细 »</a>
			</p>
		</div>
		<div class="span4">
			<h2>
				ModelSQL
			</h2>
			<p>
				与Ibatis性能不相上下的另一个小型数据查询工具，想知道咋用的？
			</p>
			<p>
				<a class="btn" href="javascript:void(0)">查看详细 »</a>
			</p>
		</div>
	</div>
</div>
</body>
</html>
