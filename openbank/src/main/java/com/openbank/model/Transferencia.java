package com.openbank.model;

import java.sql.Date;
import java.time.LocalDateTime;

public class Transferencia {
    private int id;
    private int id_ordenante;
    private int id_beneficiairo;
    private Float importe;
    private String concepto;
    private Date fecha;

    public Transferencia() {
    }

    public Transferencia(int id_ordenante, int id_beneficiairo, Float importe, String concepto, Date fecha) {
        this.id_ordenante = id_ordenante;
        this.id_beneficiairo = id_beneficiairo;
        this.importe = importe;
        this.concepto = concepto;
        this.fecha = fecha;
    }
    
    public Transferencia(int id, int id_ordenante, int id_beneficiairo, Float importe, String concepto, Date fecha) {
        this.id = id;
        this.id_ordenante = id_ordenante;
        this.id_beneficiairo = id_beneficiairo;
        this.importe = importe;
        this.concepto = concepto;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ordenante() {
        return id_ordenante;
    }

    public void setId_ordenante(int id_ordenante) {
        this.id_ordenante = id_ordenante;
    }

    public int getId_beneficiairo() {
        return id_beneficiairo;
    }

    public void setId_beneficiairo(int id_beneficiairo) {
        this.id_beneficiairo = id_beneficiairo;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    

    
}
