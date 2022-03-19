function onclicks() {
    $('.search').submit();
}

function changeType(text) {
    $("#type").val(text)
    $(".selectBase").submit();
}

function changeProv(province) {
    $("#prov").val(province)
    $("#city").val("")
    $(".selectBase").submit();
}

function changeCity(city) {
    $("#city").val(city)
    $(".selectBase").submit();
}

function changeTime(starthour, endhour) {
    $("#starthour").val(starthour)
    $("#endhour").val(endhour)
    $(".selectBase").submit();
}