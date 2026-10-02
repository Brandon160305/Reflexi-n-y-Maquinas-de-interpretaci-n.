package com.example.arquitectura;

import java.lang.reflect.Method;
import java.util.Map;

public class FiguraFactory {

    public static Figura crearFigura(String nombreClase, Map<String, Double> parametros) throws Exception {
        String paquete = "com.example.arquitectura.";
        Class<?> clase = Class.forName(paquete + nombreClase);

        Object instancia = clase.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Double> parametro : parametros.entrySet()) {
            String clave = parametro.getKey();
            Double valor = parametro.getValue();

            String nombreSetter = "set" + clave.substring(0, 1).toUpperCase() + clave.substring(1);

            Method setter = clase.getMethod(nombreSetter, double.class);
            setter.invoke(instancia, valor);
        }

        return (Figura) instancia;
    }
}