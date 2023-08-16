package org.example.modelos;

import org.example.utilidades.Util;
import org.example.validaciones.OfertaValidacion;
import java.time.LocalDate;


public class Oferta {
   private Integer id;
    private  String titulo;
    private  String descripcion;
    private  LocalDate fechaInicio;
    private  LocalDate fechaFin;
    private  Double costoTotal;
    private Integer idLocal ;

    private OfertaValidacion validacion = new OfertaValidacion();
    public Oferta() {
    }

    public Oferta(Integer id, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Double costoTotal, Integer idLocal) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoTotal = costoTotal;
        this.idLocal = idLocal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {

        try {
            this.validacion.validarCaracteres(titulo);
            this.titulo = titulo;

        } catch (Exception error){
            System.out.print(error.getMessage());
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }


    public void setFechaInicio(String fechaInicio) {
        try{
            this.validacion.validarFormato(fechaInicio);
            this.fechaInicio = Util.formatearFechaStringLocalDate(fechaInicio,"dd/MM/yyyy");
        } catch (Exception error){
            System.out.print(error.getMessage());
        }

    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {

        try {
            this.validacion.validarFormato(fechaFin);
            LocalDate fechaFinalTemporal= Util.formatearFechaStringLocalDate(fechaFin, "dd/MM/yyyy");
            this.validacion.validarFecha(this.fechaInicio, fechaFinalTemporal );
            this.fechaFin = fechaFinalTemporal;
        } catch (Exception error){
            System.out.println(error.getMessage());
        }

    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {

       try {
           this.validacion.validarCosto(costoTotal);
           this.costoTotal = costoTotal;
       }catch (Exception error){
           System.out.print(error.getMessage());
       }
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", costoTotal=" + costoTotal +
                ", idLocal=" + idLocal +
                ", validacion=" + validacion +
                '}';
    }
}