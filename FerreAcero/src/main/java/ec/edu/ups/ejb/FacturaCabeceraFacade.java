/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ejb;

import ec.edu.ups.entidades.FacturaCabecera;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Usuario R
 */
@Stateless
public class FacturaCabeceraFacade extends AbstractFacade<FacturaCabecera>{
    
    @PersistenceContext(name = "TestJPA")
    private EntityManager em;
    
    public FacturaCabeceraFacade(){
        super(FacturaCabecera.class);
    }
                
    @Override
    protected EntityManager getEntityManager() {
        return em; 
    }
}
