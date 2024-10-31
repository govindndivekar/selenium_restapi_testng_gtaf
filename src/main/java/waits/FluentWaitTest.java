package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class FluentWaitTest {

    @Test
    public void test(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String[] userOrderArray = {"Cucumber","Brocolli","Beetroot","Beans"};

        //getting list of products
        List<WebElement> orderList = driver.findElements(By.xpath("//h4[@class='product-name']"));

        List<String> userOrderList = Arrays.asList(userOrderArray);

        int counter = 0;

        for(WebElement element: orderList){

            String productName = element.getText();

            if(userOrderList.contains(productName.split("-")[0].trim())){

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(orderList.indexOf(element)).click();
                counter++;
            }
            if(counter == userOrderList.size()){
                break;
            }
        }

        //click add to cart
        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.className("promoBtn")).click();



    }
}
