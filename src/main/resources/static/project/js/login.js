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
    var account = $("#account").val();
    var password = $("#password").val();
    var verify = $("#verify").val();
    var testAccount = /^[0-9a-zA-Z]+$/;
    var testPassword = /^[0-9a-zA-Z]+$/;
    if (account == null || account.trim().length === 0) {
        window.alert("账号不能为空!");
    } else if (password == null || password.trim().length === 0) {
        window.alert("密码不能为空!");
    } else if (!testAccount.test(account)) {
        window.alert("账号不能包含空格且只包含英文和数字!")
    } else if (!testPassword.test(password)) {
        window.alert("密码不能包含空格且只包含英文和数字!")
    } else if (verify == null || verify.trim().length === 0) {
        window.alert("验证码不能为空!")
    } else {
        return true;
    }
    return false;
}




