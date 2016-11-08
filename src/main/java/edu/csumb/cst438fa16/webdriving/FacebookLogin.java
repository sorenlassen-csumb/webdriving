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
    /*
       Takes a single argument which is a URL with a Facebook login button
       and expects Facebook login email and password in system properties
       fblogin.test.email and fblogin.test.password.
       With Maven you can run it with this command line:
       mvn compile exec:java \
       -Dfblogin.test.email=$TESTUSER -Dfblogin.test.password=$TESTPASSWORD \
       -Dexec.mainClass=edu.csumb.cst438fa16.webdriving.FacebookLogin \
       -Dexec.args='http://localhost:8080/login.html'
    */
    public static void main(String[] args) {
        System.out.println("URL to get: " + args[0]);

        WebDriver driver = new ChromeDriver();

        driver.get(args[0]);

        (new WebDriverWait(driver, 10)).until(
            ExpectedConditions.presenceOfElementLocated(
                By.tagName("fb:login-button")));

        // Title should be Test2 login, url should be .../login.html
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page URL is: " + driver.getCurrentUrl());

        driver.findElement(By.tagName("fb:login-button")).click();

        // Await Facebook login pop up window
        (new WebDriverWait(driver, 10)).until(
            ExpectedConditions.numberOfWindowsToBe(2));

        // Switch to Facebook login pop up window
        String home = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals("Facebook")) break;
        }
        // Title should be Facebook, url should be a Facebook url
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page URL is: " + driver.getCurrentUrl());

        String email    = System.getProperty("fblogin.test.email");
        String password = System.getProperty("fblogin.test.password");
        WebElement element = driver.findElement(By.name("email"));
        element.sendKeys(email);
        element = driver.findElement(By.name("pass"));
        element.sendKeys(password);
        element.submit();

        // Switch away from the Facebook pop up window
        driver.switchTo().window(home);

        // Title should be Facebook Login JavaScript Example, url .../index.hmtl
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page URL is: " + driver.getCurrentUrl());

        driver.quit();
    }
}
