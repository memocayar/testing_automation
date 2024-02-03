#language:es

Característica: Agregar items al carrito en opencart

  #Completar las acciones necesarias
  Escenario: Agregar un item al carrito
    Dado un usuario que realizó login con usuario "prueba9001@prueba.com" y contrasenia "1234"
    Cuando el usuario navega a cameras
    Y en el producto "Canon EOS 5D" hace click en agregar al carrito
    Y agrega la opcion "Red"
    Entonces valido que se encuentre "Canon EOS 5D" en el carrito