/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ejb;

import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Factura;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Usuario
 */
@Stateless
public class FacturaFacade extends AbstractFacade<Factura> {
    
    @PersistenceContext(name="FerreAcero")
    private EntityManager em;
    
    public FacturaFacade(){
        super(Factura.class);
    }
    
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
    
    
    public Persona getpersonaN(String cedula){
        int idx=1;
        System.out.println("Entro consulta-----------------------------------------------");
        String jpql = "SELECT u FROM Persona u WHERE u.per_cedula = '" +cedula+"'" ;
        
        Persona  user = (Persona) em.createQuery(jpql).getSingleResult();
        Persona userx=new Persona();
        userx.setPer_id(user.getPer_id());
        userx.setPer_nombre(user.getPer_nombre());
        userx.setPer_apellido(user.getPer_apellido());
        userx.setPer_direccion(user.getPer_direccion());
        userx.setPer_email(user.getPer_email());
        userx.setPer_telefono(user.getPer_telefono());
        
        
        return userx;
    }
    
   
    public Producto getproductoN(String nombre){
       //nombre="Clavos";
        System.out.println("Entro consulta-----------------------------------------------"+nombre);
        String jpql = "SELECT u FROM Producto u WHERE u.nombre = '" +nombre+"'" ;
        
        Producto  user = (Producto) em.createQuery(jpql).getSingleResult();
        Producto userx=new Producto();
        
        userx.setNombre(user.getNombre());
        userx.setPrecio(user.getPrecio());
        userx.setId(user.getId());
        userx.setMarca(user.getMarca());
        userx.setCategoria(user.getCategoria());
        userx.setStock(user.getStock());
        user.setSucursal(user.getSucursal());
        
        
        
        return userx;
    }
    
    public int id_fac1(){
       //nombre="Clavos";
        
        String jpql = "SELECT max(id) as id FROM Factura " ;
        
        Factura user = (Factura) em.createQuery(jpql).getSingleResult();
        
        int id=user.getId();
        
        
        
        return id;
    }
    
    public List<Integer> get_id_fac(){
          String jpql = "SELECT u.id FROM Factura u";
          List<Integer>res=em.createQuery(jpql).getResultList();
        return res;
         
     }
    
    public List<Integer> get_id_fac_detalle(){
          String jpql = "SELECT u.id FROM Factura_Detalle u";
          List<Integer>res=em.createQuery(jpql).getResultList();
        return res;
         
     }
    
    
    public Factura getFactura(int id){
       
        System.out.println("Entro consulta-----------------------------------------------");
        String jpql = "SELECT u FROM Factura u WHERE u.id = " +id+"" ;
        
        Factura  user = (Factura) em.createQuery(jpql).getSingleResult();
        Factura userx=new Factura();
        userx.setId(user.getId());
        System.out.println(userx.getId());
        
        
        
        return userx;
    }
    
    
    public List<Integer> get_cod_fac(){
          String jpql = "SELECT u.numero FROM Factura u";
          List<Integer>res=em.createQuery(jpql).getResultList();
        return res;
         
     }
    
    
    
    
}
