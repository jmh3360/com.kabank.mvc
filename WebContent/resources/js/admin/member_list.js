/**
 * 
 */

window.addEventListener("load",init,false);
function init() {
	document.querySelector('#member_register_form_btn').addEventListener("click",memberRegisterForm,false);
}
function memberRegisterForm() {
	location.href = "member_register_form.jsp";
}

	
