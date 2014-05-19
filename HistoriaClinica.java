package Entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Fernando
 */
@Entity
public class HistoriaClinica implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    */
    
    @Id
    @OneToOne
    @JoinColumn(nullable = false, name = "Persona")
    private Persona persona;
    
    @Column(nullable=false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(length=20)
    private String grupoSanguineo;
    @Column(length=4000)
    private String observaciones;
    @OneToMany
    @JoinColumn(name="informes_fk")
    private List<Informe> informes;
    

    public HistoriaClinica(){

    }
    
    
    public void setInformes(List<Informe> informes) {
        this.informes = informes;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }


    public String getObservaciones() {
        return observaciones;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Informe> getInformes() {
        return informes;
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
        hash = 17 * hash + Objects.hashCode(this.persona);
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
        final HistoriaClinica other = (HistoriaClinica) obj;
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        return true;
    }

    
}
