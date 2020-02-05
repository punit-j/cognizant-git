var userList = [];
var index = 0;
var form = document.querySelector("form");
var idOrder = "ascending", nameOrder = "", uNameOrder = "", emailOrder = "", companyOrder = "";

function handleForm(event) { event.preventDefault(); }
form.addEventListener('submit', handleForm);

fetchUser();

function fetchUser() {
    fetch("https://jsonplaceholder.typicode.com/users")
        .then(response => response.json())
        .then((json) => {
            userList.push(json)
            userList = userList[0];
            iterateList(userList);
        })
}

function iterateList(userList) {
    var list = "";
    for (i = 0; i < userList.length; i++) {
        list += `<tr> <td> ${userList[i].id} </td> <td> ${userList[i].name} </td> <td> ${userList[i].username} </td> <td> ${userList[i].email} </td> 
            <td> ${userList[i].company.name} </td> <td><button class="edit-btn" onclick="editUserDialogBox(${i})">edit</button><button class="delete-btn" onclick = "deleteUser(${i})">delete</button> </td></tr>`;
    }
    document.getElementById("tableBody").innerHTML = list;

}

function editUserDialogBox(index) {
    document.querySelector("form").style.display = 'grid';
    document.getElementById("blur-background").style.filter = 'blur(3px)';
    var userToEdit = userList[index]
    document.getElementById("id").value = userToEdit.id;
    document.getElementById("name").value = userToEdit.name;
    document.getElementById("userName").value = userToEdit.username;
    document.getElementById("email").value = userToEdit.email;
    document.getElementById("company").value = userToEdit.company.name;
    this.index = index;
}

function deleteUser(index) {
    fetch(`https://jsonplaceholder.typicode.com/users/${index + 1}`, {
        method: 'DELETE'
    }).then(json => {
        document.querySelector("#success-msg p").innerHTML = "User deleted successfully";
        document.querySelector("#success-msg p").style.display = 'block';
        setTimeout(function () { document.querySelector("#success-msg p").style.display = 'none'; }, 5000);
    })
    userList.splice(index, 1);
    iterateList(userList);
}

function cancelEdit() {
    document.querySelector("form").style.display = 'none';
    document.getElementById("userTable").style.display = 'inline-table';
    document.getElementById("blur-background").style.filter = 'blur(0px)';
}

function editUser() {
    var id = document.getElementById("id").value;
    var user = {
        id: document.getElementById("id").value,
        name: document.getElementById("name").value,
        username: document.getElementById("userName").value,
        email: document.getElementById("email").value,
        company: { name: document.getElementById("company").value }
    }
    if (id == "") {
        document.querySelector("#id-msg p").style.display = "block";
        setTimeout(function () { document.querySelector("#id-msg p").style.display = 'none'; }, 5000);
    }
    if (user.name == "") {
        document.querySelector("#name-msg p").style.display = "block";
        setTimeout(function () { document.querySelector("#name-msg p").style.display = 'none'; }, 5000);
    }
    if (user.username == "") {
        document.querySelector("#username-msg p").style.display = "block";
        setTimeout(function () { document.querySelector("#username-msg p").style.display = 'none'; }, 5000);
    }
    if (user.email == "") {
        document.querySelector("#email-msg p").style.display = "block";
        setTimeout(function () { document.querySelector("#email-msg p").style.display = 'none'; }, 5000);
    }
    if (user.company.name == "") {
        document.querySelector("#company-msg p").style.display = "block";
        setTimeout(function () { document.querySelector("#company-msg p").style.display = 'none'; }, 5000);
    }
    if (id != "" && user.name != "" && user.username != "" && user.email != "" && user.company.name != "") {
        var table = document.getElementById("tableBody");
        var firstrow = table.insertRow(index);
        var cell01 = firstrow.insertCell(0);
        var cell02 = firstrow.insertCell(1);
        var cell03 = firstrow.insertCell(2);
        var cell04 = firstrow.insertCell(3);
        var cell05 = firstrow.insertCell(4);
        var cell06 = firstrow.insertCell(5);

        cell01.innerHTML = user.id;
        cell02.innerHTML = user.name;
        cell03.innerHTML = user.username;
        cell04.innerHTML = user.email;
        cell05.innerHTML = user.company.name;
        cell06.innerHTML = `<button class="edit-btn" onclick="editUserDialogBox(${index})">edit</button><button class="delete-btn" onclick = "deleteUser(${index})">delete</button>`;
        userList[index] = user;
        cancelEdit();
        fetch(`https://jsonplaceholder.typicode.com/users/${id}`, {
            method: `PUT`,
            body: JSON.stringify(user)
        })
            .then(response => {
                document.querySelector("#success-msg p").innerHTML = "User edited successfully";
                document.getElementById("success-msg").style.display = 'block';
                setTimeout(function () { document.getElementById("success-msg").style.display = 'none'; }, 5000);
            })
    }
}

function sortTable(basis) {
    if (basis == "id" && idOrder == "ascending") {
        userList.sort(function (a, b) {
            return b.id - a.id;
        })
        idOrder = "descending";
    } else if (basis == "id" && idOrder == "descending") {
        userList.sort(function (a, b) {
            return a.id - b.id;
        })
        idOrder = "ascending";
    } else if (basis == "name") {
        if (nameOrder == "" || nameOrder == "descending") {
            userList.sort(function (a, b) {
                return a.name.localeCompare(b.name);
            })
            nameOrder = "ascending";
        } else if (nameOrder == "ascending") {
            userList.sort(function (a, b) {
                return b.name.localeCompare(a.name);
            })
            nameOrder = "descending";
        }
    } else if (basis == "username") {
        if (uNameOrder == "" || uNameOrder == "descending") {
            userList.sort(function (a, b) {
                return a.username.localeCompare(b.username);
            })
            uNameOrder = "ascending";
        } else if (uNameOrder == "ascending") {
            userList.sort(function (a, b) {
                return b.username.localeCompare(a.username);
            })
            uNameOrder = "descending";
        }
    } else if (basis == "email") {
        if (emailOrder == "" || emailOrder == "descending") {
            userList.sort(function (a, b) {
                return a.email.localeCompare(b.email);
            })
            emailOrder = "ascending";
        } else if (emailOrder == "ascending") {
            userList.sort(function (a, b) {
                return b.email.localeCompare(a.email);
            })
            emailOrder = "descending";
        }
    } else if (basis == "company") {
        if (companyOrder == "" || companyOrder == "descending") {
            userList.sort(function (a, b) {
                return a.company.name.localeCompare(b.company.name);
            })
            companyOrder = "ascending";
        } else if (companyOrder == "ascending") {
            userList.sort(function (a, b) {
                return b.company.name.localeCompare(a.company.name);
            })
            companyOrder = "descending";
        }
    }
    iterateList(userList);
}