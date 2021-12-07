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

public class Registration {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    static String index = LeroyMerlin.emailIndex;
    public static boolean testCaseRegistrationSuccess = true;

    public static void main(String[] args){

        System.out.println(ANSI_RESET + "ТЕСТ-КЕЙС РЕГИСТРАЦИЯ НОВОГО ПОЛЬЗОВАТЕЛЯ" + ANSI_RESET);

        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try{
            driver.get("https://spb.leroymerlin.ru/lk/register/");
            System.out.println(ANSI_GREEN + "Страница регистрации открыта - успех" + ANSI_GREEN);
        } catch (Exception e){
            System.out.println(ANSI_RED + "Страница регистрации открыта - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }


        try {
            driver.findElement(By.xpath(" //div[@class=\"control-inputs\"]"));
            System.out.println(ANSI_GREEN + "Форма регистрации найдена - успех" + ANSI_GREEN);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Форма регистрации найдена - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }


        try {
            driver.findElement(By.xpath("//div[@class=\"control-inputs\"]//input[@name='mail']")).sendKeys("xowapi" + index + "@ineedsa.com");
            System.out.println(ANSI_GREEN + "Поле почты заполнено - успех" + ANSI_GREEN);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Поле почты заполнено - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }


        try {
            driver.findElement(By.xpath("//div[@class=\"control-inputs\"]//input[@name='first-name']")).sendKeys("xo");
            System.out.println(ANSI_GREEN + "Поле имя заполнено - успех" + ANSI_GREEN);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Поле имя заполнено - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }


        try {
            driver.findElement(By.xpath("//div[@class=\"control-inputs\"]//input[@name='second-name']")).sendKeys("wapi");
            System.out.println(ANSI_GREEN + "Поле фамилия заполнено - успех" + ANSI_GREEN);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Поле фамилия заполнено - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }


        try {
            driver.findElement(By.xpath("//div[@class=\"control-inputs\"]//input[@name='pass']")).sendKeys("Aa123456");
            System.out.println(ANSI_GREEN + "Поле пароля заполнено - успех" + ANSI_GREEN);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Поле пароля заполнено - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }


        try {
            if (driver.findElement(By.xpath("//div[@class=\"control-inputs\"]//input[@name='pass']")).getAttribute("type").equals("password")){
                System.out.println(ANSI_GREEN + "Поле пароля имеет правильный тип - успех" + ANSI_GREEN);
            }else {
                System.out.println(ANSI_RED + "Поле пароля имеет правильный тип - провал" + ANSI_RED);
                testCaseRegistrationSuccess = false;
            }
        } catch ( Exception e) {
            System.out.println(ANSI_RED + "Проверить тип поля для пароля - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }


        try {
            driver.findElement(By.xpath("//div[@class=\"control-inputs\"]//input[@name='passRepeat']")).sendKeys("Aa123456");
            System.out.println(ANSI_GREEN + "Поле повтор пароля заполнено - успех" + ANSI_GREEN);
            try{
                driver.findElement(By.xpath("//span[@class=\"help-block help-block-active\"]"));
                System.out.println(ANSI_RED + "Введнные значения корректные - провал" + ANSI_RED);
                testCaseRegistrationSuccess = false;
            }catch (Exception e){
                System.out.println(ANSI_GREEN + "Введнные значения корректные - успех" + ANSI_GREEN);
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Поле повтор пароля заполнено - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }


        try {
            if (driver.findElement(By.xpath("//div[@class='control-inputs']//input[@name='passRepeat']")).getAttribute("type").equals("password")){
                System.out.println(ANSI_GREEN + "Поле повтора пароля имеет правильный тип - успех" + ANSI_GREEN);
            }else {
                System.out.println(ANSI_RED + "Поле повтора пароля имеет правильный тип - провал" + ANSI_RED);
                testCaseRegistrationSuccess = false;
            }
        } catch ( Exception e) {
            System.out.println(ANSI_RED + "Проверить тип поля повтора пароля - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }

        try {
            driver.findElement(By.xpath("//span[.='Обязательное поле']"));
            System.out.println(ANSI_RED + "Обязательные поля заполнены - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        } catch (Exception e) {
            System.out.println(ANSI_GREEN + "Обязательные поля заполнены - успех" + ANSI_GREEN);
        }


        try{
            driver.findElement(By.xpath("//span[@class='help-block help-block-active']"));
            System.out.println(ANSI_RED + "Введнные значения корректные - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }catch (Exception e){
            System.out.println(ANSI_GREEN + "Введнные значения корректные - успех" + ANSI_GREEN);
        }


        try {
            driver.findElement(By.xpath("//label[@for = 'cbNews']")).click();
            System.out.println(ANSI_GREEN + "Нажать на чек-бокс подписки - успех" + ANSI_GREEN);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Нажать на чек-бокс подписки - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }


        try {
            if (driver.findElement(By.xpath("//button[@type='submit']")).getAttribute("disabled").equals("true")){
                System.out.println(ANSI_GREEN + "Кнопка регистрации НЕ доступна без принятия условий - успех" + ANSI_GREEN);
            }else {
                System.out.println(ANSI_RED + "Кнопка регистрации НЕ доступна без принятия условий - провал" + ANSI_RED);
                testCaseRegistrationSuccess = false;
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Найти кнопку регистрации - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }


        try {
            driver.findElement(By.xpath("//a[@class='green-link']")).click();
            System.out.println(ANSI_GREEN + "Ссылка на юридические документы нажата - успех" + ANSI_GREEN);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Ссылка на юридические документы нажата - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }


        try {
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"rte-header\"]")));
            if(driver.findElement(By.xpath("//span[@class=\"rte-header\"]")).getText().equals("Согласие на обработку персональных данных")){
                System.out.println(ANSI_GREEN + "Юридические документы открываются в новой вкладке - успех" + ANSI_GREEN);
            }
            driver.close();
            driver.switchTo().window(tabs.get(0));
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Юридические документы открываются в новой вкладке - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }


        try {
            ((JavascriptExecutor)driver).executeScript("document.querySelector('.custom-checkbox-label').click()");
            System.out.println(ANSI_GREEN + "Нажать чек-бокс согласия с правилами - успех" + ANSI_GREEN);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Нажать чек-бокс согласия с правилами - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }


        try {
            driver.findElement(By.xpath("//button[@class = 'btn green-button registration-submit-button']")).click();
            System.out.println(ANSI_GREEN + "Нажать кнопку регистрации - успех" + ANSI_GREEN);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Нажать кнопку регистрации - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-name ='purchase-history']")));
            System.out.println(ANSI_GREEN + "Переход на страницу личного окабинета за 10 сек - успех" + ANSI_GREEN);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Переход на страницу личного кабинета за 10 сек - провал" + ANSI_RED);
            testCaseRegistrationSuccess = false;
        }

        driver.quit();

        if (testCaseRegistrationSuccess){
            System.out.println();
            System.out.println(ANSI_GREEN + "Тест-кейс выполнен успешно" + ANSI_GREEN);
        } else {
            System.out.println();
            System.out.println(ANSI_RED + "Тест-кейс провален" + ANSI_RED);
        }
    }
}