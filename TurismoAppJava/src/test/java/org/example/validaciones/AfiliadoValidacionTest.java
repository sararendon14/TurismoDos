package org.example.validaciones;

import org.example.utilidades.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AfiliadoValidacionTest {

    private AfiliadoValidacion afiliadoValidacion;

    @BeforeEach
    public void setUp(){
        this.afiliadoValidacion = new AfiliadoValidacion();
    }

    @Test
    public void validarCostoMembresiaCorrecto(){
        Integer costoMembresiaCorrecto = 100000;
        Assertions.assertDoesNotThrow(()->afiliadoValidacion.validarCostoMembresia(costoMembresiaCorrecto));
    }

    @Test

    public  void validarCostoMembresiaIncorrecto(){
        Integer costoMembresiaIncorrecto = 19000;
        Exception exception = Assertions.assertThrows(Exception.class,()-> afiliadoValidacion.validarCostoMembresia(costoMembresiaIncorrecto));
      Assertions.assertEquals(Mensajes.COSTO_VALOR_MEMBRESIA.getMensaje(),exception.getMessage());

    }
}