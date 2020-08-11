package block;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterMenu extends PageFactory {
    @FindBy(css = "[class='site-footer__content']")
    private WebElement footer;

    public FooterMenu(WebDriver driver) {
        initElements(driver, this);
    }

    @Step("Найти footer на странице")
    public WebElement getFooterExist() {
        return footer;
    }
}
