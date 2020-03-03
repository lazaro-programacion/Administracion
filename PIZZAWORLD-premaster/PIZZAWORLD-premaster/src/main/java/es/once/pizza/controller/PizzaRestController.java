package es.once.pizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import es.once.pizza.model.Pizza;
import es.once.pizza.repository.PizzaRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * PizzaController
 */
@RestController
public class PizzaRestController {

    @Autowired
    PizzaRepository pzRepo;

    @GetMapping(value="/api/pizza")
    public List<Pizza> getAllPizza() {
        return pzRepo.findAll(); // pide al repositorio que devuelva todos los elementos
    }

    @PostMapping("/api/pizzas/add")
    public Pizza crearPizza(

            @RequestBody Pizza pizza
            
            ) {

        Pizza p = pzRepo.save(pizza);
        return p;

    }
}