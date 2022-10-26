package com.qaprosoft.carina.demo.web.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.HouseholdGoodsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.LaptopsAndPCPageBase;
import com.qaprosoft.carina.demo.web.gui.common.PhonesAndElectronicsPageBase;

public enum MenuCategory {
    LAPTOPS_COMPUTERS("Ноутбуки та комп’ютери", LaptopsAndPCPageBase.class),
    PHONES_TV_ELECTRONICS("Смартфони, ТВ і електроніка", PhonesAndElectronicsPageBase.class),
    HOUSEHOLD_GOODS("Товари для дому", HouseholdGoodsPageBase.class);

    private String namePage;
    private Class<? extends AbstractPage> pageClass;

    MenuCategory(String namePage, Class<? extends AbstractPage> pageClass) {
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
