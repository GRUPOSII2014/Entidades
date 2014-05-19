package Entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Alberto
 */
@Entity
@DiscriminatorValue("T")
@NamedQueries({
    @NamedQuery (name = "trabajador", query = "select t from Trabajador t where t.numSegSocial = :nss"),
    @NamedQuery (name = "trabajador.nombre", query = "select t from Trabajador t where t.nombre = :nombre")
})
public class Trabajador extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable=false)
    private boolean activo;
    @Column(nullable=false)
    private Enumerados.tipoTrabajador tipo;
    @Column(nullable=false)
    private Float salario;
    @OneToMany(mappedBy="trabajador")
    private List<Urgencia> urgencias;
    @OneToOne(mappedBy = "trabajador")
    private Alerta alerta;
    @ManyToMany
    @JoinTable(name="horario_trabajador", 
    joinColumns = @JoinColumn(name="trabajador_fk"),
    inverseJoinColumns = @JoinColumn(name = "horario_fk"))
    private List<Horario> horarios;
    @OneToMany(mappedBy = "to")
    @JoinColumn(name="to", nullable = true)
    private List<Mensaje> mensajeTo;
    @OneToMany(mappedBy = "from")
    @JoinColumn(name = "from", nullable = true)
    private List<Mensaje> mensajeFrom;
    @ManyToMany
    @JoinTable(name = "medico_especialidad",
            joinColumns = @JoinColumn(name = "medico_fk"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_fk"))
    private List<Especialidad> especialidad;
    @ManyToOne
    @JoinColumn(name = "dep_id", nullable = false)
    private Departamento departamento;
    
    public Trabajador(){
        
    }

    public List<Especialidad> getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(List<Especialidad> especialidad) {
        this.especialidad = especialidad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Enumerados.tipoTrabajador getTipo() {
        return tipo;
    }

    public void setTipo(Enumerados.tipoTrabajador tipo) {
        this.tipo = tipo;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public List<Mensaje> getMensajeTo() {
        return mensajeTo;
    }

    public void setMensajeTo(List<Mensaje> mensajeTo) {
        this.mensajeTo = mensajeTo;
    }

    public List<Mensaje> getMensajeFrom() {
        return mensajeFrom;
    }

    public void setMensajeFrom(List<Mensaje> mensajeFrom) {
        this.mensajeFrom = mensajeFrom;
    }
    
}
