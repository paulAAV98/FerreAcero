/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.pojos.Row;
import ec.edu.ups.pojos.RowProducto;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Usuario
 */
@Named
@SessionScoped
public class CollectionBeanProducto implements Serializable {
    
     private static final long serialVersionUID = 1L;
    
    private Set<RowProducto> list = new HashSet<RowProducto>();
    private int id;
    private String nombre;
    private String marca;
    private double precio;
    private int stock;
    private Categoria categoria;

    public CollectionBeanProducto() {
	this.list.add(new RowProducto(4, "Foco LED alta potencia ", "EVLITE", 3.91, 15, 4));
        this.list.add(new RowProducto(5, "Reflector Led Slim ", "EVLITE", 9.98, 4, 4));
    }

    public String add() {
	this.list.add(new RowProducto(id, nombre, marca, precio, stock, categoria));
	return null;
    }

    public String delete(Row t) {
	this.list.remove(t);
	return null;
    }

    public String edit(Row t) {
	t.setEditable(true);
	return null;
    }

    public String save(Row t) {
	t.setEditable(false);
	return null;
    }

    public Row[] getList() {
	return list.toArray(new Row[0]);
    }

    public void setList(Set<Row> list) {
	this.list = list;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

  
}
