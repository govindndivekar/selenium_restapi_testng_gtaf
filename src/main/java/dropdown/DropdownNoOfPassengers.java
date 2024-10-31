package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropdownNoOfPassengers {

    @Test
    public void test(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("divpaxinfo")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Add 5 adults
        while(!driver.findElement(By.id("spanAudlt")).getText().equalsIgnoreCase("5")){

            driver.findElement(By.id("hrefIncAdt")).click();
        }
        Assert.assertTrue(driver.findElement(By.id("spanAudlt")).getText().equalsIgnoreCase("5"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //click done button
        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");

        driver.quit();

    }
}
