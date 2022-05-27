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
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
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
    private int cat;
    private int suc;
    
    @PostConstruct
    public void init() {	
	list = productoFacade.findAll();
    }
    
    public String add() {
         Categoria cat1=new Categoria();
         cat1.setId(getCat());
         Sucursal suc1=new Sucursal();
         suc1.setId(getSuc());
         this.sucursal=suc1;
         this.categoria=cat1;
        productoFacade.create(new Producto(id, nombre, marca, precio, stock, categoria, sucursal));
        System.out.println(categoria.getId());
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
        categoria.setId(getCat());
        this.categoria = categoria;
    }

    public Sucursal getSucursal() {
        
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        sucursal.setId(getSuc());
        this.sucursal = sucursal;
    }


    

    public void setCat(int cat) {
 
        this.cat = cat;
       
    }

    public int getCat() {
        return cat;
    }

    public void setSuc(int suc) {
        
        this.suc = suc;
        
        
    }

    public int getSuc() {
        return suc;
    }
    
    

    
}
