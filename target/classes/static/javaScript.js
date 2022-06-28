/*/////////////////////////////////////////////////////USER/////////////////////////////////////////////////////////////*/
function searchByPassport() {
    let passport = document.getElementById("search_field").value;
    let https = new XMLHttpRequest();
    https.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let user = JSON.parse(this.responseText);
            let car = JSON.parse(this.responseText);
             let html = '<tr>\n' +
                '        <th>User №</th>\n' +
                '        <th>Username</th>\n' +
                '        <th>Surname</th>\n' +
                '        <th>Birth_date</th>\n' +
                '        <th>Gender</th>\n' +
                '        <th>Passport</th>\n' +
                '        <th>Login</th>\n' +
                '        <th>Car</th>\n' +
                '        <th>Car№</th>\n' +
                '        <th>E-mail</th>\n' +
                '        <th>Phone</th>\n' +
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
                '        <th>' + car.car +'</th>\n' +
                '        <th>' + user.car_n +'</th>\n' +
                '        <th>' + user.e_mail +'</th>\n' +
                '        <th>' + user.phone +'</th>\n' +
                '        <td><button onclick="deleteUser(' + user.id + ')">Delete</button></td></tr>';

            document.getElementById("usersList").innerHTML = html;
        }
    };
    https.open("GET", "http://localhost:8080/users/findByPassport?passport=" + passport, true);
    https.send();
}

function deleteUser(userId) {
    let https = new XMLHttpRequest();
    https.open("DELETE", "http://localhost:8080/users/delete/" + userId, true);
    https.send();
}

function createUser() {
    let userUsername = document.getElementById("user_username").value;
    let userSurname = document.getElementById("user_surname").value;
    let userBirth_date = document.getElementById("user_birth_date").value;
    let userGender= document.getElementById("user_gender").value;
    let userPassport= document.getElementById("user_passport").value;
    let userLogin = document.getElementById("user_login").value;
    let userCar_n = document.getElementById("user_car_n").value;
    let userE_mail = document.getElementById("user_e_mail").value;
    let userPhone = document.getElementById("user_phone").value;

    let xhtml = new XMLHttpRequest();
    xhtml.open("POST", "http://localhost:8080/users/save");
    xhtml.setRequestHeader("Content-Type", "application/json");
    xhtml.send(JSON.stringify({
        username: userUsername, surname: userSurname,
        birth_date: userBirth_date, gender: userGender,
        passport: userPassport, login: userLogin, car_n: userCar_n,
        e_mail: userE_mail, phone: userPhone

    }));

    loadUsers();
}

function loadUsers() {

    let https = new XMLHttpRequest();
    https.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let users = JSON.parse(this.responseText);
            let cars = JSON.parse(this.responseText);
            let html = '<tr>\n' +
                '        <th>User №</th>\n' +
                '        <th>Username</th>\n' +
                '        <th>Surname</th>\n' +
                '        <th>Birth_date</th>\n' +
                '        <th>Gender</th>\n' +
                '        <th>Passport</th>\n' +
                '        <th>Login</th>\n' +
                '        <th>Car</th>\n' +
                '        <th>Car№</th>\n' +
                '        <th>E-mail</th>\n' +
                '        <th>Phone</th>\n' +
                '        <th>Delete</th>\n' +
                '    </tr>';
            for (let i = 0; i < users.length; i++) {
                let user = users[i];
                let car = cars[i];
                console.log(user,car);
                let tCar;

                if(car.car!=null){
                    tCar="В аренде";
                }else {
                    tCar="Ожидает обработки!";
                }
                html = html + '<tr><td>' + user.id + '</td>\n' +
                    '        <th>' + user.username + '</th>\n' +
                    '        <th>' + user.surname + '</th>\n' +
                    '        <th>' + user.birth_date + '</th>\n' +
                    '        <th>' + user.gender + '</th>\n' +
                    '        <th>' + user.passport + '</th>\n' +
                    '        <th>' + user.login + '</th>\n' +
                    '        <th>' + tCar + '</th>\n' +
                    '        <th>' + user.car_n + '</th>\n' +
                    '        <th>' + user.e_mail + '</th>\n' +
                    '        <th>' + user.phone + '</th>\n' +
                    '        <td><button onclick="deleteUser(' + user.id + ')">Delete</button></td></tr>';

            }
            document.getElementById("usersList").innerHTML = html;
        }
    };
    https.open("GET", "http://localhost:8080/users/findAll", true);
    https.send();
}
loadUsers();
/*///////////////////////////////////////////////////////////CAR////////////////////////////////////////////////////////*/
    function createCar() {
        let brand = document.getElementById("brand").value;
        let model = document.getElementById("model").value;
        let guarantee_expiration_date = document.getElementById("guarantee_expiration_date").value;
        let price_rent = document.getElementById("price_rent").value;
        let creation = document.getElementById("creation").value;
        let colors = document.getElementById("colors").value;
        let capacity_l = document.getElementById("capacity_l").value;
        let country_of_creation = document.getElementById("country_of_creation").value;
        let rental_access = document.getElementById("rent").value;

        let xhtml = new XMLHttpRequest();
    xhtml.open("POST", "http://localhost:8080/cars/save");
    xhtml.setRequestHeader("Content-Type", "application/json");
        xhtml.send(JSON.stringify({
    brand: brand, model: model, colors: colors,
    guarantee_expiration_date: guarantee_expiration_date, price_rent: price_rent,
    creation: creation, capacity_l: capacity_l, country_of_creation: country_of_creation,
            rent: rental_access
}));

        loadCars();


}

function deleteCar(carId) {
    let https = new XMLHttpRequest();
    https.open("DELETE", "http://localhost:8080/cars/delete/" + carId, true);
    https.send();
}

    function loadCars() {
        let https = new XMLHttpRequest();
        https.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
        let cars = JSON.parse(this.responseText);
        let html = '<tr>\n' +
            '        <th>Car №</th>\n' +
            '        <th>Brand</th>\n' +
            '        <th>Model</th>\n' +
            '        <th>Guarantee expiration date</th>\n' +
            '        <th>Price rent</th>\n' +
            '        <th>Color</th>\n' +
            '        <th>Creation</th>\n' +
            '        <th>Capacity l</th>\n' +
            '        <th>Country of creation</th>\n' +
            '        <th>Rental access</th>\n' +
            '        <th>Delete</th>\n' +
            '    </tr>';
        for (let i = 0; i < cars.length; i++) {

                let car = cars[i];
                    console.log(car);
                html = html + '<tr> <td>' + car.id + '</td>\n' +
                    '        <th>' + car.brand + '</th>\n' +
                    '        <th>' + car.model + '</th>\n' +
                    '        <th>' + car.guarantee_expiration_date + '</th>\n' +
                    '        <th>' + car.price_rent + '</th>\n' +
                    '        <th>' + car.colors + '</th>\n' +
                    '        <th>' + car.creation + '</th>\n' +
                    '        <th>' + car.capacity_l + '</th>\n' +
                    '        <th>' + car.country_of_creation + '</th>\n' +
                    '        <th>' + car.rent + '</th>\n' +
                    '        <td  th:href="cars.html"><button onclick="deleteCar(' + car.id + ')">Delete</button></td></tr>';

                document.getElementById("carList").innerHTML = html;
        }
}
        };
            https.open("GET", "http://localhost:8080/cars/findAll", true);
            https.send();

}
function searchByIdCar() {

    let model = document.getElementById("search_car").value;
    let httpsss1 = new XMLHttpRequest();
    httpsss1.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let car1 = JSON.parse(this.responseText);
                let html = '<tr>\n' +
                    '        <th>Auto №</th>\n' +
                    '        <th>model</th>\n' +
                    '        <th>brand</th>\n' +
                    '        <th>creation</th>\n' +
                    '        <th>guarantee_expiration_date</th>\n' +
                    '        <th>price_rent</th>\n' +
                    '        <th>color</th>\n' +
                    '        <th>capacity_l</th>\n' +
                    '        <th>country_of_creation</th>\n' +
                    '        <th>Rental access</th>\n' +
                    '        <th>Delete</th>\n' +
                    '    </tr>';
                html = html + '<tr>' +
                    '        <td>' + car1.id + '</td>\n' +
                    '        <th>' + car1.model + '</th>\n' +
                    '        <th>' + car1.brand + '</th>\n' +
                    '        <th>' + car1.creation + '</th>\n' +
                    '        <th>' + car1.guarantee_expiration_date + '</th>\n' +
                    '        <th>' + car1.price_rent + '</th>\n' +
                    '        <th>' + car1.colors + '</th>\n' +
                    '        <th>' + car1.capacity_l + '</th>\n' +
                    '        <th>' + car1.country_of_creation + '</th>\n' +
                    '        <th>' + car1.rent + '</th>\n' +
                    '        <td><button onclick="deleteCar(' + car1.id + ')">Delete</button></td></tr>';
                document.getElementById("carList").innerHTML = html;

        }
    };
    httpsss1.open("GET", "http://localhost:8080/cars/findByModel?model=" + model, true);
    httpsss1.send();

    let id = document.getElementById("search_car").value;
    let httpsss2 = new XMLHttpRequest();
    httpsss2.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let car = JSON.parse(this.responseText);
            let html = '<tr>\n' +
                '        <th>Auto №</th>\n' +
                '        <th>model</th>\n' +
                '        <th>brand</th>\n' +
                '        <th>creation</th>\n' +
                '        <th>guarantee_expiration_date</th>\n' +
                '        <th>price_rent</th>\n' +
                '        <th>color</th>\n' +
                '        <th>capacity_l</th>\n' +
                '        <th>country_of_creation</th>\n' +
                '        <th>Rental access</th>\n' +
                '        <th>Delete</th>\n' +
                '    </tr>';
            html = html + '<tr>' +
                '        <td>' + car.id +'</td>\n' +
                '        <th>' + car.model +'</th>\n' +
                '        <th>' + car.brand +'</th>\n' +
                '        <th>' + car.creation +'</th>\n' +
                '        <th>' + car.guarantee_expiration_date +'</th>\n' +
                '        <th>' + car.price_rent +'</th>\n' +
                '        <th>' + car.colors +'</th>\n' +
                '        <th>' + car.capacity_l +'</th>\n' +
                '        <th>' + car.country_of_creation +'</th>\n' +
                '        <th>' + car.rent +'</th>\n' +
                '        <td><button onclick="deleteCar(' + car.id + ')">Delete</button></td></tr>';

            document.getElementById("carList").innerHTML = html;
        }
    };
    httpsss2.open("GET", "http://localhost:8080/cars/findById?id=" + id, true);
    httpsss2.send();

}
loadCars();
///////////////////////////////////////////////////Accident\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
function loadAccident() {
    let httpss = new XMLHttpRequest();
    httpss.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let accidents = JSON.parse(this.responseText);
            let html = '<tr>\n' +
                '        <th>id</th>\n' +
                '        <th>damages</th>\n' +
                '        <th>data_accident</th>\n' +
                '        <th>price_damages</th>\n' +
                '        <th>contract_id</th>' +
                '</tr>';
            for (let i = 0; i < accidents.length; i++) {

                let accident = accidents[i];
                console.log(accident);

                html = html + '<tr> <td>' + accident.id + '</td>\n' +
                    '        <th>' + accident.damages + '</th>\n' +
                    '        <th>' + accident.data_accident + '</th>\n' +
                    '        <th>' + accident.price_damages + '</th>\n' +
                    '        <th>' + accident.contract_id + '</th>\n' +
                '        <td><button onclick="deleteAccident(' + accident.id + ')">Delete</button></td></tr>';


                document.getElementById("accidentsList").innerHTML = html;
            }
        }
    };
    httpss.open("GET", "http://localhost:8080/accidents/findAll", true);
    httpss.send();
}
function deleteAccident(accidentId) {
    let https = new XMLHttpRequest();
    https.open("DELETE", "http://localhost:8080/accidents/delete/" + accidentId, true);
    https.send();
}
    loadAccident();
function createAccident() {
    let damages = document.getElementById("damages").value;
    let data_accident = document.getElementById("data_accident").value;
    let price_damages = document.getElementById("price_damages").value;
    let contract_id = document.getElementById("contract_id").value;

    let xhtml = new XMLHttpRequest();
    xhtml.open("POST", "http://localhost:8080/accidents/save");
    xhtml.setRequestHeader("Content-Type", "application/json");
    xhtml.send(JSON.stringify({
        damages: damages, data_accident: data_accident,
        price_damages: price_damages, contract_id: contract_id
    }));

    loadAccident();

}
function searchByIdA() {
    let id = document.getElementById("search_accidents").value;
    let httpss = new XMLHttpRequest();
    httpss.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let accidents = JSON.parse(this.responseText);
            let html = '<tr>\n' +
                '        <th>Accident №</th>\n' +
                '        <th>damages</th>\n' +
                '        <th>data_accident</th>\n' +
                '        <th>price_damages</th>\n' +
                '        <th>contract_id</th>\n' +
                '    </tr>';
            html = html + '<tr>' +
                '        <td>' + accidents.id +'</td>\n' +
                '        <th>' + accidents.damages +'</th>\n' +
                '        <th>' + accidents.data_accident +'</th>\n' +
                '        <th>' + accidents.price_damages +'</th>\n' +
                '        <th>' + accidents.contract_id +'</th>\n' +
                '        <td><button onclick="deleteUser(' + accidents.id + ')">Delete</button></td></tr>';

            document.getElementById("accidentsList").innerHTML = html;
        }
    };
    httpss.open("GET", "http://localhost:8080/users/findById?id=" + id, true);
    httpss.send();
}
////////////////////////////////////////////////Contract\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
function loadContract() {
    let htt = new XMLHttpRequest();
    htt.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let contracts = JSON.parse(this.responseText);
            let accident = JSON.parse(this.responseText);

            let html = '<tr>\n' +
                '        <th>id</th>\n' +
                '        <th>name_contract</th>\n' +
                '        <th>time_rent_start</th>\n' +
                '        <th>time_rent_end</th>\n' +
                '        <th>car_id</th>' +
                '        <th>user_id</th>' +
                '        <th>DELETE</th>' +
                '</tr>';
            for (let i = 0; i < contracts.length; i++) {
                let contract = contracts[i];
                console.log(contract);

                html = html + '<tr> <td>' + contract.id + '</td>\n' +
                    '        <th>' + contract.name_contract + '</th>\n' +
                    '        <th>' + contract.time_rent_start + '</th>\n' +
                    '        <th>' + contract.time_rent_end + '</th>\n' +
                    '        <th>' + contract.car_id + '</th>\n' +
                    '        <th>' + contract.user_id + '</th>\n' +
                    '        <td><button onclick="deleteContract(' + contract.id + ')">Delete</button></td></tr>';

                document.getElementById("contractsList").innerHTML = html;
            }
        }
    };
    htt.open("GET", "http://localhost:8080/contracts/findAll", true);
    htt.send();
}
loadContract();
function deleteContract(contractId) {
    let https = new XMLHttpRequest();
    https.open("DELETE", "http://localhost:8080/contracts/delete/" + contractId, true);
    https.send();
}
function createContract() {
    let name_contract = document.getElementById("name_contract").value;
    let time_rent_start = document.getElementById("time_rent_start").value;
    let time_rent_end = document.getElementById("time_rent_end").value;
    let car_id = document.getElementById("car_id").value;
    let user_id = document.getElementById("user_id").value;


            let xhtml = new XMLHttpRequest();
            xhtml.open("POST", "http://localhost:8080/contracts/save");
            xhtml.setRequestHeader("Content-Type", "application/json");
            xhtml.send(JSON.stringify({
                name_contract: name_contract, time_rent_start: time_rent_start,
                time_rent_end: time_rent_end, car_id: car_id, user_id: user_id
            }));
}
function searchByContract() {
    let id = document.getElementById("search_contract").value;
    let htt = new XMLHttpRequest();

    htt.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let contracts = JSON.parse(this.responseText);
            let accident = JSON.parse(this.responseText);
            let html = '<tr>\n' +
                '        <th>Contract №</th>\n' +
                '        <th>name_contract</th>\n' +
                '        <th>time_rent_start</th>\n' +
                '        <th>time_rent_end</th>\n' +
                '        <th>car_id</th>\n' +
                '        <th>user_id</th>\n' +
                '        <th>Delete</th>\n' +
                '    </tr>';
            html = html + '<tr>' +
                '        <td>' + contracts.id +'</td>\n' +
                '        <th>' + contracts.name_contract +'</th>\n' +
                '        <th>' + contracts.time_rent_start +'</th>\n' +
                '        <th>' + contracts.time_rent_end +'</th>\n' +
                '        <th>' + contracts.car_id +'</th>\n' +
                '        <th>' + contracts.user_id +'</th>\n' +
                '        <td><button onclick="deleteContract(' + contracts.id + ')">Delete</button></td></tr>';

            document.getElementById("contractsList").innerHTML = html;
        }
    };
    htt.open("GET", "http://localhost:8080/contracts/findById?id=" + id, true);
    htt.send();
}
/////////////////////////////////////////////////////////////ROLE\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
function findByLogin() {
    let name = document.getElementById("name_role").value;
    let role = document.getElementById("name_role").value;
    let https1 = new XMLHttpRequest();

    https1.open("GET", "http://localhost:8080/login/role?findByLogin=" + name,role);
    https1.send();
}