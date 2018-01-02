/**
 * 이동순서  23열의 window.addEventListener("load",init,false)에서 첫번째 이벤트가 load로 설정되어 run됨에 따라
 * init을 실핼한다. false는 다중생성자인데 아직 사용하지 않는다.
 *  9번열 var checkDuplBtn = document.querySelector('#check_dupl_btn'); 연결되어있는 jsp의 check_dupl_btn을
 *  9번열 checkDuplBtn에 담는다. 
 *  13열에서 checkDuplBtn을 다시 addEventListener로 실행을 시킨다. 이벤트는 클릭으로 설정되어 run이 되더라도 click을 눌러야지 실행이된다.
 */


function init() {
	var checkDuplBtn = document.querySelector('#check_dupl_btn');
	var joinConfirmBtn = document.querySelector('#joint_confirm_btn');
	checkDuplBtn.addEventListener("click",checkDupl,false);
	joinConfirmBtn.addEventListener("click",joinConfirm,false);
}
function checkDupl(e) {
	alert('중복체크 클릭');
	
}

function joinConfirm(e) {
	
	document.querySelector('#join_form').submit();
	var inputPass = document.querySelector('#input_pass').value;
	var inputId = document.querySelector('#input_id').value;
	alert('아이디 확인'+inputId+'비밀번호 확인'+inputPass);
	sessionStorage.setItem('id',inputId);
	sessionStorage.setItem('pass',inputPass);
	
}
window.addEventListener("load",init,false)