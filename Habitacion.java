package Entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Fernando
 */
@Entity
@NamedQuery(name = "Habitacion.all", query = "select h from Habitacion h")
public class Habitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Integer num;
    @ManyToOne
    @JoinColumn(nullable = false, name = "planta")
    private Planta planta;
    @Column(nullable=true, length=20)
    private Enumerados.tipoHabitacion tipo;//Hacer ejemplo
    @OneToMany(mappedBy = "habitacion")
    private List<Cama> camas;
    
    public Long getId() {
        return id;
    }

    public List<Cama> getCamas() {
        return camas;
    }

    public void setCamas(List<Cama> camas) {
        this.camas = camas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Planta getPlanta() {
        return planta;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    
    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public Enumerados.tipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(Enumerados.tipoHabitacion tipo) {
        this.tipo = tipo;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.planta);
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
        final Habitacion other = (Habitacion) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.planta, other.planta)) {
            return false;
        }
        return true;
    }

    
    
}
