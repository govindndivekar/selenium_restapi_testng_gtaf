package alerthandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertHandling {

    private String name = "Govind";

    @Test
    public void test(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Enter name in the input box
        driver.findElement(By.id("name")).sendKeys(this.name);

        //Click on alert button
        driver.findElement(By.cssSelector("input[id='alertbtn']")).click();

        //Alert Handling
        Alert alter = driver.switchTo().alert();

        //get Alert text
        String textInAlert = alter.getText();

        //verify Alert text
        Assert.assertEquals(textInAlert,"Hello " + this.name + ", share this practice page and share your knowledge");

        //click ok
        alter.accept();

        //click on confirm button
        driver.findElement(By.id("confirmbtn")).click();

        //switch to alert
        Alert alert = driver.switchTo().alert();

        //get alert text
        textInAlert = alert.getText();

        Assert.assertEquals(textInAlert,"Hello , Are you sure you want to confirm?");

        //click cancel
        alert.dismiss();

        driver.quit();

    }
}
