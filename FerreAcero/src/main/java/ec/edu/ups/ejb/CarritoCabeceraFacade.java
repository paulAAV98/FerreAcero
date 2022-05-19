/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ejb;

import ec.edu.ups.entidades.CarritoCabecera;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author USUARIO
 */
@Stateless
public class CarritoCabeceraFacade extends AbstractFacade<CarritoCabecera> {
    
    @PersistenceContext(name="FerreAcero")
    private EntityManager em;
    
    
    public CarritoCabeceraFacade(){
        super(CarritoCabecera.class);
    }
    
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
}
