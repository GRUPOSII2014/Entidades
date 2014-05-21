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
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Alberto
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="disc",discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")
@NamedQueries({
        @NamedQuery(name = "Persona.all", query = "select p from Persona p"),
        @NamedQuery(name = "Persona.dni", query = "select p from Persona p where p.DNI = :dni"),
        @NamedQuery(name = "Persona.nss", query = "select p from Persona p where p.numSegSocial = :nss"),
        @NamedQuery(name = "Persona.correo", query = "select p from Persona p where p.email = :correo"),
        @NamedQuery(name = "Login.Comprueba", query = "select p from Persona p where p.numSegSocial = :nss and p.password = :passwd"),
        @NamedQuery(name = "Persona.completar", query = "select p from Persona p where p.nombre like :buscado or p.apellido1 like :buscado or p.apellido2 like :buscado or p.DNI like :buscado"),
        @NamedQuery(name = "Trabajador.completar", query = "select t from Trabajador t where t.nombre like :buscado or t.apellido1 like :buscado or t.apellido2 like :buscado or t.DNI like :buscado"),
        @NamedQuery(name = "Persona", query = "select p from Persona p where p.numSegSocial = :nss"),
        @NamedQuery(name = "listaAlertas", query = "select a from Persona p join p.alertas a where p.numSegSocial = :nss and a.fecha >= :hora order by a.fecha"),
        @NamedQuery(name = "listaMensajes", query = "select m from Mensaje m where m.from = :nss or m.to = :nss order by m.fecha desc")
})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer numSegSocial;
    @Column(nullable = true, length = 9, unique = true)
    private String DNI;
    @Column(nullable = false, length = 40)
    private String nombre;
    @Column(nullable = false, length = 40)
    private String apellido1;
    @Column(nullable = false, length = 30)
    private String password;
    @Column(length = 40)
    private String apellido2;
    @Column(length = 100, nullable = true, unique = true)
    private String email;
    @Column(nullable = false, length = 40)
    private String estadoCivil;
    @Column(nullable = true)
    private String telefono;
    @Column(nullable = false, length = 400)
    private String direccion;
    @Column(nullable = false)
    private Integer codigoPostal;
    @Column(nullable = false, length = 40)
    private String ciudad;
    @Column(nullable = false, length = 40)
    private String pais;
    @Column(nullable = false, length = 10)
    private String sexo;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(insertable = false, updatable = false) 
    private String disc;

    @OneToMany
    @JoinColumn(name = "personaTratamiento")
    private List<Tratamiento> tratamiento;
    @OneToMany(mappedBy = "persona")
    private List<Cita> citas;

    @OneToOne(mappedBy = "paciente")
    private Cama cama;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "alertas",
            joinColumns = @JoinColumn(name = "persona_fk"),
            inverseJoinColumns = @JoinColumn(name = "alerta_fk"))
    private List<Alerta> alertas;
    @OneToOne(mappedBy = "persona")
    private HistoriaClinica historiaclinica;
    @ManyToOne
    @JoinColumn(name = "medico")
    private Medico medicoCabecera;

    public Persona() {

    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public String getSexo() {
        return sexo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.numSegSocial);
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.numSegSocial, other.numSegSocial)) {
            return false;
        }
        return true;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Medico getMedicoCabecera() {
        return medicoCabecera;
    }

    public void setMedicoCabecera(Medico medicoCabecera) {
        this.medicoCabecera = medicoCabecera;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
    }

    public HistoriaClinica getHistoriaclinica() {
        return historiaclinica;
    }

    public void setHistoriaclinica(HistoriaClinica historiaclinica) {
        this.historiaclinica = historiaclinica;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Tratamiento> getTratamiento() {
        return tratamiento;
    }

    public Cama getCama() {
        return cama;
    }


    public void setTratamiento(List<Tratamiento> tratamiento) {
        this.tratamiento = tratamiento;
    }

    public void setCama(Cama cama) {
        this.cama = cama;
    }

    public Integer getNumSegSocial() {
        return numSegSocial;
    }

    public void setNumSegSocial(Integer numSegSocial) {
        this.numSegSocial = numSegSocial;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }
    
}
