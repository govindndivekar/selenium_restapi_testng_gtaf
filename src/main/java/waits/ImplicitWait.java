package waits;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ImplicitWait {

    @Test
    public void test(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
