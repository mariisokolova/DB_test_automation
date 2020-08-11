import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import base.BaseTest;
import page.HomePage;
import page.SearchPage;

import static org.hamcrest.Matchers.*;

@Execution(ExecutionMode.CONCURRENT)
@Feature("Поиск")
@Story("Поиск по ключу Java")
@DisplayName("Поиск")
public class SearchTest extends BaseTest {

    @BeforeEach
    public void beforeEach() {
        driver.get("https://geekbrains.ru/events");
    }

    @Test
    public void checkSearch() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage.getHeaderMenu().getSearchIcon().click();
        homePage.getHeaderMenu().getSearchField().sendKeys("java");

        wait15second.until(ExpectedConditions.textToBePresentInElement(
                searchPage.getProfessionHeader(), "Профессии"));

//      Проверка - Профессий не менее чем 2
        int professionNumber = Integer.parseInt(searchPage.getProfessionCounter().getText());
        MatcherAssert.assertThat(professionNumber, greaterThanOrEqualTo(2));
        System.out.println("Число профессий: " + professionNumber);

//      Проверка - Курсов более 15
        int courseNumber = Integer.parseInt(searchPage.getCourseCounter().getText());
        MatcherAssert.assertThat(courseNumber, greaterThan(15));
        System.out.println("Число курсов: " + courseNumber);

//      Проверка - Вебинаров больше чем 180, но меньше 300
//      .getText() в данном и последующих случаях он возвращает пустую строку.
//      Поэтому в качестве альтернативы используется .getAttribute("innerText")
        int webinarNumber = Integer.parseInt(searchPage.getWebinarCounter().getAttribute("innerText"));
        MatcherAssert.assertThat(webinarNumber, greaterThan(180));
        MatcherAssert.assertThat(webinarNumber, lessThan(300));
        System.out.println("Число вебинаров: " + webinarNumber);

//      Проверка - В вебинарах отображается первым “Java Junior. Что нужно знать для успешного собеседования?”
        String firstWebinarTitle = searchPage.getFirstWebinar().getAttribute("innerText");
        MatcherAssert.assertThat(firstWebinarTitle, equalToIgnoringCase("Java Junior. Что нужно знать для успешного собеседования?"));

//      Проверка - Блогов более 300
        int blogNumber = Integer.parseInt(searchPage.getBlogCounter().getAttribute("innerText"));
        MatcherAssert.assertThat(blogNumber, greaterThan(300));
        System.out.println("Число блогов: " + blogNumber);

//      Проверка - Форумов не 350
        int forumNumber = Integer.parseInt(searchPage.getForumCounter().getAttribute("innerText"));
        MatcherAssert.assertThat(forumNumber, is(not(equalTo(350))));
        System.out.println("Число форумов: " + forumNumber);

//      Проверка - Тестов не 0
        int testNumber = Integer.parseInt(searchPage.getTestCounter().getAttribute("innerText"));
        MatcherAssert.assertThat(testNumber, is(not(equalTo(0))));
        System.out.println("Число тестов: " + testNumber);

//      Проверка - В Проектах и компаниях отображается GeekBrains
        WebElement projectCampaignGB = searchPage.getProjectCampaignHeader();
        MatcherAssert.assertThat(projectCampaignGB, notNullValue());

        System.out.println("Тест завершен.");
    }
}