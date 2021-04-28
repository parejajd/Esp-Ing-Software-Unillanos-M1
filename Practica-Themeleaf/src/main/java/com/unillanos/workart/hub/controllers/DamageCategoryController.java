package com.unillanos.workart.hub.controllers;

import com.unillanos.workart.hub.entities.DamageCategory;
import com.unillanos.workart.hub.repositories.DamageCategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class DamageCategoryController {
    private final DamageCategoryRepository repository;

    public DamageCategoryController(DamageCategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/damage-categories")
    public List<DamageCategory> get() {
        return repository.findAll();
    }

    @PatchMapping("/damage-categories")
    public DamageCategory update(@RequestBody DamageCategory data) {
        if (repository.findById(data.getId()).isPresent()) {
            DamageCategory dataOld = repository.findById(data.getId()).get();
            dataOld.setFigure(data.getFigure());
            dataOld.setType(data.getType());
            dataOld.setTypeOfDamage(data.getTypeOfDamage());
            repository.save(dataOld);
            return dataOld;
        } else
            throw new NoSuchElementException("La Categoria no existe");
    }
}
