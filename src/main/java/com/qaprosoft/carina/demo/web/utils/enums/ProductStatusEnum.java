package com.qaprosoft.carina.demo.web.utils.enums;

public enum ProductStatusEnum {
    AVAILABLE("Є в наявності"),
    OVER("Закінчується"),
    FINISHED("Закінчився"),
    NOT_AVAILABLE("Немає в наявності"),
    EXPECTED("Очікується");

    private String sortType;


    ProductStatusEnum(String sortType) {
        this.sortType = sortType;

    }

    public String getSortType() {
        return sortType;
    }
}
