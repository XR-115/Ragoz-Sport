//----------------------------------ALERTAS PARA MÓDULO DE ENVÍO----------------------------------//

//--------------------EDITAR---------------------//


const editarEnvio=()=>{
 
  const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
      confirmButton: 'btn btn-success',
      cancelButton: 'btn btn-danger'
    },
    buttonsStyling: false
  })
  
  swalWithBootstrapButtons.fire({
    title: '¿Está seguro de que desea editar?',
    text: "¿Usted va a editar este método de pago?",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Si, editalo',
    cancelButtonText: 'No, cancelar',
    reverseButtons: true
  }).then((result) => {
    if (result.isConfirmed) {
      swalWithBootstrapButtons.fire(
        'Editando',
        'Su método de pago se va a editar',
        'success'
      )
    } else if (
      window.location.href=`/ragoz/envio/envio`
    ) {
  
      
    }
  })


}
//--------------------BORRAR---------------------//
function borrarEnvio(idEnvio) {
  let id=idEnvio;
  Swal.fire({
      title: '¿Está usted seguro?',
      text: "No podrás revertir el cambio",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, ¡Borralo!'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          '¡Borrado!',
          'Your file has been deleted.',
          'success'

        )
        window.location.href=`deleteEn/${id}`
        }
        
    })
}

//----------------------------------ALERTAS PARA MÓDULO DE PAGO----------------------------------//

//--------------------EDITAR---------------------//
const editarPago=()=>{

const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: '¿Está seguro de que desea editar?',
  text: "¿Usted va a editar este método de pago?",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonText: 'Si, editalo',
  cancelButtonText: 'No, cancelar',
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
    swalWithBootstrapButtons.fire(
      'Editando',
      'Su método de pago se va a editar',
      'success'
    )
  } else if (
    window.location.href=`/ragoz/pago/pago`
  ) {
  }
})

}

//
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
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: '¿Está seguro de que desea editar?',
  text: "¿Usted va a editar este método de pago?",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonText: 'Si, editalo',
  cancelButtonText: 'No, cancelar',
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
    swalWithBootstrapButtons.fire(
      'Editando',
      'Su método de pago se va a editar',
      'success'
    )
  } else if (
    window.location.href=`/ragoz/producto/producto`
  ) {
  }
})

}


//-------------------------------------- ALERTAS PARA MÓDULO DE USUARIOS ----------------------------------//

//-------------Actualizar-------------//
const editarUsuario=()=>{

const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: '¿Está seguro de que desea editar?',
  text: "¿Usted va a editar este método de pago?",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonText: 'Si, editalo',
  cancelButtonText: 'No, cancelar',
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
    swalWithBootstrapButtons.fire(
      'Editando',
      'Su método de pago se va a editar',
      'success'
    )
  } else if (
    window.location.href=`/ragoz/usuario/usuario`
  ) {
  }
})

}

//-------------------------------------- ALERTAS PARA MÓDULO DE PEDIDO ----------------------------------//
const editarPedido=()=>{

const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: '¿Está seguro de que desea editar?',
  text: "¿Usted va a editar este método de pago?",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonText: 'Si, editalo',
  cancelButtonText: 'No, cancelar',
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
    swalWithBootstrapButtons.fire(
      'Editando',
      'Su método de pago se va a editar',
      'success'
    )
  } else if (
    window.location.href=`/ragoz/pedido/pedido`
  ) {
  }
})

}

//-------------------------------------- ALERTAS PARA MÓDULO DE PEDIDO ----------------------------------//

const editarGuia=()=>{

  const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
      confirmButton: 'btn btn-success',
      cancelButton: 'btn btn-danger'
    },
    buttonsStyling: false
  })
  
  swalWithBootstrapButtons.fire({
    title: '¿Está seguro de que desea editar?',
    text: "¿Usted va a editar este método de pago?",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Si, editalo',
    cancelButtonText: 'No, cancelar',
    reverseButtons: true
  }).then((result) => {
    if (result.isConfirmed) {
      swalWithBootstrapButtons.fire(
        'Editando',
        'Su método de pago se va a editar',
        'success'
      )
    } else if (
      window.location.href=`/ragoz/guia/listar`
    ) {
    }
  })
  
  }