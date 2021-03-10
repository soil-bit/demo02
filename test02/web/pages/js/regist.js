function val(objId) {
	return document.getElementById(objId).value;
}

function checkUsername(){
	var registName = val("username");
	
	if (!/^\w{5,12}$/.test(registName)) {
		showTip("usernameTip","必须由字母，数字下划线组成，并且长度为5到12位")
		return true;
	} else {
		hideTip("usernameTip");
		return false;
	}
}

function checkPassword(){
	var password = val("password");
	
	if (!/^\w{5,12}$/.test(password)) {
		showTip("passwordTip","必须由字母，数字下划线组成，并且长度为5到12位")
		return true;
	} else {
		hideTip("passwordTip");
		return false;
	}
}

function reCheckPassword(){
	var password = val("password");
	var rePassword = val("repwd");
	if (password != rePassword) {
		showTip("repwdTip","密码不相同")
		return true;
	} else {
		hideTip("repwdTip");
		return false;
	}
}

function checkEmail(){
	var email = val("email");
	if (!/^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/.test(email)) {
		showTip("emailTip","邮箱格式错误")
		return true;
	} else {
		hideTip("emailTip");
		return false;
	}
}

function checkCode(){
	var code = val("code");
	if (!code) {
		showTip("codeTip","验证码不为空")
		return true;
	} else {
		hideTip("codeTip");
		return false;
	}
}




function getObj(objId){
	return document.getElementById(objId);
}

function showTip(errObjId, text) {
	var showObj = getObj(errObjId);
	showObj.style.color="red"
	showObj.innerHTML = text;
	showObj.style.display = "block"
}

function hideTip(errObjId) {
	var showObj = getObj(errObjId);
	// showObj.innerHTML = "";
	showObj.style.display = "none"
}

function focus(objId) {
	return document.getElementById(objId).focus();
}

function checkReg() {
	var focusObjId = null;
	if (checkUsername()) {
		focusObjId = "username";
	} 
	if(checkPassword()){
		focusObjId = "password";
	}
	
	if(reCheckPassword()){
		focusObjId = "repwd";
	}
	
	if(checkEmail()){
		focusObjId = "email";
	}
	if(checkCode()){
		focusObjId = "email";
	}
	
	if (focusObjId) {
		focus(focusObjId);
		return false;
	}
	return true;
}
