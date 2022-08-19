package com.ApplianceShop.ApplianceShop.service;

import com.ApplianceShop.ApplianceShop.model.Appliance;
import com.ApplianceShop.ApplianceShop.model.ShoppingCart;
import com.ApplianceShop.ApplianceShop.repository.ApplianceRepository;
import com.ApplianceShop.ApplianceShop.repository.ShoppingCartRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;

import static com.ApplianceShop.ApplianceShop.model.ApplianceType.ELB;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(ShoppingCartServiceTest.class)
public class ShoppingCartServiceTest {
    @MockBean// MockBean wont work
    ShoppingCartRepository shoppingCartRepository;

    @MockBean
    ShoppingCartService shoppingCartService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void appliance_exists_in_cart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Appliance appliance = new Appliance(null, "Frigider", 56466, 5, ELB, false, 200);
        shoppingCartService.addAppliance(appliance.getId(),shoppingCart.getId());

        when(shoppingCartRepository.totalPrice(shoppingCart.getId())).thenReturn(appliance.getPrice());
        assertThat(shoppingCartRepository.totalPrice(shoppingCart.getId())).isGreaterThan(0);

    }
}
