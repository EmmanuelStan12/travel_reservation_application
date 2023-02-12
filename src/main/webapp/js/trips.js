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

const trips = [];

function onPriceOrDaysChanged() {
    const price = $('#pricePerDay').val()
    const days = $('#noOfDays').val()
    if (price !== '' && days !== '') {
        const amount = parseInt(price) * parseInt(days)
        $('#total_amount').text('Total Amount: ' + amount)
    } else {
        $('#total_amount').text('Total Amount: ' + 0)
    }
}

$('#noOfDays').on('input', onPriceOrDaysChanged)
$('#pricePerDay').on('input', onPriceOrDaysChanged)

$('#trip_form').submit(function (event) {
    event.preventDefault();
    onCreateTrip();
})

function updateTripItems() {
    const tripItems = $(".trip_items");
    tripItems.empty();
    trips.filter((trip) => trip !== null).forEach((trip) => {
        const tripItem = createTrip(trip)
        tripItems.append(tripItem)
    })
}

function onCreateTrip() {
    const passengerName = $('#passenger_name').val()
    const noOfPassengers = $('#noOfPassengers').val()
    const phoneNumber = $('#phoneNumber').val()
    const email = $('#email').val()
    const departure = $('#departure').val()
    const destination = $('#destination').val()
    const possibleStops = $('#possibleStops').val()
    const vehicleCategory = $('#vehicleCategory').val()
    const serviceType = $('#rideHailing').is(':checked') ? 'Ride Hailing' : 'Pool Vehicle'
    const noOfDays = parseInt($('#noOfDays').val())
    const pricePerDay = parseInt($('#pricePerDay').val())
    const additionalInformation = $('#additionalInformation').val()
    const personnelType = $('#personnel_types').find(":selected").text();
    const personnel = $('#personals').find(":selected").text();
    const vehicleType = $('#vehicle_types').find(":selected").text();
    const vehicle = $('#vehicles').find(":selected").text();
    const isResourceAvailable = $('#isResourceAvailable').is(':checked')

    const trip = {
        id: Date.now(),
        passengerName,
        noOfPassengers,
        phoneNumber,
        email,
        departure,
        destination,
        possibleStops,
        vehicleCategory,
        serviceType,
        noOfDays,
        pricePerDay,
        additionalInformation,
        personnelType,
        personnel,
        vehicleType,
        vehicle,
        isResourceAvailable,
        totalAmount: noOfDays * pricePerDay
    }

    trips.push(trip)

    updateTripItems()
}

function createTrip(trip) {
    return `
        <div class="trip_item" id="${trip.id}">
            <p>Passenger name: <span>${trip.passengerName}</span></p>
            <p>Email: <span>${trip.email}</span></p>
            <p>Number of Passengers: <span>${trip.noOfPassengers}</span></p>
            <p>Departure: <span>${trip.departure}</span></p>
            <p>Destination: <span>${trip.destination}</span></p>
            <p>Price per day: <span>${trip.pricePerDay}</span></p>
            <p>No of days: <span>${trip.noOfDays}</span></p>
            <p>Total Amount: <span>${trip.totalAmount}</span></p>
            <button onclick="deleteItem(${trip.id})" id="${trip.id}" type="button" class="btn_submit btn_save">Delete</button>
        </div>
    `;
}

function deleteItem(tripId) {
    const index = trips.findIndex((trip) => trip.id = tripId)
    trips[index] = null
    updateTripItems()
}

