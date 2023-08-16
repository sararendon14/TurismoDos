package org.example.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {


    public static Boolean buscarCoincidencia(String expresionRegular, String cadena){
        Pattern patron = Pattern.compile(expresionRegular);
        Matcher emparejador = patron.matcher(cadena);
        if (emparejador.matches()) {
            return true;
        } else {
            return false;
        }
    }


    public static LocalDate formatearFechaStringLocalDate (String fecha, String formato){
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(formato);
        LocalDate fechaFormateada = LocalDate.parse(fecha, formatoFecha);
        return fechaFormateada;
    }



    //TODO:: Terminar el metodo para cambiar formato de fecha

    //TODO:: Generar id aleatorio un numero entre 0 y 500
}
