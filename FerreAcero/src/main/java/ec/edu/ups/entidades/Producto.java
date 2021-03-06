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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import java.io.Serializable;


/**
 *
 * @author Bernardo
 */
@Entity
public class Producto implements Serializable {
    
    //------------------------------------------------ManyToOne
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String marca;
    private double precio;
    private int stock;
    @ManyToOne
    @JoinColumn
    private Categoria categoria;
    @ManyToOne
    @JoinColumn
    private Sucursal sucursal;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "producto")
    private Factura_Detalle fac;
    
    @Transient
    private boolean editable;
     @Transient
    private int cat;
      @Transient
    private int suc;
    

       public Producto() {
        super();
    }
    
    public Producto(int id, String nombre, String marca, double precio, int stock, Categoria categoria, Sucursal sucursal) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.sucursal = sucursal;
    }
    
    @Override
    public Producto clone(){
        return new Producto(getId(), getNombre(), getMarca(), getPrecio(), getStock(),
        getCategoria(), getSucursal());
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

        
    
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object other) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (other == null) {
            return false;
        }
        if(getClass() != other.getClass()){
           return false; 
        }
        return other.hashCode() == this.hashCode();
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getStock() {
        return stock;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setSucursal(Sucursal sucursal) {
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

   /* @Override
    public String toString() {
<<<<<<< HEAD
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", precio=" + precio + ", stock=" + stock + ", categoria=" + categoria + ", sucursal=" + sucursal + '}';
    }
    
    @Override*/
        
    public String toString() {
=======
>>>>>>> d186f221cb8b32c5206f62d6804d707b6845ef93
        return "Producto{" + "id=" + id + ", nombre=" + nombre + '}';
    }

   
    
   
    
    
}

