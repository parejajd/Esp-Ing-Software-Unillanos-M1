package com.unillanos.workart.hub.controllers;

import com.unillanos.workart.hub.entities.DamageLevel;
import com.unillanos.workart.hub.entities.PaintType;
import com.unillanos.workart.hub.repositories.DamageLevelRepository;
import com.unillanos.workart.hub.repositories.PaintTypeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PaintTypeController {

    private final PaintTypeRepository repository;

    public PaintTypeController(PaintTypeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/paint-type")
    public List<PaintType> get() {
        return repository.findAll();
    }

    @PatchMapping("/paint-type")
    public PaintType update(@RequestBody PaintType data) {
        if (repository.findById(data.getId()).isPresent()) {
            PaintType dataOld = repository.findById(data.getId()).get();
            dataOld.setName(data.getName());
            repository.save(dataOld);
            return dataOld;
        } else
            throw new NoSuchElementException("El Tipo de Pintura no existe");
    }
}
