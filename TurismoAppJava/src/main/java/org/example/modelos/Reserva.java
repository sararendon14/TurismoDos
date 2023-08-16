package org.example.modelos;

import org.example.utilidades.Util;
import org.example.validaciones.ReservaValidacion;

import java.time.LocalDate;

public class Reserva {

   private Integer id;
    private Integer idUsuario;
    private  Integer idOferta;
    private LocalDate fechaReserva;
    private  Integer cantidadUsuarios;

    private Double costoTotal;

    public static final Double iva= 0.19;

    protected ReservaValidacion validacion = new ReservaValidacion();
    public Reserva() {
    }

    public Reserva(Integer id, Integer idUsuario, Integer idOferta, LocalDate fechaReserva, Integer cantidadUsuarios, Double costoTotal) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idOferta = idOferta;
        this.fechaReserva = fechaReserva;
        this.cantidadUsuarios = cantidadUsuarios;
        this.costoTotal = costoTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva)  {
        try {
            this.validacion.validarFormato(fechaReserva);
            this.fechaReserva = Util.formatearFechaStringLocalDate(fechaReserva, "dd/MM/yyyy");
        } catch (Exception error){
            System.out.println(error.getMessage());
        }

    }

    public Integer getCantidadUsuariosReserva() {
        return cantidadUsuarios;
    }

    public void setCantidadUsuariosReserva(Integer cantidadUsuarios) {
        try {
            this.validacion.validarCantidadReserva( cantidadUsuarios);
            this.cantidadUsuarios = cantidadUsuarios;
        } catch (Exception error){
            System.out.print(error.getMessage());
        }
        }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idOferta=" + idOferta +
                ", fechaReserva=" + fechaReserva +
                ", cantidadUsuarios=" + cantidadUsuarios +
                ", costoTotal=" + costoTotal +

                '}';
    }
}