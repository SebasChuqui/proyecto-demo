const formulario = document.querySelector("#formRegistro");
const mensaje = document.querySelector("#mensaje");
formulario.addEventListener("submit", function (evento) {
 evento.preventDefault();
 const nombre = document.querySelector("#nombre").value;
 mensaje.textContent = `Registro realizado para ${nombre}`;
 formulario.reset();
});
