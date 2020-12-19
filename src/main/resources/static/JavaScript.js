/*/////////////////////////////////////////////////////USER/////////////////////////////////////////////////////////////*/
function searchByPassport() {
    var passport = document.getElementById("search_field").value;
    var https = new XMLHttpRequest();
    https.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var user = JSON.parse(this.responseText);
            var html = '<tr>\n' +
                '        <th>User id</th>\n' +
                '        <th>User username</th>\n' +
                '        <th>User surname</th>\n' +
                '        <th>User birth_date</th>\n' +
                '        <th>User gender</th>\n' +
                '        <th>User passport</th>\n' +
                '        <th>User login</th>\n' +
                '        <th>User car</th>\n' +
                '        <th>Delete</th>\n' +
                '    </tr>';
            html = html + '<tr>' +
                '        <td>' + user.id +'</td>\n' +
                '        <th>' + user.username +'</th>\n' +
                '        <th>' + user.surname +'</th>\n' +
                '        <th>' + user.birth_date +'</th>\n' +
                '        <th>' + user.gender +'</th>\n' +
                '        <th>' + user.passport +'</th>\n' +
                '        <th>' + user.login +'</th>\n' +
                '        <th>' + user.car +'</th>\n' +
                '        <td><button onclick="deleteUser(' + user.id + ')">Delete</button></td></tr>';
            document.getElementById("usersList").innerHTML = html;
        }
    };
    https.open("GET", "http://localhost:8080/users/findByPassport?passport=" + passport, true);
    https.send();
}

function deleteUser(userId) {
    var https = new XMLHttpRequest();
    https.open("DELETE", "http://localhost:8080/users/delete/" + userId, true);
    https.send();
}

function createUser() {
    var userUsername = document.getElementById("user_username").value;
    var userSurname = document.getElementById("user_surname").value;
    var userBirth_date = document.getElementById("user_birth_date").value;
    var userGender= document.getElementById("user_gender").value;
    var userPassport= document.getElementById("user_passport").value;
    var userLogin = document.getElementById("user_login").value;
    let Car = document.getElementById("car:{id}").value;

    var xhtml = new XMLHttpRequest();   // new HttpRequest instance
    xhtml.open("POST", "http://localhost:8080/users/save");
    xhtml.setRequestHeader("Content-Type", "application/json");
    xhtml.send(JSON.stringify({
        username: userUsername, surname: userSurname,
        birth_date: userBirth_date, gender: userGender,
        passport: userPassport, login: userLogin, car:Car
    }));

    loadUsers();
}

function loadUsers() {
    var https = new XMLHttpRequest();
    https.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var users = JSON.parse(this.responseText);
            var html = '<tr>\n' +
                '        <th>User id</th>\n' +
                '        <th>User username</th>\n' +
                '        <th>User surname</th>\n' +
                '        <th>User birth_date</th>\n' +
                '        <th>User gender</th>\n' +
                '        <th>User passport</th>\n' +
                '        <th>User login</th>\n' +
                '        <th>car</th>\n' +
                '        <th>Delete</th>\n' +
                '    </tr>';
            for (var i = 0; i < users.length; i++) {
                var user = users[i];
                console.log(user);
                html = html + '<tr><td>' + user.id + '</td>\n' +
                    '        <th>' + user.username + '</th>\n' +
                    '        <th>' + user.surname + '</th>\n' +
                    '        <th>' + user.birth_date + '</th>\n' +
                    '        <th>' + user.gender + '</th>\n' +
                    '        <th>' + user.passport + '</th>\n' +
                    '        <th>' + user.login + '</th>\n' +
                    '        <th>' + user.car + '</th>\n' +
                    '        <td><button onclick="deleteUser(' + user.id + ')">Delete</button></td></tr>';

            }
            document.getElementById("usersList").innerHTML = html;
        }
    };
    https.open("GET", "http://localhost:8080/users/findAll", true);
    https.send();
}

loadUsers();

/*//////////////////////////////////////////////////CONTRACT////////////////////////////////////////////////////////////*/

function createContract() {
    var name_contract = document.getElementById("name_contract").value;
    var time_rent_start = document.getElementById("time_rent_start").value;
    var time_rent_end = document.getElementById("time_rent_end").value;
    var car_id = document.getElementById("car_id").value;
    let user_id = document.getElementById("user_id").value;

    var xhtml = new XMLHttpRequest();   // new HttpRequest instance
    xhtml.open("POST", "http://localhost:8080/contract/save");
    xhtml.setRequestHeader("Content-Type", "application/json");
    xhtml.send(JSON.stringify({
        name_contract: name_contract, time_rent_start: time_rent_start,
        time_rent_end: time_rent_end, car_id: car_id,
        user_id: user_id
    }));

    loadContract();

}

function loadContract() {
    var https = new XMLHttpRequest();
    https.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var contracts = JSON.parse(this.responseText);
            var html = '<tr>\n' +
                '        <th>Contract id</th>\n' +
                '        <th>name_contract</th>\n' +
                '        <th>time_rent_start</th>\n' +
                '        <th>time_rent_end</th>\n' +
                '        <th>car_id</th>\n' +
                '        <th>user_id</th>\n' +
                '    </tr>';
            for (var i = 0; i < contracts.length; i++) {
                var contract = contracts[i];
                console.log(contract);
                html = html + '<tr> <td>' + contract.id + '</td>\n' +
                    '        <th>' + contract.name_contract + '</th>\n' +
                    '        <th>' + contract.time_rent_start + '</th>\n' +
                    '        <th>' + contract.time_rent_end + '</th>\n' +
                    '        <th>' + contract.car_id + '</th>\n' +
                    '        <th>' + contract.user_id + '</th>\n' +
                    '</tr>';

            }
            document.getElementById("contractList").innerHTML = html;
        }
    };
    https.open("GET", "http://localhost:8080/contract/findAll", true);
    https.send();
}

loadContract();



/*///////////////////////////////////////////////////////////CAR////////////////////////////////////////////////////////*/
    function createCar() {
        const brand = document.getElementById("brand").value;
        const model = document.getElementById("model").value;
        const guarantee_expiration_date = document.getElementById("guarantee_expiration_date").value;
        const price_rent = document.getElementById("price_rent").value;
        const creation = document.getElementById("creation").value;
        const capacity_l = document.getElementById("capacity_l").value;
        const country_of_creation = document.getElementById("country_of_creation").value;
        const rent = document.getElementById("rent").value;

        const xhtml = new XMLHttpRequest();   // new HttpRequest instance
    xhtml.open("POST", "http://localhost:8080/cars/save");
    xhtml.setRequestHeader("Content-Type", "application/json");
    xhtml.send(JSON.stringify({
    brand: brand, model: model,
    guarantee_expiration_date: guarantee_expiration_date, price_rent: price_rent,
    creation: creation, capacity_l: capacity_l, country_of_creation: country_of_creation, rent: rent
}));

        loadCars();

}

    function loadCars() {
        const https = new XMLHttpRequest();
        https.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
        const cars = JSON.parse(this.responseText);
        let html = '<tr>\n' +
            '        <th>Car id</th>\n' +
            '        <th>Brand</th>\n' +
            '        <th>Model</th>\n' +
            '        <th>Guarantee_expiration_date</th>\n' +
            '        <th>Price_rent</th>\n' +
            '        <th>Color</th>\n' +
            '        <th>Creation</th>\n' +
            '        <th>Capacity_l</th>\n' +
            '        <th>Country_of_creation</th>\n' +
            '        <th>Rent</th>\n' +

            '    </tr>';
        for (let i = 0; i < cars.length; i++) {
            const car = cars[i];
            console.log(car);
    html = html + '<tr> <td>' + car.id + '</td>\n' +
    '        <th>' + car.brand + '</th>\n' +
    '        <th>' + car.model + '</th>\n' +
    '        <th>' + car.guarantee_expiration_date + '</th>\n' +
    '        <th>' + car.price_rent + '</th>\n' +
    '        <th>' + car.color + '</th>\n' +
    '        <th>' + car.creation + '</th>\n' +
    '        <th>' + car.capacity_l + '</th>\n' +
    '        <th>' + car.country_of_creation + '</th>\n' +
    '        <th>' + car.rent + '</th>\n' +
    '</tr>';

}
    document.getElementById("carList").innerHTML = html;
}
};
    https.open("GET", "http://localhost:8080/cars/findAll", true);
    https.send();
}
    loadCars();
