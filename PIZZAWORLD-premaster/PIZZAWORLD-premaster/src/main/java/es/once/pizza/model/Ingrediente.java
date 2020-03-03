package es.once.pizza.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//loomboock
@Entity
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    //clave principal de la tabla (autonumérico Long)

    private String nombre;  //nombre del ingrediente
    private double precio;  //precio del ingrediente

    //relación de la tabla ingredientes con la table Pizza por medio de
    //@JoinColumn. Se creará una columna FK llamada idPizza en Ingrediente
    // que corresponde a la PK de la tabla Pizza
    //también activamos el modo Lazy
    @ManyToOne(fetch = FetchType.LAZY)  
    @JoinColumn(name="id_pizza")
    private Pizza pizza;    


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Ingrediente(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Ingrediente() {
    }


}
