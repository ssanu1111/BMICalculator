package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BMICalculatorAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Admin\\IdeaProjects\\untitled\\src\\driver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://www.calculatestuff.com/health/bmi-calculator");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement weightInput = driver.findElement(By.id("pounds"));
            WebElement heightInput = driver.findElement(By.id("feet"));
            weightInput.clear();
            weightInput.sendKeys("70");
            heightInput.clear();
            heightInput.sendKeys("5");
            WebElement calculateButton = driver.findElement(By.id("calculate-button"));
            calculateButton.click();
            Thread.sleep(2000);
            WebElement result = driver.findElement(By.id("results"));
            System.out.println("BMI Result: " + result.getText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

