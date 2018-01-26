<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
<style type="text/css">
.news-list ul li {
	
}
</style>
<div class="newsList">
	<h2>新闻动态</h2>
	<ul>
		<c:forEach items="${news}" var="n" end="10">
			<li><a href="doOneNews?nid=${n.hn_id }">${n.hn_title }&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;</a></li>
		</c:forEach>
	</ul>
	
	
</div>
<!-- <script type="text/javascript">
	$(function(){
		$.ajax({
			type:"post",
			url:"doNews",
			dateType:"html",
			success:function(msg){
				$(".newsList").html(msg)
			}
		});
	});
</script>
 -->