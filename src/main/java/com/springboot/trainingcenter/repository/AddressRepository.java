package com.springboot.trainingcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.trainingcenter.entity.Address;

/**
 * Repository interface for managing Address entities.
 * Extends JpaRepository to inherit basic CRUD operations.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
