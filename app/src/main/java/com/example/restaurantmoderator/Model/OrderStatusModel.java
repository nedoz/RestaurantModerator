package com.example.restaurantmoderator.Model;

public class OrderStatusModel {

    String orderStatus;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderStatusModel(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}