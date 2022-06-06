/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.Detalle_FacturaFacade;
import ec.edu.ups.ejb.FacdetalleFacade;
import ec.edu.ups.ejb.FacturaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Factura;
import ec.edu.ups.entidades.Factura_Detalle;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Sucursal;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Usuario
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacdetalleBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @EJB
    private FacturaFacade facturaFacade;
    
    @EJB
    private Detalle_FacturaFacade detalle_FacturaFacade;
    
    @EJB
    private ProductoFacade productoFacade;
    private double cantidad;
    private double precio;
    private String nombrex;
    private double subtotal;
    private fac_detalle fac;
    private double total;
    
    private int id_producto;
    private int id;
    
    private Factura facx;
    private String nombre;
    private int numero;
    private Date fecha;
    private Persona persona;
   
    private String nombreCliente;
    private String cedula;

    
    Producto pro;
    
    
        private List<Factura> list = new ArrayList<>();
        
        private List<fac_detalle> lista = new ArrayList<>();
        
        private List<Factura_Detalle>listad=new ArrayList<>();
         
        

    
    //
        
        @PostConstruct
    public void init() {	
	list = facturaFacade.findAll();
        
        listad=detalle_FacturaFacade.findAll();
        
    }
    
    public String add() {
       
        //System.out.println(pro.getNombre()+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //Producto suc1=sucf.getSucursalN(extra1());
        pro=facturaFacade.getproductoN(extra1());
        fac=new fac_detalle();
        fac.setCantidad(getCantidad());
        fac.setNombrex(pro.getNombre());
        //System.out.println(pro.getNombre()+"xxxxxxxxxxxxxxxxxxxxxxxxxxx");
        fac.setPrecio(pro.getPrecio());
        fac.setSubtotal(pro.getPrecio()*getCantidad());
        fac.setId_producto(pro.getId());
        
        
        lista.add(fac);
        Calcular();
         
	return null;
    }
public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        numero=codigofac1()+1;
        return numero;
    }
     
    
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setFac(fac_detalle fac) {
        this.fac = fac;
    }

    public void setNombrex(String nombrex) {
        this.nombrex = nombrex;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getNombrex() {
        return nombrex;
    }

    public double getPrecio() {
        return precio;
    }

    public Producto getPro() {
        return pro;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public List<fac_detalle> getList() {
        return lista;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
public String extra1(){
        String palabra=getNombrex();
        int acum=1;
        int acum1=0;
        String nue="";
        for (int i = 0; i < palabra.length(); i++) {
            
            if(palabra.substring(i, i+1).equals("}")){
                acum1=1;
                
                
            
            }
            
            if(acum==3 && acum1==0){
                nue=nue.concat(palabra.substring(i,i+1));
                
            
            }
            if(palabra.substring(i, i+1).equals("=")){
                
                acum++;
            
            
            }
            
            
            
            
        }
        
        
     return nue;   
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void Calcular(){
        total=0;
        for (int i = 0; i < lista.size(); i++) {
          
            total=total+lista.get(i).getSubtotal();
            
        }
        
    }
    
    
    public double getTotal() {
        return total;
    }
   
    
   
     
      public void buscarCliente(){
        persona = facturaFacade.getpersonaN(getCedula());
          //System.out.println("7777777777777777777777777777777777777777777777777777777777777"+persona.getPer_id());
    }
      
      
       public int buscarFactura(int id1){
        facx = facturaFacade.getFactura(id1);
        int idx=facx.getId();
          //System.out.println("7777777777777777777777777777777777777777777777777777777777777"+persona.getPer_id());
    return idx;
       }

    public String getCedula() {
        return cedula;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
      
       public String add_factura() {
         java.util.Date utilDate = new java.util.Date();
       java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
       //facturaFacade.create(new Factura(15,200, sqlDate,2,2, persona));
       //int idfac=codigoidfac();
           //System.out.println("+0000000000000000000000000000000000000000000000000"+idfac);
       facturaFacade.create(new Factura(codigoidfac1()+1,codigofac1()+1, sqlDate,getTotal()+(getTotal()*0.12),getTotal(), persona));
       //categoriaFacade.create(new Factura(id_producto, id_producto, sqlDate, total, subtotal));
       facturaFacade.findAll();
       agregar_detalle();
      
       
           System.out.println("mamamamamamamammamamamamama "+codigoidfac1());
      
	return null;
    } 

    private void agregar_detalle() {
       
       for (int i = 0; i < lista.size(); i++) {
           
            /*Producto px=new Producto();
          
            px.setId(lista.get(i).id_producto);*/
            
            pro=facturaFacade.getproductoN(lista.get(i).getNombrex());
            
           
           
            
           
            int cant=(int) lista.get(i).getCantidad();
             System.out.println(buscarFactura(codigoidfac1()));
            detalle_FacturaFacade.create(new Factura_Detalle(codigoidfac_detalle1()+1,lista.get(i).getPrecio(),cant,pro,facx));
           detalle_FacturaFacade.findAll();
           pro.setStock(pro.getStock()-cant);
           productoFacade.edit(pro);
           productoFacade.findAll();
           
            
        }
        
        
    }
    
  
   
   public int codigoidfac_detalle1(){
        
   
   List<Integer>lis=facturaFacade.get_id_fac_detalle();
  int n=0;
   if(lis.size()!=0){
   
        for (int i = 1; i < lis.size(); i++) {
            n=lis.get(i-1);
           if(n<lis.get(i)){
               n=lis.get(i);
           }
   
      
    
        }
   }
        return n;
        
   }
   
   public int codigoidfac1(){
        
   
           
   List<Integer>lis=facturaFacade.get_id_fac();
   int n=0;
   if(lis.size()!=0){
   
        for (int i = 1; i < lis.size(); i++) {
            n=lis.get(i-1);
           if(n<lis.get(i)){
               n=lis.get(i);
           }
           
       }
       }
   
      
    
   
        return n;
   
   }
     
   public int codigofac1(){
        
   
           
   List<Integer>lis=facturaFacade.get_cod_fac();
   int n=0;
   if(lis.size()!=0){
   
        for (int i = 1; i < lis.size(); i++) {
            n=lis.get(i-1);
           if(n<lis.get(i)){
               n=lis.get(i);
           }
           
       }
       }
   
      
    
   
        return n;
   
   }

    private void actulizar_producto() {
        productoFacade.edit(pro);
        productoFacade.findAll();
    }
    
}
