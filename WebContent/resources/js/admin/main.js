/**
 * 
 */

window.addEventListener("load",init,false);
function init() {
	document.querySelector('#create_table_btn').addEventListener("click",goCreateTable,false);
}

function goCreateTable() {
	location.href = "member_list.jsp";
	
}