$(document).ready(function () {
    getVCode();
})

function getVCode() {
    document.getElementById("code").src = timestamp("http://localhost:8080/verifyCode");
}

//为url添加时间戳
function timestamp(url) {
    var getTimestamp = new Date().getTime();
    if (url.indexOf("?") > -1) {
        url = url + "&timestamp=" + getTimestamp
    } else {
        url = url + "?timestamp=" + getTimestamp
    }
    return url;
}

function submits() {
    var nickname = $("#nickname").val();
    var account = $("#account").val();
    var password = $("#password").val();
    var phonenum = $("#phonenum").val();
    var verify = $("#verify").val();
    var testNickname = /^[\u4e00-\u9fa50-9a-zA-Z]{2,10}$/;
    var testAccount = /^[0-9a-zA-Z]{4,10}$/;
    var testPassword = /^[0-9a-zA-Z]{4,10}$/;
    var testPhone = /^[0-9]{11}$/;
    if (nickname == null || nickname.trim().length === 0) {
        window.alert("昵称不能为空!");
    } else if (account == null || account.trim().length === 0) {
        window.alert("账号不能为空!");
    } else if (password == null || password.trim().length === 0) {
        window.alert("密码不能为空!");
    } else if (phonenum == null || phonenum.trim().length === 0) {
        window.alert("手机号码不能为空!");
    } else if (verify == null || verify.trim().length === 0) {
        window.alert("验证码不能为空!")
    } else if (!testNickname.test(nickname)) {
        window.alert("昵称必须超过2位且只包含中文英文和数字!")
    } else if (!testAccount.test(account)) {
        window.alert("账号必须超过4位且只包含英文和数字!")
    } else if (!testPassword.test(password)) {
        window.alert("密码必须超过4位且只包含英文和数字!")
    } else if (!testPhone.test(phonenum)) {
        window.alert("中国手机号码必须是11位且只包含数字!")
    } else {
        return true;
    }
    return false;
}




