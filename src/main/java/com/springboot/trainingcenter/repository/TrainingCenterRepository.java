package com.springboot.trainingcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.trainingcenter.entity.TrainingCenter;

/**
 * Repository interface for managing TrainingCenter entities.
 * Extends JpaRepository to inherit basic CRUD operations.
 */
@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Integer>{

}
