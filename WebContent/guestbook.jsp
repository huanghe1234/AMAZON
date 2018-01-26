<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 留言</title>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/comment.js"></script>
</head>
<body>
<%@ include file="index_top.jsp"  %>
<div id="position" class="wrap">
	您现在的位置：<a href="${pageContext.request.contextPath}/doQuery">亚马逊</a> &gt; 在线留言
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<%@ include file="index_product_sort.jsp" %>
	</div>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
				<c:forEach items="${requestScope.allComments }" var="comments" >
				
				<li>
					<dl>
						<dt>标题：${comments.hc_title }</dt>
						<dd>内容：${comments.hc_content }</dd>
						<dd class="author"><span>作者：${comments.hc_nick_name }</span></dd>
						<dd>评论时间：${comments.hc_create_time }</dd>
						<dd><a href="javascript:myReply(${comments.hc_id })">回复</a>：${comments.hc_reply }</dd>
						<dd>回复时间：${comments.hc_reply_time }</dd>
					</dl>
				</li>
				<hr/>
				</c:forEach>
			</ul>
			<div style="float:right">
					<a href="doShowComment?page=${pager.prevPage}">上一页</a>
						<c:forEach items="${pager.groupList}" var="i">
							<c:if test="${i==pager.currentPage}">
								${i}
							</c:if>
							<c:if test="${i!=pager.currentPage}">
								<a href="doShowComment?page=${i}">${i}</a>
							</c:if>
						</c:forEach>
					<a href="doShowComment?page=${pager.nextPage}">下一页</a>						
			</div>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					
				</ul>
				
			</div>
			<div id="reply-box">
				<form action="addComment" method="post" onsubmit="return commentCheck()">
					<% %>
					<table>
						<tr>
							<td class="field">昵称：</td>
							<td><input class="text" type="text" name="guestName" /></td>
						</tr>
						<tr>
							<td class="field">留言标题：</td>
							<td><input class="text" type="text" name="guestTitle" /></td>
						</tr>
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="guestContent"></textarea></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><label class="ui-blue"><input type="button" name="submit" value="提交留言" onclick="mySendComment()"/></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2016 上海海文 All Rights Reserved. 京ICP证1000001号
</div>
<script type="text/javascript">
	function mySendComment(){
		//发送一个ajax请求给后台
		$.ajax({
			type:"post",
			url:"addComment",
			data:$("form").serialize(), 
			success:function (msg){
				if(msg==1){
					alert("留言成功");
					
					
				}else if(msg==0){
					alert("留言为空");
				}
			}
		});
	}
	function myReply(comId){
		//发送一个ajax请求给后台
		$.ajax({
			type:"post",
			url:"doReply",
			success:function (msg){
				if(msg==1){
					alert("回复成功");
					
				}else if(msg==0){
					alert("回复失败");
				}
			}
		});
	}
	
	
</script>
	


</body>
</html>
