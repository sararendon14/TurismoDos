package org.example.validaciones;

import org.example.utilidades.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalValidacionTest {

    private LocalValidacion localValidacion;

    @BeforeEach

    public void setUp (){
        this.localValidacion = new LocalValidacion();

    }

    @Test

    public void validarNitCorrecto (){

        String nitCorrecto = "2346642027";

        Assertions.assertDoesNotThrow(()->localValidacion.validarDigitos(nitCorrecto));
    }
@Test
    public void validarNitIncorrectoCorto (){

        String nitIncorrecto ="32455";
        Exception exception = Assertions.assertThrows(Exception.class,()->localValidacion.validarDigitos(nitIncorrecto));
        Assertions.assertEquals(Mensajes.NIT_MUY_CORTO.getMensaje(),exception.getMessage());
    }
    @Test
    public void validarNitIncorrectoCaracteres (){

        String nitIncorrecto ="32455a";
        Exception exception = Assertions.assertThrows(Exception.class,()->localValidacion.validarDigitos(nitIncorrecto));
        Assertions.assertEquals(Mensajes.NUMEROS_ENTEROS.getMensaje(),exception.getMessage());
    }
    @Test

    public void validarNombreEmpresaCorrecto (){

        String nombreEmpresaCorrecto ="Chocolates Medellin SAS";

        Assertions.assertDoesNotThrow(()->localValidacion.validarNombreEmpresa(nombreEmpresaCorrecto));
    }
    @Test
    public void validarNombreEmpresaIncorrecto (){

        String nombreEmpresaIncorrecto =" aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Exception exception = Assertions.assertThrows(Exception.class,()->localValidacion.validarNombreEmpresa(nombreEmpresaIncorrecto));
        Assertions.assertEquals(Mensajes.CARACTERES_EMPRESA.getMensaje(),exception.getMessage());
    }

}