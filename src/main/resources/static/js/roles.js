//-----------------------------------------LIMITACIÓN REGISTRAR ROL----------------------------//
const rol = document.getElementById('roles')

let rolesBloq = () =>{
    let rolBloq = rol.options[rol.selectedIndex].text

        rol.options[1].setAttribute('hidden','')
    

    }

    rol.addEventListener('mousedown',rolesBloq)