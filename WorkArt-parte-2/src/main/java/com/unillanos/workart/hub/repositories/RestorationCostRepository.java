package com.unillanos.workart.hub.repositories;

import com.unillanos.workart.hub.entities.*;
import com.unillanos.workart.hub.entities.PaintType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestorationCostRepository extends JpaRepository<RestorationCost,Integer> {
}
