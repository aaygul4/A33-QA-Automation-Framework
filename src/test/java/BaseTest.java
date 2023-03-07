import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;
public class BaseTest {

    public static WebDriver driver = null;
//    public static String url = "https://bbb.testpro.io";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public static void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }

    public static void openLoginUrl() throws InterruptedException {
        String url = "https://bbb.testpro.io";
        driver.get(url);
        Thread.sleep(2000);
    }
//    public static void login(String email, String password) throws InterruptedException {
//        provideEmail(email);
//        providePassword(password);
//        clickSubmit();

    public static void provideEmail(String email) throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
        Thread.sleep(2000);
    }

    public static void providePassword(String password) throws InterruptedException {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
        Thread.sleep(2000);
    }

    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }

    //*    public void clickPlayButton() throws InterruptedException {
//        WebElement playButton = driver.findElement(By.xpath("//*[@data-testid='play-btn']"));
//        WebElement playNextSongButton = driver.findElement(By.xpath("//*[@data-testid='play-next-btn']"));
//        playNextSongButton.click();
//        playButton.click();
//        Thread.sleep(3000);
//
////        "//*[@id='mainFooter']/div[1]/span/span[2]"
//    }
//    public boolean theSongIsPlaying() {
//        WebElement soundIsPlaying = driver.findElement(By.xpath("//*[@data-testid='sound-bar-play']"));
//        return soundIsPlaying.isDisplayed();
//*    }
    public static void SearchLine(String searchSong) throws InterruptedException {
        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        search.sendKeys(searchSong);
        Thread.sleep(2000);
    }

    public static void clickViewAll() throws InterruptedException {
        WebElement openViewAll = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div/div/section[1]/h1/button"));
        openViewAll.click();
        Thread.sleep(2000);
    }

    public static void firstSongResults() throws InterruptedException {
        WebElement clickSongSearchResults = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[2]"));
        clickSongSearchResults.click();
        Thread.sleep(2000);
    }

    public static void clickAddToButton() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/span/button[2]"));
        addToButton.click();
        Thread.sleep(2000);
    }

    public static void createNewPlaylist() throws InterruptedException {
        WebElement newPlaylist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[2]/form/input"));
        newPlaylist.sendKeys("Playlist1");
        Thread.sleep(2000);
    }

    public static void clickSubmitNewPlaylistButton() throws InterruptedException {
        WebElement clickSubmitButton = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[2]/form/button"));
        clickSubmitButton.click();
        Thread.sleep(2000);
    }
    public static void getNotification() throws InterruptedException {
        WebElement notificationElement = driver.findElement(By.xpath("/html/body/div[2]"));
        notificationElement.isDisplayed();
        Thread.sleep(2000);
    }
    public static void deletePlaylist() throws InterruptedException {
        WebElement selectedPlaylist = driver.findElement(By.xpath("//*[@class='playlist playlist']"));
        selectedPlaylist.click();
        Thread.sleep(2000);
    }
    public static void clickToDeletePlaylistButton() throws InterruptedException {
        WebElement deletePlaylistButton = driver.findElement(By.xpath("//*[@class='del btn-delete-playlist']"));
        deletePlaylistButton.click();
        Thread.sleep(1000);
    }
    public static void deletePlaylistPopsUpWindow() throws InterruptedException {
        WebElement deletePlaylistPopsUp = driver.findElement(By.xpath("//*[@class='msg']"));
        deletePlaylistPopsUp.isDisplayed();
        Thread.sleep(1000);
    }
    public static void clickDeleteOkButton() throws InterruptedException {
        WebElement deletePlaylistOkButton = driver.findElement(By.xpath("//*[@class='ok']"));
        deletePlaylistOkButton.click();
        Thread.sleep(1000);
    }
    public static boolean notificationMessageDeletePlaylist()  {
        WebElement notificationMsgDeletePlaylist = driver.findElement(By.xpath("//*[@class='alertify-logs top right']"));
        return notificationMsgDeletePlaylist.isDisplayed();
    }
}