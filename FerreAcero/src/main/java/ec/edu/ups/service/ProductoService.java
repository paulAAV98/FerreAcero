/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.service;

import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Sucursal;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Usuario
 */
@Named
@ApplicationScoped
public class ProductoService {
    
    private List<Producto> productos;
    
    @PostConstruct
    public void init(){
        productos = new ArrayList();
        
        
    }
    
    public List<Producto> getProductos(){
        return new ArrayList<>(productos);
    }
    
    public List<Producto> getProductos(int size){
        
     if (size > productos.size()) {
            Random rand = new Random();

            List<Producto> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(productos.size());
                randomList.add(productos.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(productos.subList(0, size));
        }
    }
     
     public List<Producto> getClonedSucursales(int size) {
        List<Producto> results = new ArrayList<>();
        List<Producto> originals = getProductos(size);
        for (Producto original : originals) {
            results.add(original.clone());
        }
        return results;
    }

}
