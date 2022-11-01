//---------------------------------------------------------------------
const fechaInput = document.querySelector('#fechaGuia');
function deshabilitarFechaAnterior() {
    
    const fecha= new Date()
    let texto = fecha.toLocaleDateString("sv-SE")

    

    fechaInput.setAttribute('min',texto)
    console.log(texto);
}
fechaInput.addEventListener('click',deshabilitarFechaAnterior);

//SOLO LETRAS INPUT//
function sololetras(e){
    key=e.keyCode || e.which;
    teclado=String.fromCharCode(key).toLowerCase();
    letras=" abcdefghijklmnñopqrstuvwxyz";
    especiales="8-37-38-46-164";
    teclado_especial=false;

for(var i in especiales){
    if(key==especiales[i]){
        teclado_especial=true;break;
    }
}

if(letras.indexOf(teclado)==-1 && !teclado_especial){
    return false;
}

}