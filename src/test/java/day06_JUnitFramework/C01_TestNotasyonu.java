package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {
    /*
Bu class içerisinde 3 test calılturalım
1- google anasayfaya gidip, url'nin goggle içerdiğini test edin
2- wisequarter anasayfaya gidip url'nin wisequarter içerdiğini test edin
3-amazon anasayfaya gidip,amazon logosunun gorunduğunu test edin
 */

/*
JUnit'in bize sağladığı ilk ve belkide en önemli özellik
test methodlarının bağımsız olarak calıştırlıabilmesini sağlayan
@Test notasyonudur.

JUnit ile class level'dan birden fazla test method'u calıştırırsak
hangi sıralama ile calıştıracağını öngöremeyiz ve yönetemeyiz.
*/


   WebDriver driver;
    @Test @Ignore
   public void googleTest(){
       //google anasayfaya gidip, url'in google icerdigini test edin
       Mahserin4Atlısı();
       driver.get("https://www.google.com");
       String expectedIcerik="google";
       String actualUrl= driver.getCurrentUrl();

       if (actualUrl.contains(expectedIcerik)){
           System.out.println("Google test PASSED");
       }else {
           System.out.println("Url google içermiyor,test FAILED");
       }


    }

    @Test
    public void wiseTest(){
       //wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
        Mahserin4Atlısı();
        driver.get("https://www.wisequarter.com");
        String expectedIcerik="wisequarter";
        String actualUrl= driver.getCurrentUrl();
        System.out.println( "wise test");

        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Wise test PASSED");
        }else {
            System.out.println("Url wise içermiyor,test FAILED");
        }
    }

   @Test
   public void amazonTest(){
       //3-amazon anasayfaya gidip,amazon logosunun gorunduğunu test edin
       Mahserin4Atlısı();
       driver.get("https://www.amazon.com");
       WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));

       if (amazonLogo.isDisplayed()){
           System.out.println("amazon test PASSED");
       }else {
           System.out.println("Amazon logosu görünmüyor ,test FAILED");
       }

       driver.close();
    }

    public void Mahserin4Atlısı(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}
