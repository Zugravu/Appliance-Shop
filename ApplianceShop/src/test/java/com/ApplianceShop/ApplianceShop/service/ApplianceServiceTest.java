package com.ApplianceShop.ApplianceShop.service;

import com.ApplianceShop.ApplianceShop.model.Appliance;
import com.ApplianceShop.ApplianceShop.repository.ApplianceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.ApplianceShop.ApplianceShop.model.ApplianceType.ELB;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplianceServiceTest.class)
public class ApplianceServiceTest {
    @MockBean
    ApplianceRepository applianceRepository;

    @MockBean
    ApplianceService applianceService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_add_appliance() throws Exception{
        Appliance appliance = new Appliance(null, "Frigider", 56466, 5, ELB, false, 200);

        when(applianceRepository.save(any(Appliance.class))).thenReturn(new Appliance());

        Appliance getAppliance = applianceService.addAppliance(appliance);
        assertThat(getAppliance.getName()).isNotNull();
    }
}
