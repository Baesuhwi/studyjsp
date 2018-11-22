var status = true;

$(document).ready(function() {
	// [회원가입]버튼 클릭시
	// id 속성값이 main_auth인 영역에 로드
	$("main_auth").load("registerForm.jsp");
});

// [로그인] 버튼 클릭시
// 입력한 아이디와 비밀번호를 갖고 loginPro.jsp 실행
$("#login").click(function() {
	checkIt();// 입력폼에 입력한 상황 체크
	if (status) {
		// 입력된 사용자의 아이디와 비밀번호를 얻어냄
		var query = {
			id : $("#id").val(),
			passwd : $("#passwd").val()
		};
		$.ajax({
			type : "POST",
			url : "loginPro.jsp",
			data : query,
			success : function(data) {
				if (data == 1) { // 로그인 성공시
					$("#main_auth").load("loginForm.jsp");
				} else if (data == 0) {// 비밀번호 틀렸을시
					alert("비밀번호가 맞지 않습니다.");
					$("#passwd").val("");
					$("#passwd").focus();
				} else if (data == -1) {// 아이디 틀림
					alert("아이디가 맞지 않습니다.");
					$("#id").val("");
					$("#passwd").val("");
					$("#id").focus();

				}
			}
		});
	}
});










