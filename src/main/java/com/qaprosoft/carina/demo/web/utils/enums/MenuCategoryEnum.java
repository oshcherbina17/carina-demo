package com.qaprosoft.carina.demo.web.utils.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.HouseholdGoodsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.LaptopsAndComputersPageBase;
import com.qaprosoft.carina.demo.web.gui.common.SmartphonesTvElectronicsPageBase;

public enum MenuCategoryEnum {
    LAPTOPS_COMPUTERS("Ноутбуки та комп’ютери", LaptopsAndComputersPageBase.class),
    SMARTPHONES_TV_ELECTRONICS("Смартфони, ТВ і електроніка", SmartphonesTvElectronicsPageBase.class),
    HOUSEHOLD_GOODS("Товари для дому", HouseholdGoodsPageBase.class);

    private String namePage;
    private Class<? extends AbstractPage> pageClass;

    MenuCategoryEnum(String namePage, Class<? extends AbstractPage> pageClass) {
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
