package com.codewithkv.models;

import java.sql.Timestamp;

public class Cart {
    private String id;

    private String productName;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public void setCount(int count) {
    }
    public void getCount(int count) {
    }

}
