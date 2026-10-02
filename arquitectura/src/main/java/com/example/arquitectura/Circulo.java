package com.example.arquitectura;

public class Circulo implements Figura {
    private double radio;

    public Circulo() {
    }

    public void setRadio(double radio){
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }



}
