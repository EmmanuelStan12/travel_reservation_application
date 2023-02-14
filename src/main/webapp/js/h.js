const creditType = $('#creditTypes');
const clientType = $('#clientTypes');
const offices = $('#offices');
const owners = $('#owners');

const endDate = $('#end_date');
const vehicleTypes = $('#vehicle_types');
const vehicles = $('#vehicles');
const personnelTypes = $('#personnel_types');
const personals = $('#personals')
const isApproved = $('#is_approved');
const submitter = $('#users');
const isResourceAvailable = $('#is_resource_available');
const numPerPage = $('#num_per_page');

let nextPage = 0;
let currentResult = null;

$(document).ready(function(){
    document.querySelector('.overlay').classList.add('show');
    $.ajax({ url: `loadReservations?perPage=10&page=1`,
        context: document.body,
        success: function(data){
            const result = JSON.parse(data);
            nextPage = parseInt(result.nextPage);
            let trips = result.trips;
            updateTripsTable(trips);
            currentResult = result;

            updatePageInfo(result);
        }
    }).done(function () {
        document.querySelector('.overlay').classList.remove('show')
    })

    registerOperatorChangeListener();
});

function registerOperatorChangeListener() {
    $('#operators').change(function (event) {
        let value = event.target.value;

    })
}

$('#next').click(function () {
    if (nextPage <= currentResult?.pages) {
        loadTrips(nextPage)
    }
})

$('#first').click(function () {
    loadTrips(1);
})

$('#last').click(function () {
    loadTrips(currentResult?.pages);
})

function loadTrips(page) {
    const queries = getQueries().filter((query) => query.length !== 0).join('&') + `&page=${page}`;
    document.querySelector('.overlay').classList.add('show');
    $.ajax({
        url: "loadReservations?" + queries,
        type: "GET",
        success: function (data) {
            const result = JSON.parse(data);
            nextPage = parseInt(result.nextPage);
            let trips = result.trips;
            updateTripsTable(trips);
            currentResult = result;

            updatePageInfo(result);
        },
        error: function (err) {
            console.log(err)
        }
    }).done(function () {
        document.querySelector('.overlay').classList.remove('show');
    })
}
function updatePageInfo(result) {
    $('#pages').empty();
    $('.list_desc').text(`Displaying ${result.start} - ${result.end} Of ${result.count}`);
    for (let i = 1; i <= result.pages; i++) {
        const el = createPage(i);
        $('#pages').append(el);
    }
}

$('#form_details').submit(function (event) {
    event.preventDefault();
});

$('#btn_search').click(function () {
    const queries = getQueries().filter((query) => query.length !== 0).join('&') + '&page=1';
    document.querySelector('.overlay').classList.add('show');
    $.ajax({
       url: "loadReservations?"+queries,
       type: "GET",
       success: function (data) {
           const result = JSON.parse(data);
           nextPage = parseInt(result.nextPage);
           let trips = result.trips;
           currentResult = result;
           updateTripsTable(trips);

           updatePageInfo(result);
       },
        error: function (err) {
           console.log(err)
        }
    }).done(function () {
        document.querySelector('.overlay').classList.remove('show');
    })
});

function constructQueryFromDropDownDefault(field, query) {
    const selected = field.find(":selected");
    console.log("Default", selected.val(), selected.text())
    return selected.val() == -1 ? '' : `${query}=${selected.text()}`
}

const booleanMapping = {
    True: 0x01,
    False: 0x00
}

function constructQueryFromDropDown(field, query, lowercase = false) {
    const selected = field.find(":selected");
    console.log(selected.val());
    let text = selected.text();
    if (lowercase) {
        text = booleanMapping[text];
    }
    return selected.val() == -1 ? '' : `${query}=${text}`
}

function constructQueryForUser(field, query) {
    const selected = field.find(":selected").val();
    console.log("User id - ", selected);
    return selected == -1 ? '' : `${query}=${selected}`
}

function constructQueryFromDatePicker(field, query) {
    const value = field.val().length === 0;
    console.log("datepicker", field.val())
    return value ? '' : `${query}=${field.val()}`
}

function getQueries() {
    const creditTypeQuery = constructQueryFromDropDownDefault(creditType, "t.detail.creditType");
    const clientTypeQuery = constructQueryFromDropDownDefault(clientType, "t.detail.clientType");
    const officeQuery = constructQueryFromDropDown(offices, "t.detail.office");
    const ownerQuery = constructQueryFromDropDown(owners, "t.detail.owner");
    const vehicleTypeQuery = constructQueryFromDropDown(vehicleTypes, "t.vehicleType");
    const vehicleQuery = constructQueryFromDropDown(vehicles, "t.vehicle");
    const personalQuery = constructQueryFromDropDown(personals, "t.personnel");
    const personnelTypeQuery = constructQueryFromDropDown(personnelTypes, "t.personnelType");
    const isApprovedQuery = constructQueryFromDropDown(isApproved, "t.detail.isApproved", true);
    const submitterQuery = constructQueryForUser(submitter, "t.detail.user.uid");
    const isResourceAvailableQuery = constructQueryFromDropDown(isResourceAvailable, "t.isResourceAvailable", true);
    const numPerPageQuery = constructQueryFromDropDown(numPerPage, "perPage");
    const startDate = $('span#start_date > input[type="hidden"]')
    const endDate = $('span#end_date > input[type="hidden"]')
    const startQuery = constructQueryFromDatePicker(startDate, "startDate");
    const operator = constructQueryFromDropDown($('#operators'), "operator");
    const endQuery = constructQueryFromDatePicker(endDate, "t.endDate")

    return [
        creditTypeQuery,
        clientTypeQuery,
        officeQuery,
        ownerQuery,
        vehicleTypeQuery,
        vehicleQuery,
        personalQuery,
        personnelTypeQuery,
        isApprovedQuery,
        submitterQuery,
        isResourceAvailableQuery,
        numPerPageQuery,
        operator.length === 0 ? '' : startQuery,
        endQuery,
        startQuery.length === 0 ? '' : operator
    ];
}

function updateTripsTable(trips) {
    const header = $('.list_table .list_header').detach()
    $('.list_table tbody').empty().append(header);
    trips.map((trip) => {
        const element = createTripEntry(trip);
        $('.list_table tbody').append(element)
    })
}

function createTripEntry(trip) {
    return `
        <tr align="center" class="list_entry">
            <td>
                ${trip.id}
            </td>
            <td>
                ${trip.detail.date}
            </td>
            <td>
                ${trip.detail.office}
            </td>
            <td>
                ${trip.detail.clientType}
            </td>
            <td align="center" style="padding: 0;">
                ${trip.createdAt} : ${trip.departure} -&gt; ${trip.destination}
            </td>
            <td>
                ${trip.detail.status}
            </td>
            <td>
                ${trip.createdAt}
            </td>
            <td>
                ₦${trip.totalAmount}
            </td>
        </tr>
    `;
}

function createPage(page) {
    let p = nextPage;
    if (Number.isNaN(nextPage)) {
        p = currentResult.pages + 1;
    }
    console.log("next page", p, nextPage);
    let color = p - 1 === page ? 'black' : 'blue';
    return `<span onclick="loadTrips(${page})" class="anchor" style="color: ${color};">${page}</span>`
}

$('#vehicle_types').change(function (event) {
    const entry = event.target.value;
    const value = $('#vehicle_types option:first-child').val()
    if (value == -1 && entry != -1) {
        $('#vehicle_types option:first-child').remove()
    }
    if (entry != -1) {
        $.ajax({
            type: "GET",
            url: "updateVehicleAction?selectedVid="+entry,
            success: function (data) {
                updateVehicles(JSON.parse(data));
            },
            error: function (err) {
                console.log(err)
            }
        })
    }
});

function updateVehicles(vehicles) {
    $('#vehicles').empty();

    //console.log(contacts);
    vehicles.map((vehicle) => {
        $('#vehicles').append(createVehicle(vehicle))
    });
    //$(`#vehicles option[value="0"]`).attr("selected",true);
}

function createVehicle(vehicle) {
    return `<option value="${vehicle.vid}">${vehicle.name}</option>`;
}

$('#personnel_types').change(function (event) {
    const entry = event.target.value;
    const value = $('#personnel_types option:first-child').val()
    if (value == -1 && entry != -1) {
        $('#personnel_types option:first-child').remove()
    }
    if (entry != -1) {
        $.ajax({
            type: "GET",
            url: "updatePersonnelAction?selectedPid="+entry,
            success: function (data) {
                updatePersonals(JSON.parse(data));
            },
            error: function (err) {
                console.log(err)
            }
        })
    }
});

function updatePersonals(personals) {
    $('#personals').empty();

    //console.log(contacts);
    personals.map((personnel) => {
        $('#personals').append(createPersonnel(personnel))
    });
    //$(`#vehicles option[value="0"]`).attr("selected",true);
}

function createPersonnel(personnel) {
    return `<option value="${personnel.pid}">${personnel.name}</option>`;
}