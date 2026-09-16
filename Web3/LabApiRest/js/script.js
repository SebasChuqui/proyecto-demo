function BuscarAlbumUsuario() {
    let Id = document.getElementById("idUsuario").value;
    fetch(`https://jsonplaceholder.typicode.com/albums?userId=${Id}`)
        .then(response => response.json())
        .then(data => {
            let listaAlbum = document.getElementById("ListaAlbum");
            listaAlbum.innerHTML = "";
            data.forEach(element => {
                let item = document.createElement("li");
                item.textContent = element.id + " - " + element.title;
                listaAlbum.appendChild(item);
            });
        })
        .catch(error => {
            console.log(error);
        });
}
function BuscarComentariosPost() {
    let Id = document.getElementById("idPost").value;
    fetch(`https://jsonplaceholder.typicode.com/comments?postId=${Id}`)
        .then(response => response.json())
        .then(data => {
            let listaComentarios = document.getElementById("ListaComentarios");
            listaComentarios.innerHTML = "";
            data.forEach(element => {
                let item = document.createElement("li");
                item.innerHTML = `
                    <strong>id:</strong> ${element.id}<br>
                    <strong>email:</strong> ${element.email}<br>
                    <strong>comentario:</strong> ${element.body}
                `;
                listaComentarios.appendChild(item);
            });
        })
        .catch(error => {
            console.log(error);
        });
}