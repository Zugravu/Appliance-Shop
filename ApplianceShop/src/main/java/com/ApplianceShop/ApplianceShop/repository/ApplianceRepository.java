package com.ApplianceShop.ApplianceShop.repository;

import com.ApplianceShop.ApplianceShop.model.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ApplianceRepository extends JpaRepository<Appliance, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Appliance SET deleted = true WHERE id = :id")
    void softDelete(Integer id);
    @Modifying
    @Transactional
    @Query("UPDATE Appliance SET stock = stock + 1 WHERE id = :id")
    void incrementStock(Integer id);
    @Modifying
    @Transactional
    @Query("UPDATE Appliance SET stock = stock - 1 WHERE id = :id")
    void decrementStock(Integer id);
    @Modifying
    @Transactional
    @Query("UPDATE Appliance SET stock = :newStock  WHERE id = :id")
    void updateStock(Integer id, Integer newStock);

}
