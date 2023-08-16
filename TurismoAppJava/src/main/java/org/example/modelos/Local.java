package org.example.modelos;

import org.example.validaciones.LocalValidacion;

public abstract class Local {

  private Integer id;
    private  String nit;
    private String nombre;
    private Integer direccion;
    private  String descripcion;

    private LocalValidacion validacion = new LocalValidacion();
    public Local() {
    }

    public Local(Integer id, String nit, String nombre, Integer direccion, String descripcion) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {

        try {
            this.validacion.validarDigitos(nit);
            this.nit = nit;
        }
        catch (Exception error){
            System.out.print(error.getMessage());
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        try {
            this.validacion.validarNombreEmpresa(nombre);
            this.nombre = nombre;
        } catch (Exception error){
            System.out.print(error.getMessage());
        }

    }

    public Integer getDireccion() {
        return direccion;
    }

    public void setDireccion(Integer direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Local{" +
                "id=" + id +
                ", nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", descripcion='" + descripcion + '\'' +
                ", validacion=" + validacion +
                '}';
    }
}