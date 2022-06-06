/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Bernardo
 */
@Entity
public class Factura_Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    
    private double valor_unitario;
    
    private int catidad;
    
    @OneToOne
    @JoinColumn
    private  Producto producto;
    
    @ManyToOne
    @JoinColumn
    private Factura factura;

    public Factura_Detalle() {
    }

    public Factura_Detalle(int id, double valor_unitario, int catidad, Producto producto, Factura factura) {
        this.id = id;
        this.valor_unitario = valor_unitario;
        this.catidad = catidad;
        this.producto = producto;
        this.factura = factura;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura_Detalle)) {
            return false;
        }
        Factura_Detalle other = (Factura_Detalle) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.entidades.Factura_Detalle[ id=" + id + " ]";
    }
    
}
