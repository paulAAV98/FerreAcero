/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ejb;

import ec.edu.ups.entidades.Categoria;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;

/**
 *
 * @author Usuario
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {
    
    @PersistenceContext(name="FerreAcero")
    private EntityManager em;
    
    public CategoriaFacade(){
        super(Categoria.class);
    }
    
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
    public Optional<Categoria> opcional(Long id) {
        return Optional.ofNullable(porId(id));
    }
    public Categoria porId(Long id) {
        return em.find(Categoria.class, id);
    }
    public void eliminar(Long id) {
        Categoria categoria = porId(id);
        em.remove(categoria);
    }
    
    public Categoria getCategoriaN(String nombre){
        int idx=1;
        System.out.println("Entro consulta-----------------------------------------------");
        String jpql = "SELECT u FROM Categoria u WHERE u.nombre = '" +nombre+"'" ;
        
        Categoria user = (Categoria) em.createQuery(jpql).getSingleResult();
        Categoria userx=new Categoria();
        
        userx.setId(user.getId());
        
        return userx;
    }
    
}
