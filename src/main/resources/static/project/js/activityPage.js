function onclicks() {
    $('.search').submit();
}

function changeType(text) {
    $("#type").val(text)
    $(".selectAct").submit();
}

function changeHarvest(text) {
    $("#harvest").val(text)
    $(".selectAct").submit();
}

function changeTime(startime, endtime) {
    $("#startime").val(startime)
    $("#endtime").val(endtime)
    $(".selectAct").submit();
}


