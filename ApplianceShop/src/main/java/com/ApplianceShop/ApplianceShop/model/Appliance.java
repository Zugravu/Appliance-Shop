package com.ApplianceShop.ApplianceShop.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Data
public class Appliance {
    @Id
    @GeneratedValue
    Integer id;
    @NotNull
    String name;
    @NotNull
    AtomicInteger stock;
    @NotNull
    ApplianceType applianceType;
    Boolean deleted=false;

}
