<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jQuery Ajax�޼ҵ� - load() ����ó��</title>
<style type="text/css">
	#result {
	width : 200px;
	height:200px;
	border:5px double #6699FF;
	}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script>
	$(document).ready(function(){
		//[���] ��ư�� Ŭ���ϸ� xhrTest3.txt.rk <div id="result"> ������Ʈ�� �ε�
		$("#b1").click(function(){
			$("#result").load("xhrTest3.txt", function(response,stu,xhr){
				if(stu=="success")//���� ��û�� ���� ��
				alert("�ε� ����!!");//�޽��� ���� ǥ��
				if(stu=="error")//���� ��û ���� ��
				alert("����: " + xhr.status+": " + xhr.stu);
			});
		});
	});
</script>
</head>
<body>
	<button id="b1">���</button>
	<div id="result"></div>
</body>
</html>