/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.service;

import ec.edu.ups.entidades.Categoria;
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
public class CategoriaService {
    
    private List<Categoria> categorias;
    
    @PostConstruct
    public void init(){
        categorias = new ArrayList<>();
        
        categorias.add(new Categoria(1, "Diseño"));
        categorias.add(new Categoria(2, "Pintura"));
        
    }
    
    public List<Categoria> getCategorias() {
        return new ArrayList<>(categorias);
    }

    public List<Categoria> getCategorias(int size) {

        if (size > categorias.size()) {
            Random rand = new Random();

            List<Categoria> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(categorias.size());
                randomList.add(categorias.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(categorias.subList(0, size));
        }

    }

    public List<Categoria> getClonedCategorias(int size) {
        List<Categoria> results = new ArrayList<>();
        List<Categoria> originals = getCategorias(size);
        for (Categoria original : originals) {
            results.add(original.clone());
        }
        return results;
    }

    
}
