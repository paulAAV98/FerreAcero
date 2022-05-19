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
import java.util.HashSet;
import java.util.Set;
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
    private Set<CarritoDetalle> carritodetalle = new HashSet<CarritoDetalle>();

    public CarritoCabecera() {
    }

    public CarritoCabecera(int carr_id, Date carr_fecha) {
        this.carr_id = carr_id;
        this.carr_fecha = carr_fecha;
    
    }
   

    public void addCarritoDetalle(CarritoDetalle carritodetalle){
        this.carritodetalle.add(carritodetalle);
    }
    
    public void removeCarritoDetalle(CarritoDetalle carritodetalle){
        this.carritodetalle.remove(carritodetalle);
    }
   
    
}
