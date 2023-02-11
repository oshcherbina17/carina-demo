package com.qaprosoft.carina.demo.web.enums;

public enum ProductStatus {
    AVAILABLE("Є в наявності"),
    OVER("Закінчується"),
    FINISHED("Закінчився"),
    NOT_AVAILABLE("Немає в наявності"),
    EXPECTED("Очікується");

    private String statusType;


    ProductStatus(String statusType) {
        this.statusType = statusType;

    }

    public String getStatusType() {
        return statusType;
    }
}
