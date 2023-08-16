package org.example.validaciones;


import org.example.utilidades.Mensajes;
import org.example.utilidades.Util;


import java.time.LocalDate;
import java.util.Date;


public class OfertaValidacion {

    protected Util util = new Util();

    public OfertaValidacion (){}

    public Boolean validarCaracteres (String titulo ) throws  Exception{
        String expresionRegular ="^[a-zA-ZñÑ ]+$";
        if (!Util.buscarCoincidencia(expresionRegular, titulo)){
            throw new Exception(Mensajes.NOMBRE_SOLO_LETRAS.getMensaje());
        } else if (titulo.length() > 20 ) {
            throw new Exception(Mensajes.CARACTERES_OFERTA.getMensaje());
        }

        return true;
    }

    public Boolean validarFormato ( String fecha ) throws  Exception{
        String expresionRegular = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        if (!Util.buscarCoincidencia(expresionRegular, fecha)){
            throw new Exception(Mensajes.FORMATO_FECHA_INVALIDO.getMensaje()    );
        } else {
            return true;
        }

    }

    public boolean validarFecha (LocalDate fechaInicio, LocalDate fechaFin) throws Exception{
        System.out.println(fechaInicio);
        System.out.println(fechaFin);
        if (fechaInicio.isAfter(fechaFin) || fechaFin.isBefore(fechaInicio)) {
            throw new Exception(Mensajes.COHERENCIA_FECHAS.getMensaje());
        }

        return true;
    }


    public Boolean validarCosto (Double costoTotal) throws Exception {

        if (costoTotal <0 ){
            throw new Exception(Mensajes.VALOR_COSTO_NEGATIVO.getMensaje());
        }
        return true;
    }


}




//- Todas las fechas deben tener el formato (DD/MM/YYYY)
