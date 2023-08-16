package org.example.utilidades;

import org.example.modelos.Reserva;

public class Calculo {


    public Calculo() {
    }
    //TODO:: Terminar la implementacion del calculo
    public static Double calcularIva (Double valor){
        Double iva = valor * (19/100);
        return  iva;
    }
}
