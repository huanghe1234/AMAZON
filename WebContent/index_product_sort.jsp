<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
<div class="p_category">
	<h2>商品分类</h2>

	<!-- Map<Category, List<Category>> -->
	<c:set var="map" value="${sessionScope.cMap }"></c:set>

	<c:forEach items="${map }" var="c">
		<dl>
			<dt>
				<a href="doPage?cate=parent&hpcId=${c.key.HPC_ID  }">${c.key.HPC_NAME}</a>
			</dt>
			<c:forEach items="${c.value}" var="category">
				<dd>
					<a href="doPage?cate=child&hpcId=${category.HPC_ID }">${category.HPC_NAME }</a>
				</dd>
			</c:forEach>
		</dl>
	</c:forEach>

</div>

<!-- <script type="text/javascript">
	$(function(){
		$.ajax({
			type:"post",
			url:"doQuery",
		})
	})
	
</script> -->