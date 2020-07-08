package com.hktv.warehouse.entity;

import lombok.Getter;

public class TransferRequest {

    @Getter
    private String from;

    @Getter
    private String to;

    @Getter
    private Integer qty;
}
