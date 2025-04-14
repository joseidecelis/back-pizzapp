package com.pizzapp.pizzap.controller;

import com.pizzapp.pizzap.model.Pizza;
import com.pizzapp.pizzap.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pizzas")
@CrossOrigin(origins = "*")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public List<Pizza> obtenerTodasLasPizzas() {
        return pizzaService.obtenerTodasLasPizzas();
    }

    @GetMapping("/{id}")
    public Optional<Pizza> obtenerPizzaPorId(@PathVariable Long id) {
        return pizzaService.obtenerPizzaPorId(id);
    }

    @PostMapping
    public Pizza crearPizza(@RequestBody Pizza pizza) {
        return pizzaService.guardarPizza(pizza);
    }

    @PutMapping("/{id}")
    public Pizza actualizarPizza(@PathVariable Long id, @RequestBody Pizza pizzaActualizada) {
        Optional<Pizza> pizzaExistente = pizzaService.obtenerPizzaPorId(id);
        if (pizzaExistente.isPresent()) {
            Pizza pizza = pizzaExistente.get();
            pizza.setNombre(pizzaActualizada.getNombre());
            pizza.setDescripcion(pizzaActualizada.getDescripcion());
            pizza.setPrecioBase(pizzaActualizada.getPrecioBase());
            pizza.setDisponible(pizzaActualizada.getDisponible());
            return pizzaService.guardarPizza(pizza);
        } else {
            throw new RuntimeException("Pizza no encontrada con id " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarPizza(@PathVariable Long id) {
        pizzaService.eliminarPizza(id);
    }
}
