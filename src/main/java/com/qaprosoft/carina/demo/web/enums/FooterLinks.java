package com.qaprosoft.carina.demo.web.enums;

public enum FooterLinks {
    ABOUT_US("Про нас"),
    TERMS_OF_USE("Умови використання сайту"),
    CONTACTS("Контакти"),
    DELIVERY_AND_PAYMENT("Доставка та оплата"),
    GUARANTY("Гарантія"),
    CREDIT("Кредит");

    private String link;

    FooterLinks(String link) {
        this.link = link;

    }

    public String getLink() {
        return link;
    }
}
