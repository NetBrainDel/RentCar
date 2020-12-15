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
                '        <th>User car</th>\n' +
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