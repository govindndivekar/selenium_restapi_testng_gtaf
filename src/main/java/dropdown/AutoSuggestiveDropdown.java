package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AutoSuggestiveDropdown {

    @Test
    public void test() throws InterruptedException{

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("autosuggest")).sendKeys("Ind");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        List<WebElement> autoSuggestOptions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for(WebElement element : autoSuggestOptions){

            if(element.getText().equalsIgnoreCase("india")){

                element.click();
                break;
            }
        }

        driver.quit();
    }
}
