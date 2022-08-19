package com.ApplianceShop.ApplianceShop.controller;

import com.ApplianceShop.ApplianceShop.model.Appliance;
import com.ApplianceShop.ApplianceShop.service.ApplianceServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static com.ApplianceShop.ApplianceShop.model.ApplianceType.ELB;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplianceControllerTest.class)
public class ApplianceControllerTest {
    @MockBean
    ApplianceServiceTest applianceService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_display_all_appliances() throws Exception{ // a test to verify if all the appliances are displayed
        Appliance testAppliance = new Appliance(null, "Frigider", 56466, 5, ELB, false, 200);
        mockMvc.perform(get("/appliance/absolute-all"))
                .andExpect(status().isOk());
    }
}
