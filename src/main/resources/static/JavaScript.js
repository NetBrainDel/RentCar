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
                '        <td><button onclick="deleteUser(' + user.id + ')">Delete</button></td></tr>',

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





    let xhtml = new XMLHttpRequest();   // new HttpRequest instance
    xhtml.open("POST", "http://localhost:8080/users/save");
    xhtml.setRequestHeader("Content-Type", "application/json");
    xhtml.send(JSON.stringify({
        username: userUsername, surname: userSurname,
        birth_date: userBirth_date, gender: userGender,
        passport: userPassport, login: userLogin, car_n:userCar_n
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
                '        <th>Delete</th>\n' +
                '    </tr>';
            for (let i = 0; i < users.length; i++) {
                let user = users[i];
                let car = cars[i];
                console.log(user,car);
                html = html + '<tr><td>' + user.id + '</td>\n' +
                    '        <th>' + user.username + '</th>\n' +
                    '        <th>' + user.surname + '</th>\n' +
                    '        <th>' + user.birth_date + '</th>\n' +
                    '        <th>' + user.gender + '</th>\n' +
                    '        <th>' + user.passport + '</th>\n' +
                    '        <th>' + user.login + '</th>\n' +
                    '        <th>' + car.car + '</th>\n' +
                    '        <th>' + user.car_n + '</th>\n' +
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
        let capacity_l = document.getElementById("capacity_l").value;
        let country_of_creation = document.getElementById("country_of_creation").value;
        let rental_access = document.getElementById("rent").value;

        let xhtml = new XMLHttpRequest();   // new HttpRequest instance
    xhtml.open("POST", "http://localhost:8080/cars/save");
    xhtml.setRequestHeader("Content-Type", "application/json");
    xhtml.send(JSON.stringify({
    brand: brand, model: model,
    guarantee_expiration_date: guarantee_expiration_date, price_rent: price_rent,
    creation: creation, capacity_l: capacity_l, country_of_creation: country_of_creation, rent : rental_access
}));

        loadCars();

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

            '    </tr>';
        for (let i = 0; i < cars.length; i++) {
            let car = cars[i];
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
    '        <th>' + car.rent  + '</th>\n' +
    '</tr>';

}
            document.getElementById("carList").innerHTML = html;
}
};
    https.open("GET", "http://localhost:8080/cars/findAll", true);
    https.send();
}
loadCars();
