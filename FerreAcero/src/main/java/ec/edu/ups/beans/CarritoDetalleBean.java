/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.entidades.CarritoCabecera;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.pojos.RowCarritoDetalle;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author USUARIO
 */

@Named
@SessionScoped
public class CarritoDetalleBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Set<RowCarritoDetalle> list = new HashSet<RowCarritoDetalle>();
    
    private int detalle_id;
    private int  detalle_cantidad;
    private double detalle_precio;
    private double detalle_iva;
    private double detalle_total;
    
    private Producto producto;
    private CarritoCabecera carritocabecera;
    
    public CarritoDetalleBean() {
        Producto p = new Producto();
        CarritoCabecera c = new CarritoCabecera();
	this.list.add(new RowCarritoDetalle(1, 13,15.4,12,20.4,c,p));
        this.list.add(new RowCarritoDetalle(2, 14,18.5,12,21.5,c,p));
        this.list.add(new RowCarritoDetalle(3, 10,20.4,12,22.3,c,p));
        this.list.add(new RowCarritoDetalle(4, 15,40.3,12,23.7,c,p));
    }

    public String add() {
	this.list.add(new RowCarritoDetalle(detalle_id, detalle_cantidad, detalle_precio, detalle_iva, detalle_total, carritocabecera, producto));
	return null;
    }

    public String delete(RowCarritoDetalle t) {
	this.list.remove(t);
	return null;
    }

    public String edit(RowCarritoDetalle t) {
	t.setEditable(true);
	return null;
    }

    public String save(RowCarritoDetalle t) {
	t.setEditable(false);
	return null;
    }



}
