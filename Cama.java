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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author Fernando
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Cama.all", query = "select c from Cama c")
})
public class Cama implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Integer num;
    @ManyToOne
    @JoinColumn(nullable = false,name = "habitacionññ")
    private Habitacion habitacion;
    
    @OneToOne
    @JoinColumn(name="paciente")
    private Persona paciente;
    
    @Column(nullable=false, length=20)
    private Enumerados.estadoCama estado;

    public Integer getNum() {
        return num;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Persona getPaciente() {
        return paciente;
    }

    public void setPaciente(Persona paciente) {
        this.paciente = paciente;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setNum(int num) {
        this.num = num;
    }
    
    public Cama(){
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Cama other = (Cama) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Enumerados.estadoCama getEstado() {
        return estado;
    }

    public void setEstado(Enumerados.estadoCama estado) {
        this.estado = estado;
    }
    
}
