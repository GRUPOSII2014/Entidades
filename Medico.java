package Entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Alberto
 */
@Entity
//@DiscriminatorValue("M")
public class Medico extends Trabajador implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(nullable=false)
    private Float precioHora;
    @Column(nullable=true)
    private String despacho;
    
    @OneToMany(mappedBy = "medicoCabecera",cascade = CascadeType.DETACH)
    private List<Persona> pacientes;

    
    public Medico (){
        
    }

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }
    
    public List<Persona> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Persona> pacientes) {
        this.pacientes = pacientes;
    }

    public Float getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(Float precioHora) {
        this.precioHora = precioHora;
    }
    
}
