package hackmedia.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);


        driver.get("https://rutube.ru/video/2209049b9c09f7b8e058ef015af7164d");



        driver.manage().addCookie(new Cookie("sessionid","o8lyzzemm0elm6fkll1hrqqnr4j5ytj9"));

        driver.get("https://rutube.ru/video/2209049b9c09f7b8e058ef015af7164d");
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
            List<WebElement> webElements = driver.findElements(By.tagName("iframe"));


        String src = webElements.get(0).getAttribute("src");



        ((ChromeDriver) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                webElements.get(0),
                "src",
                src+"&bmstart=200"

        );


        Thread.sleep(2000);
        webElements.get(0).click();
        ((ChromeDriver) driver).getKeyboard().pressKey("F");
        Thread.sleep(1000);
        webElements.get(0).click();


    }
}
