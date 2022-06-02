/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.service;

import ec.edu.ups.entidades.Categoria;
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
public class SucursalService {
    
    private List<Sucursal> sucursales;
    
    @PostConstruct
    public void init(){
        sucursales = new ArrayList<>();
        
        sucursales.add(new Sucursal(1, "Diseño", "33", "45"));
        sucursales.add(new Sucursal(1, "Batan", "80", "65"));
    }
    
    public List<Sucursal> getSucursales() {
        return new ArrayList<>(sucursales);
    }

    public List<Sucursal> getSucursales(int size) {

        if (size > sucursales.size()) {
            Random rand = new Random();

            List<Sucursal> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(sucursales.size());
                randomList.add(sucursales.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(sucursales.subList(0, size));
        }

    }

    public List<Sucursal> getClonedSucursales(int size) {
        List<Sucursal> results = new ArrayList<>();
        List<Sucursal> originals = getSucursales(size);
        for (Sucursal original : originals) {
            results.add(original.clone());
        }
        return results;
    }

    
}
