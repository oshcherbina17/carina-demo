package com.qaprosoft.carina.demo.web.utils.enums;

public enum ProductTabs {
    ABOUT_PRODUCT("Усе про товар"),
    CHARACTERISTIC("Характеристики"),
    REVIEWS("Відгуки"),
    QUESTION("Питання"),
    VIDEO("Відео"),
    BUY_WITH("Купують разом"),
    PHOTO("Фото");

    private String type;


    ProductTabs(String type) {
        this.type = type;

    }

    public String getType() {
        return type;
    }
}
