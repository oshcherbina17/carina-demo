package com.qaprosoft.carina.demo.web.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.ProductListPageBase;

public enum FurnitureSubcategory {

    PC_TABLES("Столи з регулюванням по висоті", ProductListPageBase.class);

    private String namePage;
    private Class<? extends AbstractPage> pageClass;

    FurnitureSubcategory(String namePage, Class<? extends AbstractPage> pageClass) {
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
