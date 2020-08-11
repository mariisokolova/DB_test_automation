package page;

import block.FooterMenu;
import block.HeaderMenu;
import block.NavMenu;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class HomePage {

    @FindBy(css = "[id=\"top-menu\"] h2")
    private WebElement namePage;

    @FindBy(css = "[class=\"gb-empopup-close\"]")
    private WebElement buttonClosePopUp1;

    @FindBy(css = "button [class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonClosePopUp2;

    private FooterMenu footerMenu;
    private HeaderMenu headerMenu;
    private NavMenu navMenu;

    public HomePage(WebDriver driver) {
        initElements(driver, this);
        footerMenu = new FooterMenu(driver);
        headerMenu = new HeaderMenu(driver);
        navMenu = new NavMenu(driver);
    }

    public FooterMenu getFooterMenu(){
        return footerMenu;
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public NavMenu getNavMenu(){
        return navMenu;
    }

    @Step("Проверить заголовок страницы")
    public void checkNamePage(String expectedNamePage) {
        Assertions.assertEquals(expectedNamePage, namePage.getText());
    }

    @Step("Закрыть попап 1")
    public WebElement getButtonClosePopUp1() {
        return buttonClosePopUp1;
    }

    @Step("Закрыть попап 2")
    public WebElement getButtonClosePopUp2() {
        return buttonClosePopUp2;
    }

}
