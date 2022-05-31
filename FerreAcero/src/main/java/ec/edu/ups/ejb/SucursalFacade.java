/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ejb;

import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Sucursal;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;

/**
 *
 * @author Usuario
 */
@Stateless
public class SucursalFacade extends AbstractFacade<Sucursal> {
    
    @PersistenceContext(name="FerreAcero")
    private EntityManager em;
    
    public SucursalFacade(){
        super(Sucursal.class);
    }
    
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
    public Optional<Sucursal> opcional(Long id) {
        return Optional.ofNullable(porId(id));
    }
    public Sucursal porId(Long id) {
        return em.find(Sucursal.class, id);
    }
    public void eliminar(Long id) {
        Sucursal sucursal = porId(id);
        em.remove(sucursal);
    }
    
      
    public Sucursal getSucursalN(String nombre){
        int idx=1;
        System.out.println("Entro consulta-----------------------------------------------");
        String jpql = "SELECT u FROM Sucursal u WHERE u.nombre = '" +nombre+"'" ;
        
        Sucursal user = (Sucursal) em.createQuery(jpql).getSingleResult();
        Sucursal userx=new Sucursal();
        
        userx.setId(user.getId());
        
        return userx;
    }
    
}
