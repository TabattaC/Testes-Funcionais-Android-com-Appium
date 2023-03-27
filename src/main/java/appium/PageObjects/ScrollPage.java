package appium.PageObjects;

import org.openqa.selenium.By;

public class ScrollPage {
    private Basepage basepage = new Basepage();

    public String obterMessageAlert() {
        return basepage.getText(By.id("android:id/message"));
    }
}
