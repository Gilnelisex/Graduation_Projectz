function getIn(id) {
    $.get(`/getOrder/${id}`, function (resp) {
        $('#updateform-modal-body0').html(resp);
    });
}
function cancelz(id) {
    $.get(`/getCancel/${id}`, function (resp) {
        $('#updateform-modal-body1').html(resp);
    });
}
function deletez(id) {
    $.get(`/getDelete/${id}`, function (resp) {
        $('#updateform-modal-body2').html(resp);
    });
}