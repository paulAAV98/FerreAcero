/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ejb;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author Bernardo
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass=entityClass;

    }

    protected abstract EntityManager getEntityManager();

    public void create(T enity) {
        getEntityManager().persist(enity);

    }

    public void edit(T enity) {

        getEntityManager().merge(enity);

    }

    public void remove(T enity) {

        getEntityManager().remove(getEntityManager().merge(enity));

    }

    public T find(Object id) {

        return getEntityManager().find(entityClass, id);

    }
    
    public List<T> findAll() {
	CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
	cq.select(cq.from(entityClass));
	return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
	CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
	cq.select(cq.from(entityClass));
        Query q = getEntityManager().createQuery(cq);
	q.setMaxResults(range[1] - range[0]);
	q.setFirstResult(range[0]);
	return q.getResultList();
    }

    public int count() {
	CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(entityClass);
	cq.select(getEntityManager().getCriteriaBuilder().count(rt));
	Query q = getEntityManager().createQuery(cq);
	return ((Long) q.getSingleResult()).intValue();
    }
}