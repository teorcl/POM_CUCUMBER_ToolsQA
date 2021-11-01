package co.com.sofka.page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonActionsOnPages {

    private final WebDriver driver;

    //===CONSTRUCTOR===
    public CommonActionsOnPages(WebDriver driver) {
        this.driver = driver;
    }

    protected void clear(By selector){
        driver.findElement(selector).clear();
    }

    protected void clickOn(By selector){
        driver.findElement(selector).click();
    }

    protected void type(By selector, String value){
        driver.findElement(selector).sendKeys(value);
    }

    protected void doSubmit(By selector){
        driver.findElement(selector).submit();
    }

    protected String getText(By selector){
        return driver.findElement(selector).getText();
    }
}
