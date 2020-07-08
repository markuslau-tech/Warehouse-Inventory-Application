package com.hktv.warehouse.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "inventories")
@Data
public class Inventory {

    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "locationId", referencedColumnName = "id", nullable = false)
    private Location location;

    @Getter
    @Setter
    private Integer qty;

}
