package webdriverscope;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ScopeTest {

    static WebDriver driver;
    @BeforeClass
    public void setUp(){

        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    //1. get me all the links on the page
    @Test
    public void test(){



        System.out.println(driver.findElements(By.tagName("a")).size());

        driver.quit();
    }

    //Links count in footer
    @Test
    public void testFooterLinks(){

       WebElement footer = driver.findElement(By.id("gf-BIG"));

       System.out.println(footer.findElements(By.tagName("a")).size());

    }

    //Links count in first column in footer
    @Test
    public void testFooterLinksFirstColumn(){

        WebElement footer = driver.findElement(By.id("gf-BIG"));

        WebElement columnDriver = footer.findElement(By.xpath("//table/tbody/tr/td[1]"));

        System.out.println(columnDriver.findElements(By.tagName("a")).size());

    }

    //Click Links in first column in footer and check if they are working
    @Test
    public void testFooterLinksWorking(){

        WebElement footer = driver.findElement(By.id("gf-BIG"));

        WebElement columnDriver = footer.findElement(By.xpath("//table/tbody/tr/td[1]"));

        List<WebElement> footerLinks = columnDriver.findElements(By.tagName("a"));

        for(WebElement link:footerLinks){

            String controlLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);

            link.sendKeys(controlLinkTab);
        }

    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
