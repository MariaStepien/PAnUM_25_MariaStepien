package com.example.cafeapp;

public class Location {
    private final String name;
    private final String address;
    private final String openingHours;
    private final int imageResourceId;

    public static final Location[] locations = {
            new Location("Coffee Shop, City 1","Street 1 City 1 42-000", "pon: zamknięte\nwt: 10-17\nśr: 10-17\nczw: 10-17\npt: 10-17\nsb: 10-14\nndz: 10-14\n", R.drawable.map1),
            new Location("Coffee Shop2, City 2","Street 2 City 2 42-000", "pon: zamknięte\nwt: 10-17\nśr: 10-17\nczw: 10-17\npt: 10-17\nsb: 10-14\nndz: 10-14\n", R.drawable.map2),
            new Location("Coffee Shop3, City 3","Street 3 City 3 42-000", "pon: zamknięte\nwt: 10-17\nśr: 10-17\nczw: 10-17\npt: 10-17\nsb: 10-14\nndz: 10-14\n", R.drawable.map3),
    };

    private Location(String name, String description, String openingHours, int imageResourceId) {
        this.name = name;
        this.address = description;
        this.openingHours = openingHours;
        this.imageResourceId = imageResourceId;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getOpeningHours() {
        return openingHours;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}
