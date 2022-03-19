function changePic(id) {
    $.get(`/getChangePic/${id}`, function (resp) {
        $('#updateform-modal-body0').html(resp);
    });
}

function changePassword(id) {
    $.get(`/getChangePassword/${id}`, function (resp) {
        $('.baseData').html(resp);
    });
}

function changePics() {
    var reads = new FileReader();
    var pics = document.querySelector("#file").files[0];
    var size = (pics.size / 1024).toFixed(0);
    reads.readAsDataURL(pics);
    reads.onload = function (e) {
        document.querySelector(".review").src = this.result;
        if (size >= 1024) {
            document.querySelector("#picSubmit").style.background = "darkgray"
            document.querySelector("#picSubmit").disabled = true;
            window.alert("图片最大不能超过1MB!")
        } else {
            document.querySelector("#picSubmit").style.background = "#189f92"
            document.querySelector("#picSubmit").disabled = false;
        }
    }
}

function changePasswords() {
    var password = document.querySelector("#newPassword").value;
    var confirmpassword = document.querySelector("#confirmPassword").value;
    var tests = / /;
    if (password === "" || confirmpassword === "") {
        window.alert("密码不能为空");
    } else if (tests.test(password) || tests.test(confirmpassword)) {
        window.alert("密码不能包含空格");
    } else if (!(password === confirmpassword)) {
        window.alert("两次密码不一致");
    } else {
        $.ajax({
            url: "/changePassword",
            method: "post",
            data: {
                "id": $("#id").val(),
                "password": $("#newPassword").val()
            },
            success: function (data) {
                console.log(data);
                if (data.toString() === "success") {
                    window.alert("修改成功");
                } else {
                    window.alert("修改失败");
                }
            }
        })
    }
}