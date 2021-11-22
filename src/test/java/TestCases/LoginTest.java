package TestCases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginTest {
    public static WebDriver driver;
    public static String baseUrl;
    public static String email = "xidiref317@jasmne.com";
    public static String confirmEmail = "xidiref317@jasmne.com";
    public static String userPassword = "Xidiref317";
    public static String confirmPassword = "Xidiref317";
    private Label alert;


    @Given("Kullanıcı Hepsiburada.com sitesini ziyaret eder")
    public void KullaniciHepsiburadacomSitesiniZiyaretEder() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3000, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(3000, SECONDS);
        driver.manage().window().maximize();
        baseUrl = "https://giris.hepsiburada.com/";
        driver.get(baseUrl);
    }
    @When("Kullanıcı giriş işlemi yapılır")
    public void KullaniciGirisIslemiYapilir() {
        driver.findElement(By.id("txtUserName")).sendKeys(email);
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("txtPassword")).sendKeys(userPassword);
        driver.findElement(By.id("btnEmailSelect")).click();
         }

        @And("Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.")
    public void UrunArama() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div/div/div[2]/div[2]/div/div/div/div/div/div/div[1]/div[2]/input")).sendKeys("HD2637/10");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div/div/div[2]/div[2]/div/div/div/div/div/div/div[2]")).click();
        }

        @And("Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden ürün seçer")
    public void UrunSecimi() {
        driver.findElement(By.xpath("//*[@id=\"i0\"]/div")).click();

            String originalHandle = driver.getWindowHandle();

            for (String handle1 : driver.getWindowHandles()) {
                driver.switchTo().window(handle1);

            }
        }

        @And("Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir")
    public void SepeteEkleme() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"productDetailsCarousel\"]/div[1]/div/div[1]/a/picture/img"));

            WebElement satici = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[2]/div[2]/div/div[1]/a"));
            Actions actions = new Actions(driver);
            actions.moveToElement(satici);
            satici.click();

            Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"merchant-list\"]/tbody/tr[4]/td[4]/form/button")).click();
            Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"pcwrapper\"]/div/i")).click();

        driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/button[1]")).click();
            Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/section/section/ul/li/div/div/div[1]/div[2]/div[2]/a")).click();
            Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[2]/div[2]/div/div[2]/table/tbody/tr/td[3]/div/form/button")).click();
            Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"pcwrapper\"]/div/i")).click();

        driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/button[1]")).click();
            Thread.sleep(5000);


        }

    @Then("Seçilen ürünlerin sepete eklendiği görülür.")
    public void SepetKontrol() {

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/section/section/ul/li[1]"));
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/section/section/ul/li[2]"));

        driver.quit();
    }


}