fetch("https://jsonplaceholder.typicode.com/users")
    .then(response => response.json())
    .then(data => {
        let lista = document.getElementById("listausuarios");
        lista.innerHTML = "";

        for (let i = 0; i < data.length; i++) {
            let item = document.createElement("li");
            item.textContent = data[i].name + " - " + data[i].username + " - " + data[i].email + " - " + data[i].address.zipcode;
            lista.appendChild(item);
        }
        console.log(data);
    })

    .catch(error => {
        console.log(error);
    });

function mostrarTabla() {
    fetch("https://jsonplaceholder.typicode.com/users")
        .then(response => response.json())
        .then(data => {
            let cuerpo = document.getElementById("datosTabla");
            for (let i = 0; i < data.length; i++) {
                let fila = document.createElement("tr");
                let celda1 = document.createElement("td");
                celda1.textContent = data[i].name;
                let celda2 = document.createElement("td");
                celda2.textContent = data[i].username;
                fila.appendChild(celda1);
                fila.appendChild(celda2);
                cuerpo.appendChild(fila);
            }
        })
        .catch(error => {
            console.log(error);
        });
}

function limpiarTabla() {
    let cuerpo = document.getElementById("datosTabla");
    cuerpo.innerHTML = "";
    console.log("Tabla limpiada!");
}

function mostrarDatosTabla() {
    fetch("https://jsonplaceholder.typicode.com/users")
        .then(response => response.json())
        .then(data => {
            let cuerpo = document.getElementById("datosTabla");
            for (let i = 0; i < data.length; i++) {
                cuerpo.innerHTML += `<tr><td>${data[i].name}</td><td>${data[i].username}</td></tr>`;
            }
        })
        .catch(error => {
            console.log(error);
        });
}

function mostrarUsuario() {
    let id = document.getElementById("idUsuario").value;
    fetch("https://jsonplaceholder.typicode.com/users/" + id)
        .then(response => response.json())
        .then(data => {
            let usuario = document.getElementById("datosUsuario");
            usuario.textContent = data.name + " - " + data.username;

        })
        .catch(error => {
            console.log(error);
        });
}

function mostrarPosts() {
    fetch("https://jsonplaceholder.typicode.com/posts")
        .then(response => response.json())
        .then(data => {
            let cuerpo = document.getElementById("datosPosts");
            cuerpo.innerHTML = "";
            for (let i = 0; i < data.length; i++) {
                let fila = document.createElement("tr");
                let celda1 = document.createElement("td");
                celda1.textContent = data[i].id;
                let celda2 = document.createElement("td");
                celda2.textContent = data[i].title;
                fila.appendChild(celda1);
                fila.appendChild(celda2);
                cuerpo.appendChild(fila);
            }
        })
        .catch(error => {
            console.log(error);
        });
}

function buscarPost() {
    let id = document.getElementById("idPost").value;
    fetch("https://jsonplaceholder.typicode.com/posts/" + id)
        .then(response => response.json())
        .then(data => {
            let post = document.getElementById("datosPost");
            post.innerHTML = "id: " + data.id + "<br>" +
                "title: " + data.title + "<br>" +
                "body: " + data.body;
        })
        .catch(error => {
            console.log(error);
        });
}