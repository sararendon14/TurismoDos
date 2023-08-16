package org.example.modelos;

public class NoAfiliado extends Usuario {

    private Integer numeroReservas;


    public NoAfiliado() {
    }

    @Override
    public Double calcularAnualidad() {
        return this.getCostoAnual()+this.getIVA();
    }

    public NoAfiliado(Integer id, String nombres, String documento, Integer ubicacion, String correoElectronico, Integer numeroReservas) {
        super(id, nombres, documento, ubicacion, correoElectronico);
        this.numeroReservas = numeroReservas;
    }

    public Integer getNumeroReservas() {
        return numeroReservas;
    }

    public void setNumeroReservas(Integer numeroReservas) {
        this.numeroReservas = numeroReservas;
    }
}
