package hackmedia.demo.service;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeleniumService {

    public void openVideo(String url, String seconds) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);


        driver.get(url);



        driver.manage().addCookie(new Cookie("sessionid","o8lyzzemm0elm6fkll1hrqqnr4j5ytj9"));

        driver.get(url);
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        List<WebElement> webElements = driver.findElements(By.tagName("iframe"));


        String src = webElements.get(0).getAttribute("src");



        ((ChromeDriver) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                webElements.get(0),
                "src",
                src+"&bmstart="+seconds

        );


        Thread.sleep(2000);
        webElements.get(0).click();
        ((ChromeDriver) driver).getKeyboard().pressKey("F");
        Thread.sleep(1000);
        webElements.get(0).click();
    }
}
