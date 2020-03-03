 package es.once.pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.once.pizza.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long>{

    
}