package Entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author PyRoS
 */
@Entity
public class Cantidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Float cantidad;
   
    @MapsId
    @ManyToOne
    @JoinColumn(nullable = false, name = "tratemiento")
    private Tratamiento tratamiento;
    
    @MapsId
    @ManyToOne
    @JoinColumn(nullable = false, name = "medicamento")
    private Medicamento medicamento;
    
    @Column(length = 4000)
    private String observacion;
    
    public Cantidad(){}

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.cantidad);
        hash = 79 * hash + Objects.hashCode(this.tratamiento);
        hash = 79 * hash + Objects.hashCode(this.medicamento);
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
        final Cantidad other = (Cantidad) obj;
        if (!Objects.equals(this.cantidad, other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.tratamiento, other.tratamiento)) {
            return false;
        }
        if (!Objects.equals(this.medicamento, other.medicamento)) {
            return false;
        }
        return true;
    }
    
    
    
}
