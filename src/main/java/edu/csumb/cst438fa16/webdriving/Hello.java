package edu.csumb.cst438fa16.webdriving;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hello {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://cst438hello-env.us-west-2.elasticbeanstalk.com/"
                   + "hello.html");

        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
    }
}
