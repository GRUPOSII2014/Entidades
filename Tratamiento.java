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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.resource.spi.AuthenticationMechanism;

/**
 *
 * @author Alberto
 */
@Entity
public class Tratamiento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable=false, length=40)
    private String nombre;
    @Column(nullable=false, length=4000)
    private String descripcion;
    @Column(nullable=true,  length=4000)
    private String observaciones;
    @Column(nullable=false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(nullable=false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @Column(nullable=false)
    private Enumerados.tipoTratamiento tipo;          
    @OneToMany(mappedBy = "tratamiento")
    private List<Cantidad> cantidades;
    @MapsId
    @ManyToOne
    @JoinColumn(nullable=false, name="persona")
    private Persona persona;
    
    public Tratamiento(){}

    
    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getObservaciones(){
        return observaciones;
    }
    
    public void setObservaciones(String observaciones){
        this.observaciones = observaciones;
    }

    public Enumerados.tipoTratamiento getTipo() {
        return tipo;
    }

    public void setTipo(Enumerados.tipoTratamiento tipo) {
        this.tipo = tipo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Cantidad> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Cantidad> cantidades) {
        this.cantidades = cantidades;
    }
    
    public Persona getPersona(){
        return persona;
    }
    
    public void setPersona(Persona persona){
        this.persona=persona;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Tratamiento other = (Tratamiento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
