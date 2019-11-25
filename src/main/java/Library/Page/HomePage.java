package Library.Page;

import Webdriver.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Calendar;
import java.util.Formatter;
import java.util.concurrent.TimeUnit;

/**
 * Home page class
 *
 * @author saranya
 */
public class HomePage {

    private static final String citySearchTextArea = "//div[@class='clearfix angucomplete-holder']/input[@name='postal_code_input']";
    private static final String DROPDOWN_CITY_VALUE = "//div[@class='autocomplete-suggestions angucomplete-dropdown hide']/div[@data-val='%1$s']";
    private static final String POP_UP_BUTTON_TEMPLATE = "//button[contains(.,'%1$s')]";
    private static final String OPTION_RADIO_BUTTON_TEMPLATE = "//div[@class='styles__itemContainerV2___3T5rr styles__itemContainerBase___2bhyD']//div[contains(.,'%1$s')]";
    private static final String SELECT_TIME_TEMPLATE = "//label[contains(.,'At what time')]/following::select[@data-test='step_time']";
    private static final String DURATION_TEXT_BOX_TEMPLATE = "//label[contains(.,'For how long?')]/following::input[@data-test='step_duration']";
    private static final String EMAIL_TEXTBOX_TEMPLATE = "//label[contains(.,'Email address')]/following::input[@placeholder='Email address']";
    private static final String DATE_PICKER_TITLE_TEMPLATE = "//div[@class=CalendarMonthGrid_month__horizontal CalendarMonthGrid_month__horizontal_1]/following::*[@class=CalendarMonth_caption CalendarMonth_caption_1]/strong";
    private static final String DATE_TEMPLATE = "//div[@class='CalendarMonthGrid_month__horizontal CalendarMonthGrid_month__horizontal_1']//tr//td//button[@aria-label[contains(.,'%1$s %2$s')]]";
    public static WebDriver driver = new ChromeDriver();
    private static String timeoutForPageLoad = "60000";

    public enum city {
        HYDERABAD("Hyderabad");
        private String name;

        private city(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }

    }

    public enum button {
        NEXT("Next"),
        SKIP("Skip");
        private String button;

        private button(String button) {
            this.button = button;
        }

        public String toString() {
            return button;
        }
    }

    public enum radioButton {
        INSTALL("Install"),
        BURST("Burst"),
        PIPES_AND_DRAINS("Pipes and drains"),
        JUST_RECENTLY("Just recently"),
        BATHROOM("Bathroom"),
        MATERIAL_INFO("Yes, I will provide the materials and parts"),
        SEWER_WATER("Sewer water"),
        HOME("Home"),
        YES("Yes");
        private String button;

        private radioButton(String button) {
            this.button = button;
        }

        public String toString() {
            return button;
        }
    }

    /**
     * Initiates browser
     */
    public void initiateBrowser() {
        WebDriver driver = new ChromeDriver();
        driver.get(Constant.url);
    }


    public String getTimeoutForPageLoad() {
        return timeoutForPageLoad;
    }

    public void waitForPageToLoad() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void enterTextIntoCitySearch(String city) {
        WebElement textArea = driver.findElement(By.xpath(citySearchTextArea));
        textArea.clear();
        textArea.sendKeys(city);
    }

    public void click(WebElement element) {
        element.click();

    }

    public void selectCityFromDropdown(String cityName) {
        waitForPageToLoad();
        click(driver.findElement(By.xpath(String.format(DROPDOWN_CITY_VALUE, cityName))));
    }

    public void selectCity(String cityName) {
        enterTextIntoCitySearch("Hyd");
        waitForPageToLoad();
        selectCityFromDropdown(cityName);


    }

    public void clickButton(String label) {
        WebElement nextBtn = driver.findElement(By.xpath(String.format(POP_UP_BUTTON_TEMPLATE, label)));
        click(nextBtn);
    }

    public void selectRadioButton(String option) {
        WebElement radioBtn = driver.findElement(By.xpath(String.format(OPTION_RADIO_BUTTON_TEMPLATE, option)));
        radioBtn.click();
    }
//
//    }
//    public void selectTypeOfWork(String type){
//        WebElement radioBtn = driver.findElement(By.xpath(""));
//        clickButton("");
//
//    }
//    public void selectProblem(String problem){
//        WebElement radioBtn = driver.findElement(By.xpath(""));
//        clickButton("");
//    }
//    public void specifyPart(String part){
//        WebElement radioBtn = driver.findElement(By.xpath(""));
//    }
//
//    public void selectDuration(String duration){
//        WebElement radioBtn = driver.findElement(By.xpath(""));
//    }
//    public void selectRoom(String room){
//        WebElement radioBtn = driver.findElement(By.xpath(""));
//    }
//    public void selectMaterials(String material){
//        WebElement radioBtn = driver.findElement(By.xpath(""));
//    }
//    public void selectWaterResource(String waterResource){
//        WebElement radioBtn = driver.findElement(By.xpath(""));
//    }
//    public void selectTypeOfProperty(String type){
//        WebElement radioBtn = driver.findElement(By.xpath(""));
//    }
//    public void selectBuildingInfo(String buildingInfo){
//        WebElement radioBtn = driver.findElement(By.xpath(""));
//    }
//    public void selectDate(String date){
//        WebElement radioBtn = driver.findElement(By.xpath(""));
//    }
//    public void selectTime(String time){
//        WebElement radioBtn = driver.findElement(By.xpath(""));
//    }
//    public void enterEmail(String email){
//        WebElement radioBtn = driver.findElement(By.xpath(""));
//    }

    public void selectTime(String time) {
        Select dropdownValue = new Select(driver.findElement(By.xpath(SELECT_TIME_TEMPLATE)));
        dropdownValue.selectByIndex(2);

    }

    public void addDuration(String duration) {
        WebElement textBox = driver.findElement(By.xpath(DURATION_TEXT_BOX_TEMPLATE));
        textBox.sendKeys(duration);
    }

    public void enterEmail(String email) {
        WebElement textBox = driver.findElement(By.xpath(EMAIL_TEXTBOX_TEMPLATE));
        textBox.sendKeys(email);
    }

    public String getDatePicketTitle() {
        WebElement title = driver.findElement(By.xpath(DATE_PICKER_TITLE_TEMPLATE));
        String text = title.getText();
        return text;
    }

    public void scrollDown() {
        JavascriptExecutor js = null;
        js.executeScript("window.scrollTo(0,document.boxy.scrollHeight)");

    }

    public void selectCurrentDate() {
//        scrollDown();
        Formatter fmt = new Formatter();
        Calendar calendar = Calendar.getInstance();
        String month = String.valueOf(fmt.format("%tB", calendar));
        System.out.println("month:" + month);
        waitForPageToLoad();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        WebElement webElement = driver.findElement(By.xpath(String.format(DATE_TEMPLATE, month, day)));
        webElement.click();
    }

}