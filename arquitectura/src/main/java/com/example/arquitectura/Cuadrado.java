package com.example.arquitectura;

public class Cuadrado implements Figura {
    private double lado;

    public Cuadrado() {}

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }
}