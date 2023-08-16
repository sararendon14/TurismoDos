package org.example.validaciones;

import org.example.utilidades.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class       UsuarioValidacionTest {


   private UsuarioValidacion usuarioValidacion;

  @BeforeEach
   public void setUp(){
      this.usuarioValidacion = new UsuarioValidacion();

   }
   @Test

   public void validarNombreUsuarioCorrecto (){
         String nombreValido = "Juan Jose Gallego Mesa"; // preparando
      //2 y 3 Ejecutar y verificar
     Assertions.assertDoesNotThrow(()->usuarioValidacion.validarNombre(nombreValido));
   }

   @Test

   public void validarNombreUsuarioIncorrecto () {

      String nombreInvalido =" Juan 1203 Gallego Mesa "; //Preparando
       //Ejecuto y verifico
       Exception exception = Assertions.assertThrows(Exception.class,()->usuarioValidacion.validarNombre(nombreInvalido));
       Assertions.assertEquals(Mensajes.NOMBRE_SOLO_LETRAS.getMensaje(),exception.getMessage());

   }

    @Test

    public void validarCorreoCorrecto (){


      String correoValido ="Juancamilo@gmail.com";

     Assertions.assertDoesNotThrow(()->usuarioValidacion.validarCorreoElectronico(correoValido));
    }
    @Test
    public void validarCorreoIncorrecto () {

        String correoIncorrecto =" Juan123.es"; //Preparando
        //Ejecuto y verifico
        Exception exception = Assertions.assertThrows(Exception.class,()->usuarioValidacion.validarCorreoElectronico(correoIncorrecto));
        Assertions.assertEquals(Mensajes.CORREO_INVALIDO.getMensaje(),exception.getMessage());

    }

    @Test

    public void validarUbicacionCorrecta (){

      Integer ubicacionCorrecta = 3;
      Assertions.assertDoesNotThrow(()->usuarioValidacion.validarUbicacion(ubicacionCorrecta));
    }

    @Test

    public void validarUbicacionIncorrecta (){
      Integer ubicacionIncorrecta = 5;
      Exception exception = Assertions.assertThrows(Exception.class, ()->usuarioValidacion.validarUbicacion(ubicacionIncorrecta));
        Assertions.assertEquals(Mensajes.ZONA_INVALIDA.getMensaje(),exception.getMessage());
    }
}

