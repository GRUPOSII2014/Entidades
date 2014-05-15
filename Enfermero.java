package Entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Alberto
 */
@Entity
//@DiscriminatorValue("E")
public class Enfermero extends Trabajador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(nullable=false)
    private Float sueldoHora;
    
    public Enfermero(){}

   

    public Float getSueldoHora() {
        return sueldoHora;
    }

    public void setSueldoHora(Float sueldoHora) {
        this.sueldoHora = sueldoHora;
    }
    
    
}