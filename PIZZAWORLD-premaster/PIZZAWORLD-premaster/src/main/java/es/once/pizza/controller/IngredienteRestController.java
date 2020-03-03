package es.once.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import es.once.pizza.model.Ingrediente;
import es.once.pizza.repository.IngredienteRepository;

/**
 * IngredienteRestController
 */
@RestController
@RequestMapping("/api")
public class IngredienteRestController {

    @Autowired
    IngredienteRepository inRepo;

    @GetMapping("/ingrediente")
    public ModelAndView crear_ingredienteHTML() {
        ModelAndView modelAndView = new ModelAndView("crear_ingrediente");
        modelAndView.addObject("mensaje", "Añadido correctamente");

        return modelAndView;
    }

    @Autowired
    
    JdbcTemplate jdbcTemplate;

    @PostMapping("/ingrediente")

    public ModelAndView crear_ingredienteHTMLPOST(@RequestParam("nombre") String nombre,
            @RequestParam("precio") Double precio) {

        ModelAndView modelAndView = new ModelAndView("crear_ingrediente");

        Ingrediente ingrediente = new Ingrediente(nombre, precio);
        inRepo.save(ingrediente);
        return modelAndView;
    }


}