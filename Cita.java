package Entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ricardo
 */
@Entity
@NamedQueries({@NamedQuery (name = "cita.all", query = "select c from Cita c"),
              // @NamedQuery (name = "cita.todas", query = "select c from Cita c where c.trabajador.numSegSocial= :nss and c.fecha > :fecha"),
               @NamedQuery (name = "cita.noAtendida", query = "select c from Cita c where c.trabajador.numSegSocial = :nss and c.atendido=false"),
               @NamedQuery (name = "cita.noAsistida", query = "select c from Cita c where c.persona.numSegSocial = :nss and c.atendido=false"),
               @NamedQuery (name = "cita.trabajador", query = "select c from Cita c where c.trabajador.numSegSocial = :nss")})
public class Cita implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    
    @ManyToOne
    @JoinColumn(nullable = false, name = "Persona")
    private Persona persona;
    
    @Column(length=4000, nullable = true)
    private String observaciones;
    @Column (nullable = false)
    private boolean atendido;
    @Column (nullable = false)
    private Enumerados.tipoCita tipoCita;
    @ManyToOne
    @JoinColumn(name = "trabajador",nullable = false)
    private Trabajador trabajador;

    public Cita(){
        
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    public Enumerados.tipoCita getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(Enumerados.tipoCita tipoCita) {
        this.tipoCita = tipoCita;
    }
    


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.persona);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cita other = (Cita) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        return true;
    }
    
    
}
