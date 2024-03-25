package com.springdatajpa.springboot.order.entity;

public enum OrderStatus {
    OPEN(1000),
    READY_TO_SHIP(3000),
    PARTIAL_SHIPPED(3500),
    SHIPPED(4000),
    FULFILLED(7000),
    DELIVERED(7500),
    PENDING_RETURN(8000),
    RETURNED(8500),
    PARTIAL_RETURNED(8700),
    CANCELED(9000),
    COMPLETED(10000);

    private final Integer value;

    OrderStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static OrderStatus getEnumFromValue(int value) {
        for (OrderStatus orderStatus : values()) {
            if (orderStatus.value == value) {
                return orderStatus;
            }
        }
        return null;
    }
}
