$('#add_reservation_btn').click(function () {
    const office = $('#offices').find(":selected").text();
    const owner = $('#owners').find(":selected").text();
    const clientTypeIndividual = $('#client_typeIndividual').is(":checked")
    const clientTypeCompany = $('#client_typeCompany').is(":checked")
    const creditTypeClient = $("[id = 'credit_typeCredit Client']").is(":checked")
    const creditTypeNonClient = $("[id = 'credit_typeNon Credit Client']").is(":checked")
    const date = $('#date').val();
    const name = $('#client_names').find(":selected").text();
    const contactName = $('#contact_name').val()
    const email = $('#detailEmail').val()
    const detailPhoneNumber = $('#detailPhoneNumber').val()
    const remark = $('#remark').val()
    const status = $('#status').find(":selected").text();
    const isApproved = $('#approved').is(":checked")
    const notApproved = $('#notApproved').is(":checked");
    const isValid = $("#detail_form input").filter(function () {
        return $.trim($(this).val()).length === 0
    }).length === 0;
    if (
        !isValid ||
        !(clientTypeCompany || clientTypeIndividual) ||
        !(creditTypeClient || creditTypeNonClient) ||
        !(isApproved || notApproved)
    ) {
        $('#error_field').text("Please fill in all fields")
    } else {
        $('#error_field').text("")
        const detail = {
            office,
            owner,
            clientType: clientTypeCompany ? 'Company' : 'Individual',
            creditType: creditTypeClient ? 'Credit Client' : 'Non Credit Client',
            date,
            name,
            contactName,
            email,
            phoneNumber: detailPhoneNumber,
            remark,
            status,
            isApproved
        }

        submitForm(detail);
    }
});

function submitForm(detail) {
    document.querySelector('.overlay').classList.add('show');
    console.log(detail, trips);
    const data = {
        "data": [JSON.stringify(detail), JSON.stringify(trips)]
    }
    $.ajax({
        type: "POST",
        url: "addReservationAction",
        data: JSON.stringify(data),
        dataType: 'json',
        contentType:"application/json;charset=utf-8",
        success: function (data) {
            window.location.replace("homeAction");
        },
        error: function (err) {
            console.log(err)
        }
    }).done(function() {
        document.querySelector('.overlay').classList.remove('show');
    });
}