/*/////////////////////////////////////////////////////USER///////////////////////////////////////////////////////////////*/
function searchByPassport() {
    var passport = document.getElementById("search_field").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
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
    xhttp.open("GET", "http://localhost:8080/users/findByPassport?passport=" + passport, true);
    xhttp.send();
}

function deleteUser(userId) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/users/delete/" + userId, true);
    xhttp.send();
}

function createUser() {
    var userUsername = document.getElementById("user_username").value;
    var userSurname = document.getElementById("user_surname").value;
    var userBirth_date = document.getElementById("user_birth_date").value;
    var userGender= document.getElementById("user_gender").value;
    var userPassport= document.getElementById("user_passport").value;
    var userLogin = document.getElementById("user_login").value;
    var userCar = document.getElementById("user_car:{id}").value;

    var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
    xmlhttp.open("POST", "http://localhost:8080/users/save");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({
        username: userUsername, surname: userSurname,
        birth_date: userBirth_date, gender: userGender,
        passport: userPassport, login: userLogin, car:userCar
    }));

    loadUsers();
}

function loadUsers() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
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
    xhttp.open("GET", "http://localhost:8080/users/findAll", true);
    xhttp.send();
}

loadUsers();

/*//////////////////////////////////////////////////CONTRACT//////////////////////////////////////////////////////////////*/

function createContract() {
    var contractName = document.getElementById("contract_name_contract").value;
    var car = document.getElementById("contract_Car").value;
    var user = document.getElementById("contract_User").value;
    var time_rent_start = document.getElementById("contract_time_rent_start").value;
    var time_rent_end = document.getElementById("contract_time_rent_end").value;

    var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
    xmlhttp.open("POST", "http://localhost:8080/contract/save");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({
        name_contract: contractName, car: car,
        user: user, time_rent_start: time_rent_start,
        time_rent_end: time_rent_end
    }));

     loadContract();
}

function loadContract() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var contract = JSON.parse(this.responseText);
            var html = '<tr>\n' +
                '        <th>Contract id</th>\n' +
                '        <th>User</th>\n' +
                '        <th>Car</th>\n' +
                '        <th>Name Contract</th>\n' +
                '        <th>time_rent_start</th>\n' +
                '        <th>time_rent_end</th>\n' +
                '    </tr>';
            for (var i = 0; i < contract.length; i++) {
                var contract = contract[i];
                console.log(contract);
                html = html + '<tr><td>' + contract.id + '</td>\n' +
                    '        <th>' + contract.user + '</th>\n' +
                    '        <th>' + contract.car + '</th>\n' +
                    '        <th>' + contract.name_contract + '</th>\n' +
                    '        <th>' + contract.time_rent_start + '</th>\n' +
                    '        <th>' + contract.time_rent_end + '</th>\n' +
                    '</tr>';

            }
            document.getElementById("contractList").innerHTML = html;
        }
    };
    xhttp.open("GET", "http://localhost:8080/contract/findAll", true);
    xhttp.send();
}
loadContract();


/*///////////////////////////////////////////////////////////CAR//////////////////////////////////////////////////////////*/

    function createCars() {
    var brand = document.getElementById("brand").value;
    var model = document.getElementById("model").value;
    var guarantee_expiration_date = document.getElementById("guarantee_expiration_date").value;
    var price_rent = document.getElementById("price_rent").value;
    var creation = document.getElementById("creation").value;
    var capacity_l = document.getElementById("capacity_l").value;
    var country_of_creation = document.getElementById("country_of_creation").value;
    var rent = document.getElementById("rent").value;

    var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
    xmlhttp.open("POST", "http://localhost:8080/cars/save");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({
    brand: brand, model: model,
    guarantee_expiration_date: guarantee_expiration_date, price_rent: price_rent,
    creation: creation, capacity_l: capacity_l, country_of_creation: country_of_creation, rent: rent
}));

    loadCars();

}

    function loadCars() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
    var car = JSON.parse(this.responseText);
    var html = '<tr>\n' +
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
    for (var i = 0; i < car.length; i++) {
    var car = car[i];
    console.log(car);
    html = html + '<tr><td>' + car.id + '</td>\n' +
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
    xhttp.open("GET", "http://localhost:8080/cars/findAll", true);
    xhttp.send();
}
    loadCars();
