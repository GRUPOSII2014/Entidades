/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Fernando
 */
@Entity
@DiscriminatorValue("A")
public class Admin extends Trabajador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(length = 50)
    private String Despacho;

    public String getDespacho() {
        return Despacho;
    }

    public void setDespacho(String Despacho) {
        this.Despacho = Despacho;
    }
    
}
