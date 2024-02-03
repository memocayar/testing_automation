#language:es

Característica: Crear cuenta en opencart

  #Completar las acciones necesarias
  Escenario: Crear una cuenta no registrada en el sitio
    Dado un usuario que se encuentra en la home page
    Cuando navega a la pagina de registro
    Y completa el formulario con sus datos:
      | nombre             | Emilia  3           |
      | apellido           | ApellidoEjemplo  3  |
      | email              | emilia3@example.com |
      | telefono           | 1234567893          |
      | password           | contraseña1233      |
      | confirmar_password | contraseña1233      |
    Y habiendo aceptado los terminos y condiciones presiona enviar
    Entonces valido creación exitosa