package com.unillanos.workart.hub.controllers;

import com.unillanos.workart.hub.entities.DamageCategory;
import com.unillanos.workart.hub.repositories.DamageCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebRestorationCostController {

    @Autowired
    private final DamageCategoryRepository repository;

    public WebRestorationCostController(DamageCategoryRepository repository) {
        this.repository = repository;
    }


    @RequestMapping("/webrestoration")
    public String viewRegister(Model model) {
        String name = "Juan David";
        model.addAttribute("nombre", name);

        List<DamageCategory> lista = repository.findAll();
        model.addAttribute("categorias", lista);

        return "viewRegister";
    }
}
