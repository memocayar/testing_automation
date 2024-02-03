#language:es

Característica: Crear cuenta en opencart

  #Completar las acciones necesarias
  Escenario: Crear una cuenta no registrada en el sitio
    Dado un usuario que se encuentra en la home page
    Cuando navega a la pagina de registro
    Y completa el formulario con sus datos:
      | nombre             | Emilia  4           |
      | apellido           | ApellidoEjemplo  4  |
      | email              | emilia4@example.com |
      | telefono           | 1234567894          |
      | password           | contraseña1234      |
      | confirmar_password | contraseña1234      |
    Y habiendo aceptado los terminos y condiciones presiona enviar
    Entonces valido creación exitosa