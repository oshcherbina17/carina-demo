package com.qaprosoft.carina.demo.web.enums;

public enum FilterType {
    FILTER_COFFEE_MACHINE("Кавоварки"),
    FILTER_HEADPHONES("Навушники"),
    ELECTRIC_TYPE("Електричний"),
    COLOR("Білий"),
    RAM("8 ГБ"),
    RAM_16("16 ГБ"),
    COFFEE_MACHINE("Кавомашина"),
    BRAND_APPLE("Apple"),
    BRAND_LENOVO("Lenovo"),
    BRAND_SIGMA("Sigma"),
    BRAND_DELONGHI("Delonghi"),
    BOOKS("Книги"),

    SEARCH_BRIT("brit");

    private String type;


    FilterType(String type) {
        this.type = type;

    }

    public String getType() {
        return type;
    }
}
