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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PyRoS
 */
@Entity
@NamedQueries({@NamedQuery (name = "urgencia.all", query = "select c from Urgencia c")})
public class Urgencia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @MapsId
    @ManyToOne
    @JoinColumn(nullable = false, name = "Persona")
    private Persona persona;
    
    @Column(length = 4000)
    private String observaciones;
    @Column(nullable=false)
    private Enumerados.estadoUrgencia estado;
    @Column(nullable=false)
    private Enumerados.tipoUrgencia tipo;
    @ManyToOne
    @JoinColumn(name = "atiende",nullable = false)
    private Trabajador trabajador;

    public Urgencia (){
        
    }

    public Enumerados.estadoUrgencia getEstado() {
        return estado;
    }

    public void setEstado(Enumerados.estadoUrgencia estado) {
        this.estado = estado;
    }

    public Enumerados.tipoUrgencia getTipo() {
        return tipo;
    }

    public void setTipo(Enumerados.tipoUrgencia tipo) {
        this.tipo = tipo;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getObservaciones() {
        return observaciones;
    }


    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.fecha);
        hash = 83 * hash + Objects.hashCode(this.persona);
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
        final Urgencia other = (Urgencia) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        return true;
    }

    
    
    
}