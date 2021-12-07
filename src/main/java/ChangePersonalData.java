import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ChangePersonalData{
    public static final String ANSI_RESET = "\u001B[0m"; 
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static boolean testCaseChangeDataSuccess = true;
    public static void main(String[] args) throws InterruptedException {

        System.out.println(ANSI_RESET + "ТЕСТ-КЕЙС ИЗМЕНЕНИЕ ЛИЧНЫХ ДАННЫХ" + ANSI_RESET);

        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        System.out.println("Предусловие: пользователь вошёл на сайт");

        try{
            driver.get("https://leroymerlin.ru/login");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='oauth-iframe']")));
            driver.switchTo().frame("oauth-iframe");
            driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("xowapi1@ineedsa.com");
            driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Aa123456");
            driver.findElement(By.xpath("//input[@value=\"Войти\"]")).click();
            System.out.println(ANSI_GREEN + "Страница входа - успех" + ANSI_GREEN);
        } catch (Exception e){
            System.out.println(ANSI_RED + "Страница входа - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }


        Thread.sleep(5000);


        try {
            driver.navigate().to("https://leroymerlin.ru/lk/");
            driver.findElement(By.xpath("//ul[@class='lk-menu__nodes']//span[text()[contains(.,'Личные данные')]]")).click();
            System.out.println(ANSI_GREEN + "Переход в личный кабинет - успех" + ANSI_GREEN);
        }catch (Exception e) {
            System.out.println(ANSI_RED + "Переход в личный кабинет - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }

        try{
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()[contains(.,'Изменить персональные данные')]]")));
            System.out.println(ANSI_GREEN + "Страница регистрации входа - успех" + ANSI_GREEN);
        } catch (Exception e){
            System.out.println(ANSI_RED + "Страница регистрации входа - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()[contains(.,'Изменить персональные данные')]]")));
            System.out.println(ANSI_GREEN + "Переход на вкладку личных уданных за 5 сек - успех" + ANSI_GREEN);
        }catch (Exception e) {
            System.out.println(ANSI_RED + "Переход на вкладку личных уданных за 5 сек - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }


        try {
            driver.findElement(By.xpath("//span[text()[contains(.,'Изменить персональные данные')]]")).click();
            System.out.println(ANSI_GREEN + "Переход в режим изменения персональных данных - успех" + ANSI_GREEN);
            Thread.sleep(1000);
        }catch (Exception e) {
            System.out.println(ANSI_RED + "Переход в режим изменения персональных данных - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }


        try {
            driver.findElement(By.id("user-name")).sendKeys("ro");
            System.out.println(ANSI_GREEN + "Ввод в поле имени пользователя - успех" + ANSI_GREEN);
        }catch (Exception e) {
            System.out.println(ANSI_RED + "Ввод в поле имени пользователя - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }


        try {
            if (driver.findElement(By.xpath("//input[@name='user-second-name']")).getAttribute("disabled").equals("true")){
                System.out.println(ANSI_GREEN + "Изменение фамилия недоступно - успех" + ANSI_GREEN);
            }else {
                System.out.println(ANSI_RED + "Изменение фамилия недоступно - провал" + ANSI_RED);
                testCaseChangeDataSuccess = false;
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Найти поле фамилии - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }

        try {
            driver.findElement(By.xpath("//input[@name='user-phone']")).sendKeys("9998887766");
            System.out.println(ANSI_GREEN + "Ввод в поле мобильного телефона - успех" + ANSI_GREEN);
        }catch (Exception e) {
            System.out.println(ANSI_RED + "Ввод в поле мобильного телефона - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }


        try {
            driver.findElement(By.xpath("//input[@name='user-phone-home']")).sendKeys("1112223344");
            System.out.println(ANSI_GREEN + "Ввод в поле домашнего телефона - успех" + ANSI_GREEN);
        }catch (Exception e) {
            System.out.println(ANSI_RED + "Ввод в поле домашнего телефона - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }


        try{
            if (driver.findElement(By.xpath("//button[@type='submit']")).getAttribute("disabled").equals("true")){
                System.out.println(ANSI_GREEN + "Кнопка регистрации НЕ доступна без принятия условий - успех" + ANSI_GREEN);
            }else {
                System.out.println(ANSI_RED + "Кнопка регистрации доступна без принятия условий - провал" + ANSI_RED);
                testCaseChangeDataSuccess = false;
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Кнопка регистрации НЕ найдена - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }

        try {
            driver.findElement(By.xpath("//a[@class='green-link']")).click();
            System.out.println(ANSI_GREEN + "Ссылка на юридические документы нажата - успех" + ANSI_GREEN);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Ссылка на юридические документы НЕ найдена - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }


        try {
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"rte-header\"]")));
            if(driver.findElement(By.xpath("//span[@class=\"rte-header\"]")).getText().equals("Согласие на обработку персональных данных")){
                System.out.println(ANSI_GREEN + "Юридические документы открываются в новой вкладке - успех" + ANSI_GREEN);
            }
            driver.close();
            driver.switchTo().window(tabs.get(0));
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Юридические документы в новой вкладке НЕ открываются - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }


        try {
            ((JavascriptExecutor)driver).executeScript("document.querySelector('.custom-checkbox-label').click()");
            System.out.println(ANSI_GREEN + "Нажали чек-бокс согласия с правилами - успех" + ANSI_GREEN);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Чек-бокс согласия с правилами НЕ найден - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }

        try {
            driver.findElement(By.xpath("//button[@class = 'btn green-button']")).click();
            System.out.println(ANSI_GREEN + "Нажали кнопку сохранения - успех" + ANSI_GREEN);
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Кнопка сохранения НЕ нажата - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }


        try {
            driver.findElement(By.xpath("//input[@value='xoro']"));
            System.out.println(ANSI_GREEN + "Изменение имени - успех" + ANSI_GREEN);
        } catch (Exception e){
            System.out.println(ANSI_RED + "Изменение имени - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }

        try {
            driver.findElement(By.xpath("//input[@value='+79998887766']"));
            System.out.println(ANSI_GREEN + "Изменение мобильного телефона - успех" + ANSI_GREEN);
        } catch (Exception e){
            System.out.println(ANSI_RED + "Изменение мобильного телефона - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }


        try {
            driver.findElement(By.xpath("//input[@value='+71112223344']"));
            System.out.println(ANSI_GREEN + "Изменение домашнего телефона - успех" + ANSI_GREEN);
        } catch (Exception e){
            System.out.println(ANSI_RED + "Изменение домашнего телефона - провал" + ANSI_RED);
            testCaseChangeDataSuccess = false;
        }

        driver.quit();

        if (testCaseChangeDataSuccess){
            System.out.println();
            System.out.println(ANSI_GREEN + "Тест-кейс выполнен успешно" + ANSI_GREEN);
        } else {
            System.out.println();
            System.out.println(ANSI_RED + "Тест-кейс провален" + ANSI_RED);
        }
    }
}
