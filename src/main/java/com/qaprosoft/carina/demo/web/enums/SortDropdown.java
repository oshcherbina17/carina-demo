package com.qaprosoft.carina.demo.web.enums;

public enum SortDropdown {
    LOW_TO_HIGH("Від дешевих до дорогих"),
    HIGH_TO_LOW("Від дорогих до дешевих"),
    NEW("Новинки"),
    DATE("За датою"),
    BY_RATING("За рейтингом"),
    ASCENDING("ProductFilter.SortDropdown.Ascending"),
    DESCENDING("ProductFilter.SortDropdown.Descending");


    private String sortType;


    SortDropdown(String sortType) {
        this.sortType = sortType;

    }

    public String getSortType() {
        return sortType;
    }
}
