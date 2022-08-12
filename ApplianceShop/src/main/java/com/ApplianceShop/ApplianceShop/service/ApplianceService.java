package com.ApplianceShop.ApplianceShop.service;

import com.ApplianceShop.ApplianceShop.model.Appliance;
import com.ApplianceShop.ApplianceShop.repository.ApplianceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplianceService {
    private final ApplianceRepository applianceRepository;

    public Appliance addAppliance(Appliance appliance) {
        return applianceRepository.save(appliance);
    }

    public List<Appliance> getAbsoluteAllAppliance() {
        return applianceRepository.findAll();
    }

    public List<Appliance> getAllAppliance() {
        return applianceRepository.findAll().stream().filter(x -> !x.getDeleted()).collect(Collectors.toList());
    }

    public void softDelete(Integer id){
        applianceRepository.softDelete(id);
    }

    public void incrementStock(Integer id) {
        applianceRepository.incrementStock(id);
    }

    public void decrementStock(Integer id) {
        if (!applianceRepository.findById(id).get().getStock().equals(0)) { // verify if the stock is 0
            applianceRepository.decrementStock(id);
        }
        else{
            throw new RuntimeException("The stock is already 0"); // I couldn't just show the appliance because I had to put void at this method.
                                                                 // So I decided to throw an error whenever the stock is 0 and the user wants to decrement it.
                                                                // It might not be the best option to use, but I can't think of any other solution
        }
    }

    public void updateStock(Integer id, Integer newStock){
        if(newStock>=0){
            applianceRepository.updateStock(id,newStock);
        }
        else{
            throw new RuntimeException("Can't set a negative stock");
        }
    }


}