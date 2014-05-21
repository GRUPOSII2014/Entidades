package Entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Alberto
 */
@Entity
@DiscriminatorValue("H")
public class TrabajadoresHospital extends Trabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(nullable = false)
    private Float horasTrabajo;

    public TrabajadoresHospital() {

    }

    public Float getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(Float horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

}
