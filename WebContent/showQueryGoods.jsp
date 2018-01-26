<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>

<ul class="product2">
				<c:if test="${requestScope.pageModel.totalPage==0}">
					<h4>找不到您搜索的商品！</h4>
				</c:if>
				<c:set value="${requestScope.pList}" var="products"></c:set>
				<c:forEach items="${products}" var="p">
					<li>
						<dl>
							<dt>
								<a href="doView?pId=${p.hp_id }" target="_self">
								<img src="${p.hp_file_name }" /></a>
							</dt>
							<dd class="title">
								<a href="doView?pId=${p.hp_id}" target="_self">${p.hp_name }</a>
							</dd>
							<dd class="price">${p.hp_price}</dd>
						</dl>
					</li>

				</c:forEach>
	</ul>
	