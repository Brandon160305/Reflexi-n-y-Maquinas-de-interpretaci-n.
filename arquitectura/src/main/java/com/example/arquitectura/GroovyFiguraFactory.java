package com.example.arquitectura;

import groovy.lang.GroovyClassLoader;
import java.lang.reflect.Method;
import java.util.Map;

public class GroovyFiguraFactory {

    public static Figura crearDesdeScript(String scriptGroovy, Map<String, Double> parametros) throws Exception {
        try (GroovyClassLoader loader = new GroovyClassLoader()) {

            Class<?> claseGroovy = loader.parseClass(scriptGroovy);
            Object instancia = claseGroovy.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Double> parametro : parametros.entrySet()) {
                String clave = parametro.getKey();
                Double valor = parametro.getValue();

                String nombreSetter = "set" + clave.substring(0, 1).toUpperCase() + clave.substring(1);

                Method setter = claseGroovy.getMethod(nombreSetter, double.class);
                setter.invoke(instancia, valor);
            }

            return (Figura) instancia;
        }
    }
}