#language:es

Característica: Login en opencart

  Escenario: Realizar login con un usuario registrado
    Dado un usuario que se encuentra en la home page
    Cuando navega a la pagina de login
    E inicia sesion con usuario "prueba9001@prueba.com" y contrasenia "1234"
    Entonces el usuario se encuentra en la account page