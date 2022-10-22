const costo = document.getElementById('costoTotalEnvios')

let metodopago = () => {

    const costos = parseFloat(document.getElementById('costoTotalEnvios').value)
    const pago = document.getElementById('metodoPago')

    let elegido = pago.options[pago.selectedIndex].text
    console.log (elegido)
    

    if (costos<48000) {

        pago.options[0].setAttribute('disabled','')
        pago.options[2].setAttribute('disabled','')
        pago.options[3].setAttribute('disabled','')
        pago.options[4].setAttribute('disabled','')
        pago.options[5].setAttribute('disabled','')
        alert("Debes tener un costo mayor a 48.000 para usar todos los métodos de pago")
    } else {
        pago.options[0].removeAttribute('disabled','')
        pago.options[1].removeAttribute('disabled','')
        pago.options[2].removeAttribute('disabled','')
        pago.options[3].removeAttribute('disabled','')
        pago.options[4].removeAttribute('disabled','')
    }
    console.log(costos);
}



costo.addEventListener('blur',metodopago);

//-----------------------------------------CREACIÓN FECHA MÍNIMA----------------------------//
const fechaInput = document.querySelector('#fechaEnvio');
function deshabilitarFechaAnterior() {
    
    const fecha= new Date()
    let texto = fecha.toLocaleDateString("sv-SE")

    

    fechaInput.setAttribute('min',texto)
    console.log(texto);
}
fechaInput.addEventListener('click',deshabilitarFechaAnterior);





