var checkbox = document.getElementById('mostrar');
var row = document.querySelectorAll('#tablerow');
var estado = document.querySelectorAll('#estado');

checkbox.addEventListener("click",mostrar)
      
if (checkbox.checked==false) {
    for (let index = 0; index < estado.length; index++) {
        if (estado[index].textContent=="Inactivo") {
            for (let index = 0; index < row.length; index++) {
              if (estado[index].textContent=="Inactivo") {
                row[index].setAttribute('style','display:none');
              }
            }
        }
        console.log(estado[index].textContent)
    }
}
      
function mostrar(){
    if (checkbox.checked==true) {
        for (let index = 0; index < estado.length; index++) {
            if (estado[index].textContent=="Inactivo") {
              for (let index = 0; index < row.length; index++) {
                if (estado[index].textContent=="Inactivo") {
                  row[index].setAttribute('style','display:');
                }
              }
            }
        }
    }else if (checkbox.checked==false){
        for (let index = 0; index < estado.length; index++) {
            if (estado[index].textContent=="Inactivo") {
              for (let index = 0; index < row.length; index++) {
                if (estado[index].textContent=="Inactivo") {
                  row[index].setAttribute('style','display:none');
                }
              }
            }
        }
    }
}