package com.pizzapp.pizzap.service;

import com.pizzapp.pizzap.model.Ingrediente;
import com.pizzapp.pizzap.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    // Obtener todos los ingredientes
    public List<Ingrediente> getAllIngredientes() {
        return ingredienteRepository.findAll();
    }

    // Obtener un ingrediente por ID
    public Optional<Ingrediente> getIngredienteById(Long id) {
        return ingredienteRepository.findById(id);
    }

    // Crear un nuevo ingrediente
    public Ingrediente createIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    // Actualizar un ingrediente
    public Ingrediente updateIngrediente(Long id, Ingrediente ingredienteDetails) {
        Optional<Ingrediente> ingredienteOptional = ingredienteRepository.findById(id);
        if (ingredienteOptional.isPresent()) {
            Ingrediente ingrediente = ingredienteOptional.get();
            ingrediente.setNombre(ingredienteDetails.getNombre());
            ingrediente.setPrecioExtra(ingredienteDetails.getPrecioExtra());
            return ingredienteRepository.save(ingrediente);
        }
        return null;
    }

    // Eliminar un ingrediente
    public void deleteIngrediente(Long id) {
        ingredienteRepository.deleteById(id);
    }
}
