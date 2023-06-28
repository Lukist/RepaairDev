package com.example.devreparations.modelos;

import java.io.Serializable;

public class ModeloProducto implements Serializable {
    int id;
    String serie, tipo, problema, telefono, tecnico;

    public ModeloProducto() {
    }

    public ModeloProducto(int id, String serie, String tipo, String problema, String telefono, String tecnico) {
        this.id = id;
        this.serie = serie;
        this.tipo = tipo;
        this.problema = problema;
        this.telefono = telefono;
        this.tecnico = tecnico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public String toString() {
        return "ModeloProducto{" +
                "id=" + id +
                ", serie='" + serie + '\'' +
                ", tipo='" + tipo + '\'' +
                ", problema='" + problema + '\'' +
                ", telefono='" + telefono + '\'' +
                ", tecnico='" + tecnico + '\'' +
                '}';
    }
}
