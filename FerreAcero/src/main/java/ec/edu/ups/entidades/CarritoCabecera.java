/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Bernardo
 */
@Entity
public class CarritoCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int carr_id;
    private Date  carr_fecha;
   
    
    @Transient
    private boolean editable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "CarritoCabecera")
    private CarritoDetalle CarritoDetalle;
    

    public int getCarr_id() {
        return carr_id;
    }

    public void setCarr_id(int carr_id) {
        this.carr_id = carr_id;
    }

    public Date getCarr_fecha() {
        return carr_fecha;
    }

    public void setCarr_fecha(Date carr_fecha) {
        this.carr_fecha = carr_fecha;
    }

    public CarritoDetalle getCarritoDetalle() {
        return CarritoDetalle;
    }

    public void setCarritoDetalle(CarritoDetalle CarritoDetalle) {
        this.CarritoDetalle = CarritoDetalle;
    }

    
    
    
    
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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
        if (!(object instanceof CarritoCabecera)) {
            return false;
        }
        CarritoCabecera other = (CarritoCabecera) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.entidades.CarritoCabecera[ id=" + id + " ]";
    }
    
}
