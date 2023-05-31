package com.qaprosoft.carina.demo.web.enums;

public enum AppleDevices {
    STYLUS("Стилуси");
    private String device;


    AppleDevices(String device) {
        this.device = device;

    }

    public String getDevice() {
        return device;
    }
}
