package com.ApplianceShop.ApplianceShop.service;

import com.ApplianceShop.ApplianceShop.model.Appliance;
import com.ApplianceShop.ApplianceShop.repository.ApplianceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplianceService {
    private final ApplianceRepository applianceRepository;

    public Appliance addAppliance(Appliance appliance){
        return applianceRepository.save(appliance);
    }

    public List<Appliance> getAbsoluteAllAppliance(){
        return applianceRepository.findAll();
    }

    public List<Appliance> getAllAppliance(){
        return applianceRepository.findAll().stream().filter(x->!x.getDeleted()).collect(Collectors.toList());
    }

    public void softDelete(Integer id){
        applianceRepository.deleteById(id);
    }

    public void incrementStock(Integer id){
        applianceRepository.incrementStock(id);
    }
}