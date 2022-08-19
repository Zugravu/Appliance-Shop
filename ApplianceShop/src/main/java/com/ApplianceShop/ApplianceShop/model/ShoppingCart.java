package com.ApplianceShop.ApplianceShop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
    ArrayList<Appliance> appliancesList = new ArrayList<>();

    public Integer totalPrice(){
        Integer sum = 0;
        for (Appliance appliance : appliancesList) sum += appliance.getPrice();
        return sum;
    }

    public void addAppliance(Appliance appliance){
        appliancesList.add(appliance);
    }

    public void removeAppliance(Appliance appliance){
        appliancesList.remove(appliance);
    }
}
