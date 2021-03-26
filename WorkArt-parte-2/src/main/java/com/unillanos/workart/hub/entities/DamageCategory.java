package com.unillanos.workart.hub.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DamageCategory")
public class DamageCategory {
    @Id
    private int id;
    private String type;
    private String figure;
    private String typeOfDamage;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public String getTypeOfDamage() {
        return typeOfDamage;
    }

    public void setTypeOfDamage(String typeOfDamage) {
        this.typeOfDamage = typeOfDamage;
    }
}
