package com.ApplianceShop.ApplianceShop.controller;

import com.ApplianceShop.ApplianceShop.model.Appliance;
import com.ApplianceShop.ApplianceShop.model.ShoppingCart;
import com.ApplianceShop.ApplianceShop.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("shopping-cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @PutMapping("add/{applianceId}/{shoppingCartId}")
    public void addAppliance(@PathVariable Integer applianceId, @PathVariable Integer shoppingCartId){
        shoppingCartService.addAppliance(applianceId,shoppingCartId);
    }
    @DeleteMapping("remove/{applianceId}/{shoppingCartId}")
    public void removeAppliance(@PathVariable Integer applianceId, @PathVariable Integer shoppingCartId){
        shoppingCartService.removeAppliance(applianceId,shoppingCartId);
    }
    @GetMapping("total-price/{shoppingCartId}")
    public Integer totalPrice(@PathVariable Integer shoppingCartId){
        return shoppingCartService.totalPrice(shoppingCartId);
    }
    @PostMapping("create")
    public ShoppingCart createCart(){
        return shoppingCartService.createShoppingCart();
    }

}
