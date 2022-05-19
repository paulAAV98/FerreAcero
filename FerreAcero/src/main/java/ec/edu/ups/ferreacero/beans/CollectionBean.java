/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ferreacero.beans;

import ec.edu.ups.pojos.Row;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Gabus
 */
@Named
@SessionScoped
public class CollectionBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Set<Row> list = new HashSet<Row>();
    private int id;
    private String  nombre;
    private String apellido;
    private String clave;
    private String cedula;
    private String direccion;
    private String email;
    private String telefono;
    private boolean editable;

    public CollectionBean() {
	this.list.add(new Row(1, "Sebastian","Cumbe","123456","0107218356", "Baños","juan@gmail.com","0959147219"));
        this.list.add(new Row(2, "Jose","Cuenca","123456","0107218356", "Baños","juan@gmail.com","0959147219"));
        this.list.add(new Row(3, "Juan","Loja","123456","0107218356", "Baños","juan@gmail.com","0959147219"));
        this.list.add(new Row(4, "Maria","Quito","123456","0107218356", "Baños","juan@gmail.com","0959147219"));
    }

    public String add() {
	this.list.add(new Row(id, nombre, apellido, clave, cedula, direccion, email, telefono));
	return null;
    }

    public String delete(Row t) {
	this.list.remove(t);
	return null;
    }

    public String edit(Row t) {
	t.setEditable(true);
	return null;
    }

    public String save(Row t) {
	t.setEditable(false);
	return null;
    }

    public Row[] getList() {
	return list.toArray(new Row[0]);
    }

    public void setList(Set<Row> list) {
	this.list = list;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    
}
