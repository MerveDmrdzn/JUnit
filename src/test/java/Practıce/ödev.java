package Practıce;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class ödev {

     // ilgili kurulumlari tamamlayalim
     // Kullanici https://www.google.com adresine gider
     // Çıkıyorsa Kullanici cookies i kabul eder
     // Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
     // Para birimlerinin karsilastirmasini alin
     // Karsilastirilacak olan para biriminin 1.5 den kUCUk oldygu test edilir

    static WebDriver driver;
    WebElement searchbox;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Before
    public void before() {
        driver.get("https://www.google.com");
        searchbox = driver.findElement(By.xpath("//*[@title='Ara']"));
    }
    @After
    public void after() {
        WebElement result = driver.findElement(By.id("result-stats"));
        System.out.println(result.getText());
    }
    @Test
    public void test01() {
        //driver.findElement(By.xpath("//div[text()='Tümünü reddet']")).click(); // Cookie den kurtulduk
        searchbox.sendKeys("TL € $ karşılaştırma" + Keys.ENTER);


    }

  @Test
public void test(){
        WebElement sayfaKontrol= driver.findElement(By.id("rcnt"));
      Set<Cookie>searchbox=driver.manage().getCookies();


    }
}