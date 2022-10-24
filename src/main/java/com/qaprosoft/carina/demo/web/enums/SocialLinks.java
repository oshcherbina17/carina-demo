package com.qaprosoft.carina.demo.web.enums;

public enum SocialLinks {
    FACEBOOK("Facebook"),
    TWITTER("Twitter"),
    YOUTUBE("YouTube"),
    INSTAGRAM("Instagram"),
    VIBER("Viber"),
    GOOGLE("Google"),
    TELEGRAM("Telegram");

    private String icon;

    SocialLinks(String icon) {
        this.icon = icon;

    }

    public String getIcon() {
        return icon;
    }
}
