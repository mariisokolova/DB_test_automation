package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class SearchPage {

    @FindBy(css = "[id=\"professions\"] h2")
    private WebElement professionHeader;

    @FindBy(xpath = "//div[@id='professions']//header[@class='search-page-block__header']//span")
    private WebElement professionCounter;

    @FindBy(xpath = "//h2[text()='Курсы']/parent::header[@class='search-page-block__header']//span")
    private WebElement courseCounter;

    @FindBy(xpath = "//h2[text()='Вебинары']/parent::header[@class='search-page-block__header']//span")
    private WebElement webinarCounter;

    @FindBy(xpath = "//h2[text()='Блоги']/parent::header[@class='search-page-block__header']//span")
    private WebElement blogCounter;

    @FindBy(xpath = "//h2[text()='Форум']/parent::header[@class='search-page-block__header']//span")
    private WebElement forumCounter;

    @FindBy(xpath = "//h2[text()='Тесты']/parent::header[@class='search-page-block__header']//span")
    private WebElement testCounter;

    @FindBy(css = "[class=\"event__title h3 search_text\"]")
    private WebElement firstWebinar;

    @FindBy(xpath = "//div[@class='company-items']//h3/a[contains(text(),'GeekBrains')]")
    private WebElement projectCampaignHeader;

    public SearchPage(WebDriver driver) {
        initElements(driver, this);
    }

    @Step("Найти блок \"Профессии\"")
    public WebElement getProfessionHeader() {
        return professionHeader;
    }

    @Step("Найти число \"Профессий\"")
    public WebElement getProfessionCounter() {
        return professionCounter;
    }

    @Step("Найти число \"Курсов\"")
    public WebElement getCourseCounter() {
        return courseCounter;
    }

    @Step("Найти число \"Вебинаров\"")
    public WebElement getWebinarCounter() {
        return webinarCounter;
    }

    @Step("Найти число \"Блогов\"")
    public WebElement getBlogCounter() {
        return blogCounter;
    }

    @Step("Найти число \"Форумов\"")
    public WebElement getForumCounter() {
        return forumCounter;
    }

    @Step("Найти число \"Тестов\"")
    public WebElement getTestCounter() {
        return testCounter;
    }

    @Step("Найти первый вебинар")
    public WebElement getFirstWebinar() {
        return firstWebinar;
    }

    @Step("Найти название кампании")
    public WebElement getProjectCampaignHeader() {
        return projectCampaignHeader;
    }
}
