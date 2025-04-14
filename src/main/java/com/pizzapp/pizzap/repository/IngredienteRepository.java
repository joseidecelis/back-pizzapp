package com.pizzapp.pizzap.repository;

import com.pizzapp.pizzap.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
    // Aquí puedes agregar consultas personalizadas si es necesario
}
