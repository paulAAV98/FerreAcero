/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ejb;

import ec.edu.ups.entidades.CarritoDetalle;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author USUARIO
 */

@Stateless
public class CarritoDetalleFacade extends AbstractFacade<CarritoDetalle> {
    
    @PersistenceContext(name="FerreAcero")
    private EntityManager em;
    
    public CarritoDetalleFacade(){
        super(CarritoDetalle.class);
    }
    
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
}
