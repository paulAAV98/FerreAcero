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
        String jpql = "SELECT u FROM Persona u WHERE u.cedula = '" +cedula+"'" ;
        
        Persona  user = (Persona) em.createQuery(jpql).getSingleResult();
        Persona userx=new Persona();
        
        userx.setNombre(user.getNombre());
        userx.setApellido(user.getApellido());
        userx.setDireccion(user.getDireccion());
        userx.setEmail(user.getEmail());
<<<<<<< HEAD
        userx.setTelefono(user.getTelefono());
=======
            userx.setTelefono(user.getTelefono());
>>>>>>> d186f221cb8b32c5206f62d6804d707b6845ef93
        
        
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
