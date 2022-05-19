/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.pojos;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author USUARIO
 */
public class RowCarritoCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int carr_id;
    @Temporal(TemporalType.DATE)
    private GregorianCalendar carr_fecha;
    
    private boolean editable;

    public RowCarritoCabecera(int carr_id, GregorianCalendar carr_fecha) {
        this.carr_id = carr_id;
        this.carr_fecha = carr_fecha;
    }

   

    public int getCarr_id() {
        return carr_id;
    }

    public void setCarr_id(int carr_id) {
        this.carr_id = carr_id;
    }

    public GregorianCalendar getCarr_fecha() {
        return carr_fecha;
    }

    public void setCarr_fecha(GregorianCalendar carr_fecha) {
        this.carr_fecha = carr_fecha;
    }

 

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    

  
}
