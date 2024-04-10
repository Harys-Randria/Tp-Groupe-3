package mg.inclusiv.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunctionalTest {

    WebDriver driver = new ChromeDriver();



    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testFunctionality() {
        // Tester la fonctionnalité du contrôleur AuthController
        driver.get("http://localhost:8080/");
        assertEquals("Login", driver.getTitle());

        // Tester la fonctionnalité du contrôleur ErrorController avec une erreur simulée
        driver.get("http://localhost:8080/someInvalidURL");
        assertEquals("Error", driver.getTitle());
        assertTrue(driver.getPageSource().contains("Unknown error"));

        // Tester la fonctionnalité du contrôleur HomeController
        driver.get("http://localhost:8080/");
        assertEquals("Home", driver.getTitle());
        List<WebElement> taskElements = driver.findElements(By.className("task"));
        assertTrue(taskElements.size() > 0); // Vérifier s'il y a des éléments de tâche sur la page
    }
}

