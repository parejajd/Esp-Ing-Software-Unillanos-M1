package com.unillanos.workart.hub.repositories;

import com.unillanos.workart.hub.entities.DamageLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageLevelRepository  extends JpaRepository<DamageLevel,Integer> {
}
