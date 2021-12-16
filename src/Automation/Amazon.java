package Automation;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
    public static void main(String[] args)throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KETAKI\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        AddToCart(driver);
    }
    public static void AddToCart(WebDriver driver) throws InterruptedException {
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        WebElement user = driver.findElement(By.id("twotabsearchtextbox"));
        user.sendKeys("christmes gift");
        WebElement enter = driver.findElement(By.id("nav-search-submit-button"));
        enter.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Locating element by link text and store in variable "Element"
        WebElement Element = driver.findElement(By.linkText("Tonkwalas Decoration Item, Christmas Gift, Christmas Mug, Christmas Santa Cap, Coffee Mug, Mug (RT-4)"));

        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);

        Thread.sleep(4000);
        Element.click();
        // add to cart
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.quit();
    }


}






