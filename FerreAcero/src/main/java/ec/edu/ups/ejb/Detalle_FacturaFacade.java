/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ejb;

import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Factura_Detalle;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;

/**
 *
 * @author Usuario
 */
@Stateless
public class Detalle_FacturaFacade extends AbstractFacade<Factura_Detalle> {
    
    @PersistenceContext(name="FerreAcero")
    private EntityManager em;
    
    public Detalle_FacturaFacade(){
        super(Factura_Detalle.class);
    }
    
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
    
   
    
}
