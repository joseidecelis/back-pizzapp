package com.pizzapp.pizzap.service;

import com.pizzapp.pizzap.model.Pizza;
import com.pizzapp.pizzap.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> obtenerTodasLasPizzas() {
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> obtenerPizzaPorId(Long id) {
        return pizzaRepository.findById(id);
    }

    public Pizza guardarPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public void eliminarPizza(Long id) {
        pizzaRepository.deleteById(id);
    }
}
