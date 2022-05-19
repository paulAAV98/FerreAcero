/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ejb;

import ec.edu.ups.entidades.FacturaDetalle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Usuario R
 */
public class FacturaDetalleFacade extends AbstractFacade<FacturaDetalle>{
    @PersistenceContext(name = "TestJPA")
    private EntityManager em;
    
    public FacturaDetalleFacade(){
        super(FacturaDetalle.class);
    }
                
    @Override
    protected EntityManager getEntityManager() {
        return em; 
    }
}
