import Library.Page.HomePage;
import org.junit.Test;

import java.util.logging.Logger;

import static Library.Page.HomePage.city.HYDERABAD;
import static Library.Page.HomePage.driver;

public class StarOfService  {

    private String appointmentTime = "09:30";
    private String duration = "1 hr";
    private String email = "test@test.com";

    Logger logger;

    @Test
    public void getService() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\chromedriver.exe");

        System.out.println("Select the Service");

//        TestBase testbase = new TestBase();
        HomePage homePage = new HomePage();
        homePage.initiateBrowser();
        homePage.waitForPageToLoad();


        System.out.println("Select service");
        homePage.selectCity(HYDERABAD.toString());
//
        System.out.println("Move to popup and click next");
        String mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().defaultContent();

        homePage.clickButton(HomePage.button.NEXT.toString());
        homePage.selectRadioButton(HomePage.radioButton.INSTALL.toString());
        homePage.clickButton(HomePage.button.NEXT.toString());
        homePage.selectRadioButton(HomePage.radioButton.BURST.toString());
        homePage.clickButton(HomePage.button.NEXT.toString());

        homePage.selectRadioButton(HomePage.radioButton.PIPES_AND_DRAINS.toString());
        homePage.clickButton(HomePage.button.NEXT.toString());

        homePage.selectRadioButton(HomePage.radioButton.JUST_RECENTLY.toString());
        homePage.clickButton(HomePage.button.NEXT.toString());

        homePage.selectRadioButton(HomePage.radioButton.BATHROOM.toString());
        homePage.clickButton(HomePage.button.NEXT.toString());

        homePage.selectRadioButton(HomePage.radioButton.MATERIAL_INFO.toString());
        homePage.clickButton(HomePage.button.NEXT.toString());

        homePage.selectRadioButton(HomePage.radioButton.SEWER_WATER.toString());
        homePage.clickButton(HomePage.button.NEXT.toString());

        homePage.selectRadioButton(HomePage.radioButton.HOME.toString());
        homePage.clickButton(HomePage.button.NEXT.toString());

        homePage.selectRadioButton(HomePage.radioButton.YES.toString());
        homePage.clickButton(HomePage.button.NEXT.toString());
        homePage.clickButton(HomePage.button.SKIP.toString());
        homePage.selectCurrentDate();
        homePage.clickButton(HomePage.button.NEXT.toString());
        homePage.selectTime(appointmentTime);
        homePage.clickButton(HomePage.button.NEXT.toString());
        homePage.enterEmail(email);
        driver.quit();

    }

}
