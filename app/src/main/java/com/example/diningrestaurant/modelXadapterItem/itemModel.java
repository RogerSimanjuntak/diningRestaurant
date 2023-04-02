package com.example.diningrestaurant.modelXadapterItem;

public class itemModel {
    String name, deskripsi,price;
    int poster;

    public itemModel(String name, String deskripsi, String price, int poster) {
        this.name = name;
        this.deskripsi = deskripsi;
        this.price = price;
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getPrice() {
        return price;
    }

    public int getPoster() {
        return poster;
    }
}
