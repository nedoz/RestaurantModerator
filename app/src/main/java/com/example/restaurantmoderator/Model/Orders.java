package com.example.restaurantmoderator.Model;

public class Orders {

    private String order_date;
    private int order_num;
    private String order_price;
    private String order_quantity;

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public String getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(String order_quantity) {
        this.order_quantity = order_quantity;
    }

    public Orders(String order_date, int order_num, String order_price, String order_quantity) {
        this.order_date = order_date;
        this.order_num = order_num;
        this.order_price = order_price;
        this.order_quantity = order_quantity;
    }
}
