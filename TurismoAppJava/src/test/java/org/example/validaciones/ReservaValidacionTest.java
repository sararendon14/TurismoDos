package org.example.validaciones;

import org.example.utilidades.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservaValidacionTest {

    private ReservaValidacion reservaValidacion;

    @BeforeEach

    public void setUp (){
            this.reservaValidacion = new ReservaValidacion();
        }

        @Test

    public void validarFormatoCorrecto (){

            String fechaCorrecta ="15/06/2023";
            Assertions.assertDoesNotThrow(()->reservaValidacion.validarFormato(fechaCorrecta));
        }

    @Test

    public void validarFormatoIncorrecto (){

        String fechaIncorrecta ="2023/06/16";
        Exception exception = assertThrows(Exception.class, ()->reservaValidacion.validarFormato(fechaIncorrecta));
        Assertions.assertEquals(Mensajes.FORMATO_FECHA_INVALIDO.getMensaje(),exception.getMessage());

    }

    @Test

    public void validarNumeroPersonasCorrecto ( ){

    Integer cantidadPersonasCorrecto = 3;
    Assertions.assertDoesNotThrow(()->reservaValidacion.validarCantidadReserva(cantidadPersonasCorrecto));
    }

    @Test

    public void validarNumeroPersonasIncorrecto ( ){

        Integer cantidadPersonasCorrecto = 5;
       Exception exception = Assertions.assertThrows(Exception.class, ()->reservaValidacion.validarCantidadReserva(cantidadPersonasCorrecto));
       Assertions.assertEquals(Mensajes.CANTIDAD_PERSONAS.getMensaje(),exception.getMessage());
    }

}