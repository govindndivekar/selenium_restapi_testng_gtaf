package checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CheckBox {

    @Test
    public void test(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        if(!driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()){

            driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        }

        //here we are selecting the checkbox with CssSelector with Regular expression
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        //count the number of checkboxes
        List<WebElement> chekcBoxList = driver.findElements(By.xpath("//input[@type='checkbox']"));

        System.out.println("Number of checkboxes "+chekcBoxList.size());

        driver.quit();
    }
}
