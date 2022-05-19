package ec.edu.ups.entidades;


import ec.edu.ups.entidades.Persona;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Persistence;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.GregorianCalendar;

@Entity
public class Rols {
    @Id
    @GeneratedValue
    private int rol_id;
    private String  rol_nom_rol;
    @OneToOne
    @JoinColumn
    private Persona persona;

    public Rols() {
    }

    
    
    public Rols(int id, String nom_rol, Persona persona) {
        this.rol_id = id;
        this.rol_nom_rol = nom_rol;
        this.persona = persona;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public void setRol_nom_rol(String rol_nom_rol) {
        this.rol_nom_rol = rol_nom_rol;
    }

    public void setRol_persona(Persona rol_persona) {
        this.persona = rol_persona;
    }

    public int getRol_id() {
        return rol_id;
    }

    public String getRol_nom_rol() {
        return rol_nom_rol;
    }

    public Persona getRol_persona() {
        return persona;
    }

    
    
    
    
}
