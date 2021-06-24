package switchtwentytwenty.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UITests {
    WebDriver driver;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    }

    @AfterEach
    void closeDriver() {
        driver.close();
    }


    @Test
    void UILoginSuccessSystemManager() {
        driver = new ChromeDriver();

        driver.get("http://vs408.dei.isep.ipp.pt:3000/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        driver.findElement(By.id("login-email")).sendKeys("sm");
        driver.findElement(By.id("password")).sendKeys("sm");
        driver.findElement(By.id("login-button")).click();

        String expected = "CREATE A FAMILY";
        String result = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div")).getText();

        assertEquals(expected, result);


    }

    @Test
    void UILoginSuccessFamilyAdmin() {
        driver = new ChromeDriver();

        driver.get("http://vs408.dei.isep.ipp.pt:3000/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        driver.findElement(By.id("login-email")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.id("login-button")).click();

        String expected = "FAMILY";
        String result = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[1]")).getText();

        assertEquals(expected, result);


    }

    @Test
    void UILoginSuccessFamilyMember() {

        driver = new ChromeDriver();

        driver.get("http://vs408.dei.isep.ipp.pt:3000/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        driver.findElement(By.id("login-email")).sendKeys("member");
        driver.findElement(By.id("password")).sendKeys("member");
        driver.findElement(By.id("login-button")).click();

        String expected = "PROFILE";
        String result = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div")).getText();

        assertEquals(expected, result);


    }

    @Test
    void UILoginFailure() {

        driver = new ChromeDriver();

        driver.get("http://vs408.dei.isep.ipp.pt:3000/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        driver.findElement(By.id("login-email")).sendKeys("notauser");
        driver.findElement(By.id("password")).sendKeys("notapassword");
        driver.findElement(By.id("login-button")).click();

        String expected = "LOGOUT";
        try {
            driver.findElement(By.xpath("/html/body/div/div/div[1]/div[3]/button[3]"));
            fail("Link with text <" + expected + "> is present");
        } catch (NoSuchElementException ex) {

        }

    }

    @Test
    void createFamilyAndAdmin() throws AWTException, InterruptedException {
        driver = new ChromeDriver();

        driver.get("http://vs408.dei.isep.ipp.pt:3000/login");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.id("login-email")).sendKeys("sm");
        driver.findElement(By.id("password")).sendKeys("sm");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div")).click();

        Robot robot = new Robot();
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        String secondBasedEmail = System.currentTimeMillis() + "@email.com";

        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/div[1]/input")).sendKeys(secondBasedEmail);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/div[2]/input")).sendKeys("password");
        driver.findElement(By.id("adminName")).sendKeys("TonyZe");
        driver.findElement(By.id("birthdate")).sendKeys("12/12/1990");
        driver.findElement(By.id("vatnumber")).sendKeys("123456789");
        driver.findElement(By.id("phone")).sendKeys("919999999");
        driver.findElement(By.id("street")).sendKeys("Rua");
        driver.findElement(By.id("city")).sendKeys("Cidade");
        driver.findElement(By.id("houseNumber")).sendKeys("12A");
        driver.findElement(By.id("zipCode")).sendKeys("1234-123");
        driver.findElement(By.id("familyName")).sendKeys("Costa");
        driver.findElement(By.id("registrationDate")).sendKeys("12/12/1990");

        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/button")).click();

        String expected = "REGISTER FAMILY";
        String result = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/button")).getText();

        assertEquals(expected, result);


    }


}
