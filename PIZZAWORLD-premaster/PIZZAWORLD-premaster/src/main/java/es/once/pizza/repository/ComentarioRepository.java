package es.once.pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.once.pizza.model.Comentario;

interface ComentarioRepository extends JpaRepository<Comentario, Long>{

    
}