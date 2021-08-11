import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class pragmaSeleniumFirstTest {

    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ava\\IdeaProjects\\Domashno_3_MVN\\src\\test\\resources\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void homeworkTest () {
        driver.get("http://shop.pragmatic.bg/admin");
        WebElement username = driver.findElement(By.id("input-username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("parola123!");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        WebElement profile = driver.findElement(By.xpath("//*[@id=\"header\"]/div/ul/li[1]/a/text()"));
        String userName = profile.getText();
        Assert.assertEquals(userName, "Milen Strahinski");
    }

}
