package org.example.validaciones;

import org.example.utilidades.Mensajes;
import org.example.utilidades.Util;

import java.util.Date;
import java.util.concurrent.ExecutionException;

public class ReservaValidacion {

    protected Util util = new Util();

    public ReservaValidacion(){}

    public Boolean validarCantidadReserva (Integer cantidadUsuariosReserva) throws Exception {
        if (cantidadUsuariosReserva > 4 ){
            throw new Exception(Mensajes.CANTIDAD_PERSONAS.getMensaje());
        }
        return true;
    }
    public Boolean validarFormato ( String fecha ) throws  Exception{
        String expresionRegular = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        if (!Util.buscarCoincidencia(expresionRegular, fecha)){
            throw new Exception(Mensajes.FORMATO_FECHA_INVALIDO.getMensaje());
        } else {
            return true;
        }
    }
    public boolean validarFecha (Date fechaInicio, Date fechaFin) throws Exception{
        if (fechaInicio.after(fechaFin)) {
            throw new Exception(Mensajes.COHERENCIA_FECHAS.getMensaje());
        }

        return true;
    }
}
