package com.example.demo.entity;

import java.io.Serializable;

public class Switch implements Serializable {
    private String marca;
    private String modelo;
    private String cantidadPuertos;
    private String tipo;
    private String estado;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCantidadPuertos() {
        return cantidadPuertos;
    }

    public void setCantidadPuertos(String cantidadPuertos) {
        this.cantidadPuertos = cantidadPuertos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Switch(String marca, String modelo, String cantidadPuertos, String tipo, String estado) {
        this.marca = marca;
        this.modelo = modelo;
        this.cantidadPuertos = cantidadPuertos;
        this.tipo = tipo;
        this.estado = estado;
    }
}
