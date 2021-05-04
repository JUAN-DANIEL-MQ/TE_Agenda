package com.emergentes.Modelo;
public class Tarea {
    
    private int id;
    private String nombre;
    private int prioridad;
    private int completado;

    public Tarea() {
        this.id = 0;
        this.nombre = "";
        this.prioridad = 0;
        this.completado = 0;
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

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getCompletado() {
        return completado;
    }

    public void setCompletado(int completado) {
        this.completado = completado;
    }
    
    
    
}
