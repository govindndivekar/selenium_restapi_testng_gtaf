package endtoendtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AirlineBookingQAClick {

    @Test
    public void test() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //select input drop down
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        //selecting from City option
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//child::a[@value='MAA']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //selecting To City option
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//child::a[@value='BLR']")).click();

        //Selecting today Using cssSelector class name
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        //selecting senior citizen checkbox
        if(!driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()){

            driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        }

        //checking if round trip radio button is disabled
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
            Assert.fail("Round trip option is selected");
        }

        driver.findElement(By.id("divpaxinfo")).click();

        //Add 5 adults
        while(!driver.findElement(By.id("spanAudlt")).getText().equalsIgnoreCase("5")){

            driver.findElement(By.id("hrefIncAdt")).click();
        }
        Assert.assertTrue(driver.findElement(By.id("spanAudlt")).getText().equalsIgnoreCase("5"));

        //enter submit button
        //driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights"));
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.quit();
    }
}
