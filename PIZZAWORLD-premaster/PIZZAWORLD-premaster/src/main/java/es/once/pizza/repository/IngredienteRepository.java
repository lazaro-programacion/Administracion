package es.once.pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.once.pizza.model.Ingrediente;

/**
 * IngredienteRepository
 */
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {


}