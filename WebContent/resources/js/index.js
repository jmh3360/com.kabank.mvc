/**
 * 
 */
function init() {
	var goAdminLink = document.querySelector('#go_admin_link');
	var goJoinLink = document.querySelector('#go_join_link');
	var indexLoginBtn = document.querySelector('#index_input_btn');
	
	goAdminLink.addEventListener("click",goAdmin,false);
	goJoinLink.addEventListener("click",goJoin,false);
	indexLoginBtn.addEventListener("click",indexLogin,false);
}
function goAdmin() {
    if(confirm('관리자?')) {
          alert('안녕하세요 관리자님');
          location.href = "admin/main.jsp";
    }else{
          alert('관리자만 접근가능 합니다.');
    }
}
    function goJoin() {
    	 var admin = confirm('회원가입하시겠습니까?');
         if(admin) {
               location.href = "user/join_form.jsp";
         }else{
         }

	}
    function indexLogin(e) {
		
		//session storage는 이미 만들어진 것이다.
		var loginId =document.querySelector('#index_input_id').value;
		var loginPass =document.querySelector('#index_input_pass').value;
		var joinId = sessionStorage.getItem('id');
		var joinPass = sessionStorage.getItem('pass');
		
		if(loginId === joinId){
			if(loginPass === joinPass){
				alert('환영합니다' +joinId+"님");
			}else{
				e.preventDefault();
				alert('비밀번호 오류');
			}
		}else{
			e.preventDefault();
			alert('없는 ID입니다.');
		} 
	}


window.addEventListener("load",init,false);

