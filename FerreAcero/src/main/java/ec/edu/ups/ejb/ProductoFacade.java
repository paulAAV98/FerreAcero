/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ejb;

import ec.edu.ups.entidades.Producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {
    
    @PersistenceContext(name="FerreAcero")
    private EntityManager em;
    
    public ProductoFacade(){
        super(Producto.class);
    }

    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
    
    
}
