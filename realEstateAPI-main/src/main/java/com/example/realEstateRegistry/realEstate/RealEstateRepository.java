package com.example.realEstateRegistry.realEstate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, Long> {

    @Query("SELECT r FROM RealEstate r Where r.city = ?1")
    Optional<RealEstate> findRealEstateByCity(String city);

    @Query("SELECT a FROM RealEstate a Where a.street = ?1")
    Optional<RealEstate> findRealEstateByStreet(String street);

    @Query("SELECT s FROM RealEstate s Where s.number = ?1")
    Optional<RealEstate> findRealEstateByNumber(Integer number);
}
