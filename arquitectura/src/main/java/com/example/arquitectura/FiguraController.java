package com.example.arquitectura;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@RestController
@RequestMapping("/api/figuras")
public class FiguraController {


    @PostMapping("/nativa/{nombre}")
    public String crearNativa(@PathVariable String nombre, @RequestBody Map<String, Double> parametros) {
        try {
            Figura figura = FiguraFactory.crearFigura(nombre, parametros);
            return "Figura " + nombre + " creada con éxito.\n" +
                    "Área: " + figura.calcularArea() + "\n" +
                    "Perímetro: " + figura.calcularPerimetro();
        } catch (Exception e) {
            return "Error al crear la figura nativa: " + e.getMessage();
        }
    }


    @PostMapping("/externa")
    public String crearExterna(@RequestParam String urlServicio, @RequestBody Map<String, Double> parametros) {
        try {

            RestTemplate restTemplate = new RestTemplate();
            String scriptGroovy = restTemplate.getForObject(urlServicio, String.class);
            Figura figura = GroovyFiguraFactory.crearDesdeScript(scriptGroovy, parametros);

            return "Figura externa cargada y compilada con éxito.\n" +
                    "Área: " + figura.calcularArea() + "\n" +
                    "Perímetro: " + figura.calcularPerimetro();
        } catch (Exception e) {
            return "Error al traer o compilar la figura externa: " + e.getMessage();
        }
    }
}