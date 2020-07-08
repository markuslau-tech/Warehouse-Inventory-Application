package com.hktv.warehouse.entity;

import lombok.Getter;

public class InventoryRequest {

    public InventoryRequest(String code, String location, Integer qty){
        this.code = code;
        this.location = location;
        this.qty = qty;
    }

    @Getter
    private String code;

    @Getter
    private String location;

    @Getter
    private Integer qty;

}
