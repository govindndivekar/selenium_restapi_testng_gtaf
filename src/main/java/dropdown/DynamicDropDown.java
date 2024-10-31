package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicDropDown {

    @Test

    public void test() throws InterruptedException{

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //select input drop down
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        //selecting from City option
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//child::a[@value='MAA']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //selecting To City option
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//child::a[@value='BLR']")).click();

        Thread.sleep(3000);

        driver.quit();
    }
}
