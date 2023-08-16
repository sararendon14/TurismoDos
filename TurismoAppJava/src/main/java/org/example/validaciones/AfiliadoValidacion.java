package org.example.validaciones;

import org.example.utilidades.Mensajes;
import org.example.utilidades.Util;

public class AfiliadoValidacion {

    //Valor de la membresia no puede ser menor a $20.000 pesos ni puede ser mayor a $150.00
    //cedula del referido SOLO PUEDE TENER NUMEROS
         protected Util util = new Util();

    public Boolean validarCostoMembresia (Integer costo) throws  Exception{

        if (costo < 20000 || costo > 150000 ){
            throw new Exception(Mensajes.COSTO_VALOR_MEMBRESIA.getMensaje());
        } else{
        return true;
    }
    }
    public Boolean validarReferido (String documentoReferido) throws Exception{
        String expresionRegular = "^-?\\d+$";
        if (Util.buscarCoincidencia(expresionRegular,documentoReferido)){
            throw new Exception(Mensajes.NUMEROS_ENTEROS.getMensaje()) ;

        } else {
            return true;
        }
    }
}
