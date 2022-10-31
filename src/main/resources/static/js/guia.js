//---------------------------------------------------------------------
const fechaInput = document.querySelector('#fechaGuia');
function deshabilitarFechaAnterior() {
    
    const fecha= new Date()
    let texto = fecha.toLocaleDateString("sv-SE")

    

    fechaInput.setAttribute('min',texto)
    console.log(texto);
}
fechaInput.addEventListener('click',deshabilitarFechaAnterior);