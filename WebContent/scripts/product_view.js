function addToCart(pid) {
	var sk = $("#sk").val();
	var stock=$("#stock").html()
	var count=$("#count").val()
	if(parseInt(sk) <= parseInt(0)){
		alert("已经无货了!");
	}else {
		if(parseInt(count)>parseInt(stock)){
			alert("您选择的数量超过库存!");
		}else{
			$.ajax({
				url:"doAddCart?pid="+ pid+"&count="+ count,// 请求的servlet地址
				type : "POST",// 请求方式
				dataType : "text",// 设置返回数据类型
				success : function(total) {
					if(total==1){
						alert("成功添加到购物车!");
					}else{
						alert("添加到购物车失败!");
					}
				},// 响应成功后执行的回调方法data响应文本
				complete : function(XMLHttpRequest, statusText) {
				
				},// 响应完成后执行的回调方法
				error : function(XMLHttpRequest, statusText) {
				alert("无法添加到购物车!");
				}// 响应失败后执行的回调方法
			})
		}
	}
}

function goingToBuy(pid) {
	var sk = $("#sk").val();
	var stock=$("#stock").html();
	var count=$("#count").val();
	if(parseInt(sk) <= parseInt(0)){
		alert("已经无货了!");
	}else{
		if(parseInt(count)>parseInt(stock)){
			alert("您选择的数量超过库存!");
		}else{
			window.location.href="goingToBuy?pid="+pid+"&count="+$("#count").val();
		}
	}
}

//-按钮事件
function minus(){

	if($("#count").val()==1){
		$("#count").val(1)
	}else if($("#count").val()>=2){
		var old=$("#count").val()
		$("#count").val(parseInt(old)-1)
	}else if($("#count").val()<=0){
		alert("选择不能为负数");
		$("#count").val(1);
	}
}

//+按钮事件
function add(){
	var stock=$("#stock").html()
	var old=$("#count").val()
	if(parseInt(old)<parseInt(stock)){
		$("#count").val(parseInt(old)+1)
	}else{
		alert("您选择的数量超过库存!")
	}
	
}



function checkStock(){
	var stock=$("#stock").html();
	var old=$("#count").val();
	var code = /^[0-9]{1,5}$/;
	if(old==""||code.test(old)==false){
		alert("输入的什么鬼??")
		$("#count").val(1);
	}else if(parseInt(old)<=0){
		alert("数量不能为负数!");
		$("#count").val(1);
	}else if(parseInt(old)>parseInt(stock)){
		alert("您选择的数量超过库存!");
	}
}



function remaind() {
	alert("请先登录亚马逊！")
	window.location.href="login.jsp"
}




