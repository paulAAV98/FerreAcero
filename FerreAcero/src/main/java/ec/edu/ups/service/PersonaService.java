/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.service;

import ec.edu.ups.entidades.Persona;
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
public class PersonaService {
    
    private List<Persona> personas;
    
    @PostConstruct
    public void init(){
        personas = new ArrayList();
        
        
    }
    
    public List<Persona> getProductos(){
        return new ArrayList<>(personas);
    }
    
    public List<Persona> getProductos(int size){
        
     if (size > personas.size()) {
            Random rand = new Random();

            List<Persona> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(personas.size());
                randomList.add(personas.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(personas.subList(0, size));
        }
    }
     
     public List<Persona> getClonedSucursales(int size) {
        List<Persona> results = new ArrayList<>();
        List<Persona> originals = getProductos(size);
        for (Persona original : originals) {
            results.add(original.clone());
        }
        return results;
    }

}

    

