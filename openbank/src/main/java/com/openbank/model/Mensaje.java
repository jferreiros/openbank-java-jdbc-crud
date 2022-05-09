package com.openbank.model;

import java.sql.Date;


public class Mensaje {
    private int id;
    private int id_origen;
    private int id_destino;
    private String texto;
    private Date fecha;

    public Mensaje() {
    }

    public Mensaje(int id_origen, int id_destino, String texto, Date fecha) {
        this.id_origen = id_origen;
        this.id_destino = id_destino;
        this.texto = texto;
        this.fecha = fecha;
    }

    public Mensaje(int id, int id_origen, int id_destino, String texto, Date fecha) {
        this.id = id;
        this.id_origen = id_origen;
        this.id_destino = id_destino;
        this.texto = texto;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_origen() {
        return id_origen;
    }

    public void setId_origen(int id_origen) {
        this.id_origen = id_origen;
    }

    public int getId_destino() {
        return id_destino;
    }

    public void setId_destino(int id_destino) {
        this.id_destino = id_destino;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String toString() {
        return "MensajeID: " + id + ", Emisor: " + id_origen + ", Receptor: " + id_destino + "\n" + "Texto: " + texto + ", Fecha: " + fecha;
    }

}
