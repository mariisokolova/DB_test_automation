package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CoursePage {

    @FindBy(css = "[id=\"cour-link\"]")
    private WebElement submenuCourse;

    @FindBy(xpath = "//div[@class='course-filter affix-top']//label[text()='Бесплатные']/parent::div[@class='checkbox checkbox-primary']//input")
    private WebElement filterFree;

    @FindBy(xpath = "//div[@class='course-filter affix-top']//label[text()='Тестирование']/parent::div[@class='checkbox checkbox-primary']//input")
    private WebElement filterTest;

    @FindBy(xpath = "//*[@class=\"gb-course-card__title-wrapper\"]//span[text()='Тестирование ПО. Уровень 1']")
    private WebElement firstCourse;

    @FindBy(xpath = "//*[@class=\"gb-course-card__title-wrapper\"]//span[text()='Тестирование ПО. Уровень 2']")
    private WebElement secondCourse;

    public CoursePage(WebDriver driver) {
        initElements(driver, this);
    }

    @Step("Найти дополнительное меню")
    public WebElement getSubmenuCourse() {
        return submenuCourse;
    }

    @Step("Найти чекбокс \"Бесплатные\"")
    public WebElement getFilterFree() {
        return filterFree;
    }

    @Step("Найти чекбокс \"Тестирование\"")
    public WebElement getFilterTest() {
        return filterTest;
    }

    @Step("Найти курс \"Тестирование ПО. Уровень 1\"")
    public WebElement getFirstCourse() {
        return firstCourse;
    }

    @Step("Найти курс \"Тестирование ПО. Уровень 2\"")
    public WebElement getSecondCourse() {
        return secondCourse;
    }
}
