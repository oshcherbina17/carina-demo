package com.qaprosoft.carina.demo.web.enums;

public enum Devices {
    TABLETS("Планшети"),
    TABLET("ProductDetailsPageBase.Devices.TABLET"),
    PHONES("Мобільні телефони");

    private String namePage;

    Devices(String namePage) {
        this.namePage = namePage;
    }

    public String getNamePage() {
        return namePage;
    }
}
