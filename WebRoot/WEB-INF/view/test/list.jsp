<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/include/taglibs.jsp" %>
<!DOCTYPE html>
  <head>
    
    <title>例子列表页面</title>
     <%@include file="/include/layout.jsp" %>
    </head>
  
  <body>
    
    <div class="container-fluid">
    <div style="clear:both;height:20px">&nbsp;</div>
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						 <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a> <a href="${ctx}" class="brand">RainSoft</a>
						<div class="nav-collapse collapse navbar-responsive-collapse">
							<ul class="nav">
								<li class="active">
									<a href="javascript:void(0)">Home</a>
								</li>
								<li>
									<a href="javascript:void(0)">例子</a>
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
			    <form class="form-search" style="float:right">
				    <input class="input-medium search-query" type="text" /> <button type="submit" class="btn">查询</button>
			    </form>
			<table class="table">
				<thead>
					<tr>
						<th>
							&nbsp;
						</th>
						<th>
							姓名
						</th>
						<th>
							性别
						</th>
						<th>
							出生日期
						</th>
					</tr>
				</thead>
				<tbody>
				    <c:forEach items="${result}" var="t" varStatus="tt">
				         <tr class='${tt.index%2==0?"info":"success" }'>
							<td>
								${tt.index}
							</td>
							<td>
								${t.userName }
							</td>
							<td>
								${t.sex}
							</td>
							<td>
								${t.birth }
							</td>
					     </tr>
				    </c:forEach>
					
				</tbody>
			</table>
			<div class="pagination" style="float:right">
				<ul>
					<li>
						<a href="javascript:void(0)">Prev</a>
					</li>
					<li>
						<a href="javascript:void(0)">1</a>
					</li>
					<li>
						<a href="javascript:void(0)">2</a>
					</li>
					<li>
						<a href="javascript:void(0)">3</a>
					</li>
					<li>
						<a href="javascript:void(0)">4</a>
					</li>
					<li>
						<a href="javascript:void(0)">5</a>
					</li>
					<li>
						<a href="javascript:void(0)">Next</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
    
  </body>
</html>
