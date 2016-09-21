package edu.csumb.cst438fa16.webdriving;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookLogin {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://test20160831-env.us-west-2.elasticbeanstalk.com/");

        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page URL is: " + driver.getCurrentUrl());

        (new WebDriverWait(driver, 10)).until(
            ExpectedConditions.presenceOfElementLocated(
                By.tagName("fb:login-button")));

        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page URL is: " + driver.getCurrentUrl());

        WebElement fbLoginButton =
            driver.findElement(By.tagName("fb:login-button"));
        fbLoginButton.click();
        try {
            Thread.sleep(4000);
        } catch(InterruptedException exc) {}
        for (String handle : driver.getWindowHandles()) {
            System.out.println("Window handle: " + handle);
        }
        (new WebDriverWait(driver, 10)).until(
            ExpectedConditions.numberOfWindowsToBe(2));
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals("Facebook")) break;
        }
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page URL is: " + driver.getCurrentUrl());

        String email    = System.getProperty("fblogin.test.email");
        String password = System.getProperty("fblogin.test.password");
        WebElement element = driver.findElement(By.name("email"));
        element.sendKeys(email);
        element = driver.findElement(By.name("pass"));
        element.sendKeys(password);
        element.submit();

        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page URL is: " + driver.getCurrentUrl());

        driver.quit();
    }
}
