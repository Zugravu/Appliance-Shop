package com.ApplianceShop.ApplianceShop.repository;

import com.ApplianceShop.ApplianceShop.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    public Integer totalPrice(Integer shoppingCartId);
}
