import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import page.AuthorizationPage;
import page.CoursePage;
import page.HomePage;
import io.qameta.allure.*;

@Execution(ExecutionMode.CONCURRENT)
@Feature("Авторизация")
@Story("Авторизации и поиск курсов")
@DisplayName("Авторизация")
public class AuthorizationTest extends BaseTest {

    @BeforeEach
    public void beforeEach() {
        driver.get("https://geekbrains.ru/login");
    }

    @DisplayName("Успешная авторизация и поиск курсов")
    @Test
    public void checkSearch() throws InterruptedException {

        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        HomePage homePage = new HomePage(driver);
        CoursePage coursePage = new CoursePage(driver);

        String login = "hks47018@eoopy.com";
        String password = "hks47018";
        String nameHomePage = "Главная";
        String nameCoursePage = "Курсы";

        new AuthorizationPage(driver).authorization(login,password);

        homePage.checkNamePage(nameHomePage);

        homePage.getNavMenu().getButton(nameCoursePage).click();

        coursePage.getSubmenuCourse().click();

        coursePage.getFilterFree().click();
        coursePage.getFilterTest().click();

        coursePage.getFirstCourse();
        coursePage.getSecondCourse();

    }
}
