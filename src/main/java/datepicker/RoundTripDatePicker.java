package datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RoundTripDatePicker {

    @Test
    public void test(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector(".custom_date_pic.required.home-date-pick.valid"));

        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("opacity: 0.5")){

            driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        }else {
            Assert.fail();
        }

    }
}
