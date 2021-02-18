import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //1. radio button/checkbox----
        //ischecked(), gettext,getattribut("value")

        WebElement webElement = driver.findElement(By.xpath("//input[@value='radio2']"));
        webElement.click();

        //List<WebElement> listOfWebElements = driver.findElements(By.xpath("//input[@name='radioButton']"));
        List<WebElement> listOfWebElements = driver.findElements(By.name("radioButton"));

        for (WebElement individualElement: listOfWebElements) {
            System.out.println("Seleccionado: " + individualElement.isSelected() + " Value: " + individualElement.getAttribute("value"));
        }

        //2.dropdown
        webElement = driver.findElement(By.id("dropdown-class-example"));
        Select ddlOptions = new Select(webElement);

        ddlOptions.selectByVisibleText("Option3");
        ddlOptions.selectByIndex(2);
        ddlOptions.selectByValue("option3");

        System.out.println(ddlOptions.getFirstSelectedOption().getText());


        //3.input
        webElement = driver.findElement(By.id("autocomplete"));
        //charsequence
        webElement.sendKeys("Hola");

        System.out.println("gettext(): " + webElement.getText() + " getattr(): " + webElement.getAttribute("value"));

        //4.element isdisplayed button
        webElement = driver.findElement(By.id("hide-textbox"));
        webElement.click();

        webElement = driver.findElement(By.id("displayed-text"));
        System.out.println("Is Displayed:" + webElement.isDisplayed());

        webElement = driver.findElement(By.id("show-textbox"));
        webElement.click();

        webElement = driver.findElement(By.id("displayed-text"));
        System.out.println("Is Displayed:" + webElement.isDisplayed());

        //5.webtable-findelemtn -> findelements
        webElement = driver.findElement(By.id("product"));

        listOfWebElements = webElement.findElements(By.tagName("tr"));

        for (WebElement rowElement: listOfWebElements) {
            List<WebElement> columnElements = rowElement.findElements(By.tagName("td"));

            for (int i = 0; i < columnElements.size(); i++){
                if(i == 1){
                    if(columnElements.get(i).getText().contains("API")){
                        System.out.println("Existe un curso sobre API");
                    }
                }
            }

        }

        //driver quit y close();dasdasdas
        driver.quit();


    }
}
