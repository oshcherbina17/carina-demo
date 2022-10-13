package com.qaprosoft.carina.demo.web.utils.enums;

public enum SortDropdownEnum {
    LOW_TO_HIGH("Від дешевих до дорогих"),
    HIGH_TO_LOW("Від дорогих до дешевих"),
    NEW("Новинки"),
    BY_RATING("За рейтингом");

    private String sortType;


    SortDropdownEnum(String sortType) {
        this.sortType = sortType;

    }

    public String getSortType() {
        return sortType;
    }
}
