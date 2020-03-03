package es.once.pizza.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


/**
 * class pizza
 */
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // clave principal de la tabla (autonumérico Long)

    // nombre de la pizza (especificación del cliente)
    @NotBlank
    @Size(min = 4, max = 25)
    private String nombre;

    private double precio;

    // almacena una referencia a una imagen, ya se verá donde se alamacenan
    @NotBlank
    private String imageReference;

    // contrapartida de la relación con ingredientes
    @OneToMany(mappedBy = "pizza")
    List<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();

    // contrapartida de la relación con comentarios
    @OneToMany(mappedBy = "pizza")
    List<Comentario> listaComentarios = new ArrayList<Comentario>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImageReference() {
        return imageReference;
    }

    public void setImageReference(String imageReference) {
        this.imageReference = imageReference;
    }

    public Pizza(String nombre, String imageReference) {
        this.nombre = nombre;
        this.imageReference = imageReference;

    }

/*     public List<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    } */

    public Pizza() {
    }

    public double getPrecio() {

        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    

}