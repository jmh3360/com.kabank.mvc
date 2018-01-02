/**
 * 
 */
function init() {
	var arr=['burgerking', 'kakao','bitcamp','sktelecom','lotto'];
	for(var i =0;i<arr.length; i++) {
		document.querySelector('#'+arr[i]).addEventListener('click',
				function(e) {
					location.href = "../"+this.id+"/main.jsp";
				},false);
	}
	document.querySelector('#bitcamp_attendance_btn').submit;
}

function bitCampAttendance() {
	location.href = "result.jsp";
}
window.addEventListener("load",init,false);




/*
window.onload=clickMe; //로딩이 될 때 실행을 하라는 뜻
function clickMe() {
	document.querySelector('#burgerking') 
	.onclick = goBurgerking;
	
	document.querySelector('#kakao') 
	.onclick = goKakao;
	
	document.querySelector('#lotto') 
	.onclick = goLotto;
	
	document.querySelector('#sktelecom') 
	.onclick = goSkelecom;
	
	document.querySelector('#bitcamp') 
	.onclick = goBitcamp;
	
	
	
}

function goBurgerking() {
	location.href = "../burgerking/main.jsp";
}
function goKakao() {
	location.href = "../kakao/main.jsp";
}
function goBitcamp() {
	location.href = "../bitcamp/main.jsp";
}
function goLotto() {
	location.href = "../lotto/main.jsp";
}
function goSkelecom() {
	location.href = "../sktelecom/main.jsp";
}

*/