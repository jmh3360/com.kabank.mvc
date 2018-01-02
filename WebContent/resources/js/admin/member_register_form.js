/**
 * 
 */

window.addEventListener("load",init,false);
function init() {
	document.querySelector('#memeber_register_btn').addEventListener("click",memberRegister,false);
}
function memberRegister() {
		document.querySelector('#member_register_form').submit();
}

	
