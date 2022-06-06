/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ejb;

import ec.edu.ups.beans.fac_detalle;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Factura;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;

/**
 *
 * @author Usuario
 */
@Stateless
public class FacdetalleFacade extends AbstractFacade<fac_detalle> {
    
    @PersistenceContext(name="FerreAcero")
    private EntityManager em;
    
    public FacdetalleFacade(){
        super(fac_detalle.class);
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
        
        userx.setPer_nombre(user.getPer_nombre());
        userx.setPer_apellido(user.getPer_apellido());
        userx.setPer_direccion(user.getPer_direccion());
        userx.setPer_email(user.getPer_email());
        userx.setPer_telefono(user.getPer_telefono());
        
        
        return userx;
    }
    
   
    public Producto getproductoN(String nombre){
        int idx=1;
        System.out.println("Entro consulta-----------------------------------------------"+nombre);
        String jpql = "SELECT u FROM Producto u WHERE u.nombre = '" +nombre+"'" ;
        
        Producto  user = (Producto) em.createQuery(jpql).getSingleResult();
        Producto userx=new Producto();
        
        userx.setNombre(user.getNombre());
        userx.setPrecio(user.getPrecio());
        
        
        
        return userx;
    }
    
}
