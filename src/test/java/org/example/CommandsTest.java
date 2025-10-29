package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandsTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testDynamicControlsAndDragAndDrop() {

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableButton = driver.findElement(By.xpath("//*[@id='input-example']/button"));
        enableButton.click();
        System.out.println("Clicked the Enable button!");

        WebElement inputField = driver.findElement(By.xpath("//*[@id='input-example']/input"));
        wait.until(ExpectedConditions.elementToBeClickable(inputField));

        WebElement message = driver.findElement(By.id("message"));
        wait.until(ExpectedConditions.textToBePresentInElement(message, "It's enabled!"));

        if (inputField.isEnabled() && message.getText().equals("It's enabled!")) {
            System.out.println("Input field enabled and text visible");
        }

        wait.until(ExpectedConditions.textToBePresentInElement(enableButton, "Disable"));
        if (enableButton.getText().equals("Disable")) {
            System.out.println("Button text changed successfully");
        }

        inputField.sendKeys("Bootcamp");
        inputField.clear();
        System.out.println("Typed 'Bootcamp' and cleared the input field");

        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        int yA = columnA.getLocation().getY();
        int yB = columnB.getLocation().getY();

        if (yA == yB) {
            System.out.println("Columns A and B aligned successfully");
        } else {
            System.out.println("Columns A and B NOT aligned!");
        }
    }
}
