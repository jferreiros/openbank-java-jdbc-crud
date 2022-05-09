package com.openbank.model;

public class Prestamo {
    private int id;
    private String nombre;
    private Long comision;
    private int meses;

    public Prestamo() {
    }

    public Prestamo(String nombre, Long comision, int meses) {
        this.nombre = nombre;
        this.comision = comision;
        this.meses = meses;
    }

    public Prestamo(int id, String nombre, Long comision, int meses) {
        this.id = id;
        this.nombre = nombre;
        this.comision = comision;
        this.meses = meses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getComision() {
        return comision;
    }

    public void setComision(Long comision) {
        this.comision = comision;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public String toString() {
        return "PrestamoID: " + id + ", Nombre: " + nombre + ", Comision: " + comision + ", Meses: " + meses + "\n" ;
    }
    
    
}
