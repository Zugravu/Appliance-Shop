package com.ApplianceShop.ApplianceShop.service;

import com.ApplianceShop.ApplianceShop.model.Appliance;
import com.ApplianceShop.ApplianceShop.model.ShoppingCart;
import com.ApplianceShop.ApplianceShop.repository.ApplianceRepository;
import com.ApplianceShop.ApplianceShop.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ApplianceRepository applianceRepository;

    public void addAppliance(Integer applianceId, Integer shoppingCartId){
        Appliance appliance = applianceRepository.findById(applianceId).get();
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).get();
        shoppingCart.addAppliance(appliance);
    }

    public void removeAppliance(Integer applianceId, Integer shoppingCartId){
        Appliance appliance = applianceRepository.findById(applianceId).get();
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).get();
        shoppingCart.removeAppliance(appliance);
    }

    public Integer totalPrice(Integer shoppingCartId){
        return shoppingCartRepository.findById(shoppingCartId).get().totalPrice();
    }

    public ShoppingCart createShoppingCart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }
}
