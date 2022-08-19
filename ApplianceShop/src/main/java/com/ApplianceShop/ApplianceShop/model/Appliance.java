package com.ApplianceShop.ApplianceShop.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appliance {
    @Id
    @GeneratedValue
    Integer id;
    @NotNull
    String name;
    Integer identificationCode; // this shouldn't be the id?
    @NotNull
    Integer stock;
    @NotNull
    ApplianceType applianceType;
    Boolean deleted=false;
    Integer price;

}
