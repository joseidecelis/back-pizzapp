package com.pizzapp.pizzap.controller;

import com.pizzapp.pizzap.model.Ingrediente;
import com.pizzapp.pizzap.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    // Obtener todos los ingredientes
    @GetMapping
    public List<Ingrediente> getAllIngredientes() {
        return ingredienteService.getAllIngredientes();
    }

    // Obtener ingrediente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> getIngredienteById(@PathVariable Long id) {
        Optional<Ingrediente> ingrediente = ingredienteService.getIngredienteById(id);
        return ingrediente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear nuevo ingrediente
    @PostMapping
    public ResponseEntity<Ingrediente> createIngrediente(@RequestBody Ingrediente ingrediente) {
        Ingrediente createdIngrediente = ingredienteService.createIngrediente(ingrediente);
        return new ResponseEntity<>(createdIngrediente, HttpStatus.CREATED);
    }

    // Actualizar ingrediente
    @PutMapping("/{id}")
    public ResponseEntity<Ingrediente> updateIngrediente(@PathVariable Long id, @RequestBody Ingrediente ingredienteDetails) {
        Ingrediente updatedIngrediente = ingredienteService.updateIngrediente(id, ingredienteDetails);
        return updatedIngrediente != null ? ResponseEntity.ok(updatedIngrediente) : ResponseEntity.notFound().build();
    }

    // Eliminar ingrediente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngrediente(@PathVariable Long id) {
        ingredienteService.deleteIngrediente(id);
        return ResponseEntity.noContent().build();
    }
}
