/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Producto;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Named
@SessionScoped
public class CategoriaBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private CategoriaFacade categoriaFacade;
    private List<Categoria> list = new ArrayList<>();
    private int id;
    private String nombre;
    
    @PostConstruct
     public void init() {	
	list = categoriaFacade.findAll();
    }
    
    public String add() {	
        categoriaFacade.create(new Categoria(id, nombre));
        list = categoriaFacade.findAll();
	return null;
    }

    public String delete(Categoria c) {
	categoriaFacade.remove(c);
        list = categoriaFacade.findAll();
	return null;
    }

    public String edit(Categoria c) {
	c.setEditable(true);
	return null;
    }

    public String save(Categoria c) {
        categoriaFacade.edit(c);
        list = categoriaFacade.findAll();
	c.setEditable(false);
	return null;
    }

    public Categoria[] getList() {
	return list.toArray(new Categoria[0]);
    }

    public void setList(List<Categoria> list) {
	this.list = list;
    }

    public CategoriaFacade getCategoriaFacade() {
        return categoriaFacade;
    }

    public void setCategoriaFacade(CategoriaFacade categoriaFacade) {
        this.categoriaFacade = categoriaFacade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
