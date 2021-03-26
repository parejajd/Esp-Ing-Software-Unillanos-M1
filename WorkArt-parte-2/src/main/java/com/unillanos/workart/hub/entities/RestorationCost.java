package com.unillanos.workart.hub.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RestorationCost")
public class RestorationCost {
    @Id
    private int id;
    private int damageCategoryId;
    private int damageLevelId;
    private int paintTypeId;
    private double cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamageCategoryId() {
        return damageCategoryId;
    }

    public void setDamageCategoryId(int damageCategoryId) {
        this.damageCategoryId = damageCategoryId;
    }

    public int getDamageLevelId() {
        return damageLevelId;
    }

    public void setDamageLevelId(int damageLevelId) {
        this.damageLevelId = damageLevelId;
    }

    public int getPaintTypeId() {
        return paintTypeId;
    }

    public void setPaintTypeId(int paintTypeId) {
        this.paintTypeId = paintTypeId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

