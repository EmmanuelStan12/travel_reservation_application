$('#client_names').change(function (event) {
    const entry = event.target.value;
    const value = $('#client_names option:first-child').val()
    if (value == -1 && entry != -1) {
        $('#client_names option:first-child').remove()
    }
    if (entry != -1) {
        $.ajax({
            type: "GET",
            url: "updateClientAction?selectedCid="+entry,
            success: function (data) {
                updateContactNames(JSON.parse(data));
            },
            error: function (err) {
                console.log(err)
            }
        })
    }
});

$('#contact_names').change(function (event) {
    const entry = $('#contact_names').find(":selected").text();
    console.log(entry)
    $('#contact_name').val(entry);
})

function updateContactNames(contacts) {
    $('#contact_names').empty();
    //console.log(contacts);
    contacts.map((contact) => {
        $('#contact_names').append(createContact(contact))
    });
    $('#contact_name').val(contacts[0].name);
}

function createContact(contact) {
    return `<option value="${contact.id}">${contact.name}</option>`;
}

$('#detail_form').onsubmit(function (event) {
    event.preventDefault();
    console.log('Good')
});

$('#add_reservation_btn').click(function () {

})