package com.qaprosoft.carina.demo.web.utils.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.TabletsPageBase;

public enum DevicesEnum {
    TABLETS("Планшети",TabletsPageBase.class);

    private String namePage;
    private Class<? extends AbstractPage> pageClass;

    DevicesEnum(String namePage, Class<? extends AbstractPage> pageClass) {
        this.namePage = namePage;
        this.pageClass = pageClass;
    }

    public String getNamePage() {
        return namePage;
    }

    public Class<? extends AbstractPage> getPageClass() {
        return this.pageClass;
    }
}
