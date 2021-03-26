package com.unillanos.workart.hub.controllers;

import com.unillanos.workart.hub.entities.DamageCategory;
import com.unillanos.workart.hub.entities.RestorationCost;
import com.unillanos.workart.hub.repositories.DamageCategoryRepository;
import com.unillanos.workart.hub.repositories.RestorationCostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class RestorationCostController {
    private final RestorationCostRepository repository;

    public RestorationCostController(RestorationCostRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/restoration-cost")
    public List<RestorationCost> get() {
        return repository.findAll();
    }

    @PostMapping("/restoration-cost")
    public RestorationCost add(@RequestBody RestorationCost data) {
        this.repository.save(data);
        return data;
    }

    @DeleteMapping("/restoration-cost/{id}")
    public boolean delete(@PathVariable int id) {
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    @PatchMapping("/restoration-cost")
    public RestorationCost update(@RequestBody RestorationCost data) {
        if (repository.findById(data.getId()).isPresent()) {
            RestorationCost dataOld = repository.findById(data.getId()).get();
            dataOld.setCost(data.getCost());
            dataOld.setDamageCategoryId(data.getDamageCategoryId());
            dataOld.setDamageLevelId(data.getDamageLevelId());
            dataOld.setPaintTypeId(data.getPaintTypeId());
            repository.save(dataOld);
            return dataOld;
        } else
            throw new NoSuchElementException("La Restauración no existe");
    }
}
