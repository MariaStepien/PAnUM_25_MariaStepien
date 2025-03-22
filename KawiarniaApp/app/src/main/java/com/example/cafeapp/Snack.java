package com.example.cafeapp;

public class Snack {
    private final String name;
    private final String description;
    private final int imageResourceId;
    private final String price;

    public final static Snack[] snacks = {
            new Snack("Ciasto truskawkowe","Jasny biszkopt z bitą śmietaną, kawałkami truskawek i galaretką truskawkową.", R.drawable.ciasto_z_galaretka, "14.90"),
            new Snack("Sernik","Sernik na zimno rosa z dodatkiem migdałów.", R.drawable.sernik_z_rosa_01_0, "13.50"),
            new Snack("Kanapka","Kanapka z chleba żytniego, wędliny, ogórka i pomidora.", R.drawable.kanapki_z_szynka_i_majonezem_zrob_najlepsze_na_swiecie_2439550, "7.80")
    };

    private Snack(String name, String description, int imageResourceId, String price) {
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
