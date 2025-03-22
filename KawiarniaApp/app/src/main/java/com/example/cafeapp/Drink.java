package com.example.cafeapp;

public class Drink {
    private final String name;
    private final String description;
    private final int imageResourceId;

    private final String price;

    public static final Drink[] drinks = {
            new Drink("Cappuccino", "Włoski napój kawowy z dodatkiem spienionego mleka i szczyptą sypkiej czekolady lub kakao dla ozdoby. ", R.drawable.filizanka_cappuccino, "8"),
            new Drink("Latte", " Włoski napój kawowy powstający w wyniku wlania spienionego ciepłego mleka do kawy espresso.", R.drawable.latte, "5.80"),
            new Drink("Herbata malinowa", "Herbata malinowa z dodatkiem miodu.", R.drawable.herbmalinowa, "8.50")
    };

    private Drink(String name, String description, int imageResourceId, String price) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getPrice() {
        return price;
    }

    public String toString() {
        return this.name;
    }
}