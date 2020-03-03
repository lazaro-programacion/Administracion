package es.once.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import es.once.pizza.repository.IngredienteRepository;

/**
 * IngredienteController
 */
@Controller
public class IngredienteController {

    @Autowired
    IngredienteRepository inRepo;

    @GetMapping("/ingredientes")
    @ResponseBody
    public ModelAndView ingrediente() {

        ModelAndView modelAndView=new ModelAndView("list_ingredientes");
        modelAndView.addObject("ingrediente", inRepo.findAll());
    
        
        return modelAndView;
    }
   
    @GetMapping("/delete/{id}")//http://localhost:8080/api/{id}/
    public ModelAndView deleteingrediente(
        @PathVariable("id") Long id
        ) {
       
        try{
            inRepo.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        ModelAndView modelAndView=new ModelAndView("list_ingredientes");
        modelAndView.addObject("productos", inRepo.findAll());

        Long total=inRepo.count();
        modelAndView.addObject("mensaje", "Total ingredientes: "+String.valueOf(total));
        return  modelAndView;
    }

}