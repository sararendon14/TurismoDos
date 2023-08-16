package org.example.modelos;

import org.example.interfaces.Deduccion;
import org.example.interfaces.Reporte;
import org.example.utilidades.MetodosPago;
import org.example.validaciones.AfiliadoValidacion;

public class Afiliado extends Usuario implements Deduccion, Reporte {

    private Integer valorMembresia;
    private MetodosPago metodoPago;
    private String documentoReferido;
    private AfiliadoValidacion validacion = new AfiliadoValidacion();

    public Afiliado() {
    }

    @Override
    public Double calcularAnualidad() {
        return this.getCostoAnual()-(this.getValorMembresia()*0.2);
    }

    public Afiliado(Integer id, String nombres, String documento, Integer ubicacion, String correoElectronico, Integer valorMembresia, MetodosPago metodoPago, String documentoReferido) {
        super(id, nombres, documento, ubicacion, correoElectronico);
        this.valorMembresia = valorMembresia;
        this.metodoPago = metodoPago;
        this.documentoReferido = documentoReferido;
    }

    public Integer getValorMembresia() {
        return valorMembresia;
    }

    public void setValorMembresia(Integer valorMembresia) {

       try {
           this.validacion.validarCostoMembresia(valorMembresia);
           this.valorMembresia = valorMembresia;
       } catch (Exception error){
           System.out.println(error.getMessage());
       }

    }

    public MetodosPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodosPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getDocumentoReferido() {
        return documentoReferido;
    }

    public void setDocumentoReferido(String documentoReferido) {
       try { this.validacion.validarReferido(documentoReferido);
           this.documentoReferido = documentoReferido;
       } catch (Exception error){
           System.out.println(error.getMessage());
       }
    }



    // METODOS ORDINARIOS

    public Double aplicarIvaMebresia (){

        return this.valorMembresia+this.getIVA()*this.valorMembresia;

    }


    @Override
    public void calcularDeduccionAnualidad() {

    }

    @Override
    public Double calcularDeduccionMensualidad() {
        return null;
    }

    @Override
    public void generarReporte(Integer id) {

    }

    @Override
    public void mostrarReporte(Integer id) {

    }
}


