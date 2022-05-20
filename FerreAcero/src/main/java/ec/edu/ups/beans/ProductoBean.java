/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Sucursal;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Named
@SessionScoped
public class ProductoBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private ProductoFacade productoFacade;
    private List<Producto> list = new ArrayList<>();
    private int id;
    private String nombre;
    private String marca;
    private double precio;
    private int stock;
    private Categoria categoria;
    private Sucursal sucursal;
    @PostConstruct
    public void init() {	
	list = productoFacade.findAll();
    }
    
    public String add() {	
        productoFacade.create(new Producto(id, nombre, marca, precio, stock, categoria, sucursal));
        list = productoFacade.findAll();
	return null;
    }

    public String delete(Producto prod) {
	productoFacade.remove(prod);
        list = productoFacade.findAll();
	return null;
    }

    public String edit(Producto prod) {
	prod.setEditable(true);
	return null;
    }

    public String save(Producto prod) {
        productoFacade.edit(prod);
        list = productoFacade.findAll();
	prod.setEditable(false);
	return null;
    }

    public Producto[] getList() {
	return list.toArray(new Producto[0]);
    }

    public void setList(List<Producto> list) {
	this.list = list;
    }

    public ProductoFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
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

    public Sucursal getSucursal() {
        
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    
    
    
}
