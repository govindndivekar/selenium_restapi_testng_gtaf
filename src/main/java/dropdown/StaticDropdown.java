package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class StaticDropdown {

    static WebDriver driver;

    @BeforeClass
    public void setUp(){

        driver = new ChromeDriver();
    }

    @Test
    public void test(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Select select = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));

        List<WebElement> dropDownList = select.getOptions();
        
        select.selectByIndex(dropDownList.size()-1);

        Assert.assertEquals(select.getFirstSelectedOption().getText(),"USD");

        select.selectByVisibleText("INR");

        Assert.assertEquals(select.getFirstSelectedOption().getText(),"INR");

        select.selectByValue("AED");

        Assert.assertEquals(select.getFirstSelectedOption().getText(),"AED");
    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
