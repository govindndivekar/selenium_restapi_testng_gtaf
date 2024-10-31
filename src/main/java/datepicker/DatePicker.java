package datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DatePicker {

    @Test
    public void test(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //Using cssSelector class name for
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
    }
}
