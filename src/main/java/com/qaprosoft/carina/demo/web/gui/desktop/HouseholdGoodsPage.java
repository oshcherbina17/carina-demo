package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.web.gui.common.HouseholdGoodsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HouseholdGoodsPageBase.class)
public class HouseholdGoodsPage extends HouseholdGoodsPageBase {

    public HouseholdGoodsPage(WebDriver driver) {
        super(driver);
        setPageURL("tovary-dlya-doma/c2394287/");
    }
}
