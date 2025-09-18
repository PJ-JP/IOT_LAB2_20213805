package com.example.demo.entity;

import java.io.Serializable;

public class APoint implements Serializable {
    private String marca;
    private String frecuencia;
    private String alcance;
    private String estado;

    public String getMarca() {

        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public APoint(String marca, String frecuencia, String alcance, String estado) {
        this.marca = marca;
        this.frecuencia = frecuencia;
        this.alcance = alcance;
        this.estado = estado;
    }
}
