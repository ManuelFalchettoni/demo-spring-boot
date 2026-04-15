package demo.demo.model.movement;

import jakarta.persistence.*; //Todas las herramientas

@Entity//SpringBoot no sabe nunca que tipo es, entonces debemos escribirlos
@Table(name= "movements") //Hace referencia a la tabla dentro de la DB
public class Movement {

    @Id //Indicador de Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremental
    private Long id;

    @Column(nullable=false)//Los sig atributos no pueden recibir un dato nulo
    private String name;

    @Column(nullable=false)
    private String description;

    public Movement(){} //Constructor vacio para el ORM

    public Movement(Long id, String name, String description){
        this.id= id;
        this.name= name;
        this.description = description;
    } //Constructor para poder usarlo nosotros

    //Getters & Setters

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
