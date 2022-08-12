package com.ApplianceShop.ApplianceShop.controller;

import com.ApplianceShop.ApplianceShop.model.Appliance;
import com.ApplianceShop.ApplianceShop.service.ApplianceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appliance")
@RequiredArgsConstructor
public class ApplianceController {
    private final ApplianceService applianceService;

    @PostMapping("add")
    public Appliance addAppliance(@RequestBody Appliance appliance){
        return applianceService.addAppliance(appliance);
    }

    @DeleteMapping("delete/{id}")
    public void softDelete(@PathVariable Integer id){
        applianceService.softDelete(id);
    }

    @GetMapping("absolute-all")
    public List<Appliance> getAbsoluteAllAppliance(){
        return applianceService.getAbsoluteAllAppliance();
    }

    @GetMapping("all")
    public List<Appliance> gotAllAppliance(){
        return applianceService.getAllAppliance();
    }

    @PostMapping("increment-stock/{id}")
    public void incrementStock(@PathVariable Integer id){
        applianceService.incrementStock(id);
    }

    @PostMapping("decrement-stock/{id}")
    public void decrementStock(@PathVariable Integer id){
        applianceService.decrementStock(id);
    }

    @PostMapping("update-stock/{id}/{newStock}")
    public void updateStock(@PathVariable Integer id, @PathVariable Integer newStock){
        applianceService.updateStock(id,newStock);
    }


}
