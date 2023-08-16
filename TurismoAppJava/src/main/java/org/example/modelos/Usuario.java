package org.example.modelos;

import org.example.validaciones.UsuarioValidacion;

public abstract class Usuario {

    //ATTRIBUTES = VARIABLES = DATES

    //METHODS = FUNCTIONS = ACTIONS

    //ORDINARY METHODS

   private Integer id;
    private String nombres;
    private String documento ;
    private  Integer ubicacion ;
    private  String correoElectronico;
    private final Integer costoAnual = 600000;

    private final Double IVA = 0.19;


    private final UsuarioValidacion validacion = new UsuarioValidacion();

    //SPECIAL METHODS

    public Usuario() { //Constructor vacio
    }

    public Usuario(Integer id, String nombres, String documento, Integer ubicacion, String correoElectronico) {
        this.id = id;
        this.nombres = nombres;
        this.documento = documento;
        this.ubicacion = ubicacion;
        this.correoElectronico = correoElectronico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        try {
            this.validacion.validarNombre(nombres);
            this.nombres = nombres;
        } catch (Exception error){
            System.out.print(error.getMessage());
        }

    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Integer ubicacion) {
        try {
            this.validacion.validarUbicacion(ubicacion);
            this.ubicacion = ubicacion;
        }
        catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    public String getCorreoElectronico(){return correoElectronico;}

    public void setCorreoElectronico(String correoElectronico) {

        try {
            this.validacion.validarCorreoElectronico(correoElectronico);
            this.correoElectronico = correoElectronico;

        }catch (Exception error){
            System.out.println(error.getMessage());
        }

    }

    public Integer getCostoAnual() {
        return costoAnual;
    }

    public Double getIVA() {
        return IVA;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", documento='" + documento + '\'' +
                ", ubicacion=" + ubicacion +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", validacion=" + validacion +
                '}';
    }

    //METODOS ORDINARIOS

    public abstract Double calcularAnualidad();

}