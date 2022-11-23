//----------------------------------ALERTAS PARA MÓDULO DE ENVÍO----------------------------------//

//--------------------EDITAR---------------------//


const editarEnvio=()=>{
 
  const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
      confirmButton: 'btn btn-info',
      cancelButton: 'btn btn-danger'
    },
    buttonsStyling: false
  })
  
  swalWithBootstrapButtons.fire({
    title: '¿Está seguro de que desea editar?',
    text: "¿Usted va a editar este envío?",
    icon: 'question',
    showCancelButton: true,
    confirmButtonText: 'Si, editalo',
    cancelButtonText: 'No, cancelar',
    reverseButtons: true
  }).then((result) => {
    if (result.isConfirmed) {
      swalWithBootstrapButtons.fire(
        'Editando',
        'Su envío se va a editar',
        'success'
      )
    } else if (
      window.location.href=`/ragoz/envio/envio`
    ) {
  
      
    }
  })


}






//--------------------BORRAR---------------------//
function borrarPago(idPago) {
  let id=idPago;
  Swal.fire({
      title: '¿Está usted seguro?',
      text: "No podrás revertir el cambio",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Si, ¡Borralo!'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          '¡Borrado!',
          'Su método de pago fué eliminado.',
          'Hecho'

        )
        window.location.href=`deleteP/${id}`
        }
        
    })
}
//-------------------------------------- ALERTAS PARA MÓDULO DE PRODUCTO ----------------------------------//

//--------------------EDITAR---------------------//
const editarProducto=()=>{

const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn btn-info',
    cancelButton: 'btn btn-danger'  
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: '¿Está seguro de que desea editar?',
  text: "¿Usted va a editar este producto?",
  icon: 'question',
  showCancelButton: true,
  confirmButtonText: 'Si, editalo',
  cancelButtonText: 'No, cancelar',
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
    swalWithBootstrapButtons.fire(
      'Editando',
      'Su producto se va a editar',
      'success'
    )
  } else if (
    window.location.href=`/ragoz/producto/listar`
  ) {
  }
})

}

//-------------------------------------- ALERTAS PARA MÓDULO DE PEDIDO ----------------------------------//
const editarPedido=()=>{

  const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
      confirmButton: 'btn btn-info',
      cancelButton: 'btn btn-danger'
    },
    buttonsStyling: false
  })
  
  swalWithBootstrapButtons.fire({
    title: '¿Está seguro de que desea editar?',
    text: "¿Usted va a editar este pedido?",
    icon: 'question',
    showCancelButton: true,
    confirmButtonText: 'Si, editalo',
    cancelButtonText: 'No, cancelar',
    reverseButtons: true
  }).then((result) => {
    if (result.isConfirmed) {
      swalWithBootstrapButtons.fire(
        'Editando',
        'Su pedido se va a editar',
        'success'
      )
    } else if (
      window.location.href=`/ragoz/pedido/listar`
    ) {
    }
  })
  
  }


//-------------------------------------- ALERTAS PARA MÓDULO DE USUARIOS ----------------------------------//

//-------------Actualizar-------------//
const editarUsuario=()=>{

const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn btn-info',  
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: '¿Está seguro de que desea editar?',
  text: "¿Usted va a editar este usuario?",
  icon: 'question',
  showCancelButton: true,
  confirmButtonText: 'Si, editalo',
  cancelButtonText: 'No, cancelar',
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
    swalWithBootstrapButtons.fire(
      'Editando',
      'Su usuario se va a editar',
      'success'
    )
  } else if (
    
    window.location.href=`/ragoz/usuario/usuario`
  ) {
  }
})

}



//-------------------------------------- ALERTAS PARA MÓDULO DE GUÍA ----------------------------------//

const editarGuia=()=>{

  const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
      confirmButton: 'btn btn-info',
      cancelButton: 'btn btn-danger'
    },
    buttonsStyling: false
  })
  
  swalWithBootstrapButtons.fire({
    title: '¿Está seguro de que desea editar?',
    text: "¿Usted va a editar esta guía?",
    icon: 'question',
    showCancelButton: true,
    confirmButtonText: 'Editar',
    cancelButtonText: 'Cancelar',
    reverseButtons: true
  }).then((result) => {
    if (result.isConfirmed) {
      swalWithBootstrapButtons.fire(
        'Editando',
        'Su guía se editará',
        'success'
      )
    } else if (
      window.location.href=`/ragoz/guia/listar`
    ) {
    }
  })
  
  }

  //-------------------------------------- ALERTAS PARA MÓDULO DE Novedades----------------------------------//

const editarNovedades=()=>{

  const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
      confirmButton: 'btn btn-info',
      cancelButton: 'btn btn-danger'
    },
    buttonsStyling: false
  })
  
  swalWithBootstrapButtons.fire({
    title: '¿Está seguro de que desea editar?',
    text: "¿Usted va a editar esta novedad?",
    icon: 'question',
    showCancelButton: true,
    confirmButtonText: 'Editar',
    cancelButtonText: 'Cancelar',
    reverseButtons: true
  }).then((result) => {
    if (result.isConfirmed) {
      swalWithBootstrapButtons.fire(
        'Editando',
        'Su novedad se editará',
        'success'
      )
    } else if (
      window.location.href=`/ragoz/novedades/novedades`
    ) {
    }
  })
  
  }