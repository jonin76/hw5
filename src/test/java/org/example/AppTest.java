package org.example;


import ch.qos.logback.classic.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private static Logger logger = (Logger) LoggerFactory.getLogger(AppTest.class);

    static WebDriver webDriver;
    static WebElement webElement;

    @BeforeAll
    static void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(10));
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @BeforeEach
    void initMainPage(){
        Assertions.assertDoesNotThrow( ()-> webDriver.navigate().to("https://lk.aqsi.ru/login"),
                "Страница не доступна");
    }

    @Test
    void test1() {
        WebElement webElement = webDriver.findElement(By.xpath("//div[@id=\"app-root\"]/div/section/div/form/div/div[5]/button/span[1]"));
        webElement.click();

        Actions actions = new Actions(webDriver);
        actions.sendKeys(webDriver.findElement(By.name("emailOrPhone")), "gea+t1@aqsi.ru").click(webElement)
                .sendKeys(webDriver.findElement(By.name("password")),"Qq123456").click(webElement).build().perform();

        webDriver.findElement(By.xpath("//div[@id=\"app-root\"]/div/div/div/div/div[1]/ul[2]/div[2]/a/div[2]/p")).click();
        webDriver.findElement(By.xpath("//div[3]/div[3]/div/div[1]/a/div/p")).click();
        webDriver.findElement(By.xpath("//main[@class=\"jss266\"]/header/div[1]/div/div/div[1]/button/span[1]/h5")).click();
        webDriver.findElement(By.xpath("//main[@class=\"jss266\"]/div[2]/div[2]/button/span[1]")).click();
        webDriver.findElement(By.name("name")).sendKeys("Категория3");
        webDriver.findElement(By.id("mui-component-select-defaultPaymentMethodType")).click();
        webDriver.findElement(By.cssSelector(".font-loaded")).click();
        webDriver.findElement(By.xpath("//div[@id=\"mui-component-select-defaultTax\"]")).click();
        webDriver.findElement(By.xpath("//div[@id=\"menu-defaultTax\"]/div[3]/ul/li[1]")).click();
        webDriver.findElement(By.xpath("//div[3]/div[3]/div/div[2]/form/div/div[12]/div/div/button")).click();
        webDriver.findElement(By.xpath("//p[@title=\"Категория3\"]")).click();
        webDriver.findElement(By.xpath("//div[@id=\"app-root\"]/div/main/header/div[1]/div/div/div[4]/a/span[1]/span")).click();
        webDriver.findElement(By.name("name")).sendKeys("Латте");
        webDriver.findElement(By.name("price")).sendKeys("199");
        webDriver.findElement(By.xpath("//*[@id=\"app-root\"]/div/main/header/div[1]/div/div/div[2]/div/div[3]/button")).click();



    }

    @Test
    void test2(){
        WebElement webElement = webDriver.findElement(By.xpath("//div[@id=\"app-root\"]/div/section/div/form/div/div[5]/button/span[1]"));
        webElement.click();

        Actions actions = new Actions(webDriver);
        actions.sendKeys(webDriver.findElement(By.name("emailOrPhone")), "gea+t1@aqsi.ru").click(webElement)
                .sendKeys(webDriver.findElement(By.name("password")),"Qq123456").click(webElement).build().perform();

        webDriver.findElement(By.xpath("//*[@id=\"app-root\"]/div/div/div/div/div[1]/ul[1]/div[3]/a/div[2]/p")).click();
       // webDriver.findElement(By.xpath("//*[@id=\"app-root\"]/div/main/header/div[1]/div/div/div[2]/div/div[2]/button/span[1]/span")).click();

    }






}