package com.example.restaurantmoderator.Model;

public class OrderRequest {

    private int productImg;
    private String productName;
    private String description;
    private String quantity;
    private String price;
    private String options;
    private String note;
    private String additions;

    public int getProductImg() {
        return productImg;
    }

    public void setProductImg(int productImg) {
        this.productImg = productImg;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAdditions() {
        return additions;
    }

    public void setAdditions(String additions) {
        this.additions = additions;
    }

    public OrderRequest(int productImg, String productName,
                        String description, String quantity,
                        String price, String options, String note,
                        String additions) {
        this.productImg = productImg;
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.options = options;
        this.note = note;
        this.additions = additions;
    }




}