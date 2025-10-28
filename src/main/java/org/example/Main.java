package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    static void main() {
        WebDriver driver = new ChromeDriver();


        driver.get(" https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.id("login-button")).click();

        driver.close();
    }
}
