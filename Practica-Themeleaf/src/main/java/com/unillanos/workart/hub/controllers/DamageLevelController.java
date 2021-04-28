package com.unillanos.workart.hub.controllers;

import com.unillanos.workart.hub.entities.DamageCategory;
import com.unillanos.workart.hub.entities.DamageLevel;
import com.unillanos.workart.hub.repositories.DamageCategoryRepository;
import com.unillanos.workart.hub.repositories.DamageLevelRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
public class DamageLevelController {

    private final DamageLevelRepository repository;

    public DamageLevelController(DamageLevelRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/damage-level")
    public List<DamageLevel> get() {
        return repository.findAll();
    }

    @PatchMapping("/damage-level")
    public DamageLevel update(@RequestBody DamageLevel data) {
        if (repository.findById(data.getId()).isPresent()) {
            DamageLevel dataOld = repository.findById(data.getId()).get();
            dataOld.setColor(data.getColor());
            dataOld.setName(data.getName());
            repository.save(dataOld);
            return dataOld;
        } else
            throw new NoSuchElementException("El Nivel no existe");
    }
}
