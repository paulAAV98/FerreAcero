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
      
    
}
