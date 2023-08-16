package org.example.validaciones;

import org.example.modelos.Oferta;
import org.example.utilidades.Mensajes;
import org.example.utilidades.Util;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OfertaValidacionTest {

    private OfertaValidacion ofertaValidacion;

    @BeforeEach

    public void setUp (){
        this.ofertaValidacion = new OfertaValidacion();
    }
    @Test
    public void validarTituloOfertaCorrecto (){

        String tituloCorrecto= "Venta de bolsos ";

        Assertions.assertDoesNotThrow(()->ofertaValidacion.validarCaracteres(tituloCorrecto));
    }

    @Test
    public void validarTituloOfertaIncorrecto (){

        String tituloIncorrecto = " Eventooooooooooooooooooooooooooooooooooooooooooooooooo";
     Exception exception = Assertions.assertThrows(Exception.class,()->ofertaValidacion.validarCaracteres(tituloIncorrecto));
       Assertions.assertEquals(Mensajes.CARACTERES_OFERTA.getMensaje(),exception.getMessage());
    }

    @Test

    public void validarFechaInicioFechaFinCorrecto (){


        LocalDate fechaInicioCorrecta= LocalDate.of(2022,2,3);

        LocalDate fechaFinCorrecta= LocalDate.of(2022,4,3);


        Assertions.assertDoesNotThrow(()->ofertaValidacion.validarFecha(fechaInicioCorrecta, fechaFinCorrecta));

    }
    @Test
    public void validarFechaInicioFechaFinIncorrecto (){


        LocalDate fechaInicioIncorrecta= LocalDate.of(2022,6,3);

        LocalDate fechaFinIncorrecta= LocalDate.of(2022,4,3);

        Exception exception = Assertions.assertThrows(Exception.class, ()->ofertaValidacion.validarFecha(fechaInicioIncorrecta, fechaFinIncorrecta));
        Assertions.assertEquals(Mensajes.COHERENCIA_FECHAS.getMensaje(),exception.getMessage());

    }

@Test

    public void validarFormatoCorrecto (){

        String fechaCorrecta ="15/06/2023";
        Assertions.assertDoesNotThrow(()->ofertaValidacion.validarFormato(fechaCorrecta));

}

    @Test

    public void validarFormatoIncorrecto (){

        String fechaIncorrecta ="2023/06/16";
        Exception exception = assertThrows(Exception.class, ()->ofertaValidacion.validarFormato(fechaIncorrecta));
        Assertions.assertEquals(Mensajes.FORMATO_FECHA_INVALIDO.getMensaje(),exception.getMessage());

    }

    @Test

    public void validarCostoCorrecto (){

        Double costoCorrecto = 30000.0;
        Assertions.assertDoesNotThrow(()->ofertaValidacion.validarCosto(costoCorrecto));

    }

    @Test

    public void validarCostoIncorrecto (){

        Double costoIncorrecto = -30000.0;
        Exception exception = assertThrows(Exception.class,()->ofertaValidacion.validarCosto(costoIncorrecto));
        Assertions.assertEquals(Mensajes.VALOR_COSTO_NEGATIVO.getMensaje(),exception.getMessage());

    }



}