package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {

    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement emailForm;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement passwordForm;

    @FindBy(xpath = "//input[@class='btn btn-block btn-success']")
    private WebElement submitButton;

    private WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Авторизация в Geekbrains")
    public AuthorizationPage authorization(String login, String password) {
        emailForm.sendKeys(login);
        passwordForm.sendKeys(password);
        submitButton.click();
        return new AuthorizationPage(driver);
    }

}
