#language:es

Característica: Agregar a favoritos en opencart

  #Completar las acciones necesarias
  Escenario: Agregar un item a favoritos
    Dado un usuario que realizó login con usuario "prueba9001@prueba.com" y contrasenia "1234"
    Cuando el usuario navega a la pagina de cameras
    Y agrego "Canon EOS 5D" a favoritos
    Y el usuario navega a la Wish List
    Entonces valido que se encuentre "Canon EOS 5D"