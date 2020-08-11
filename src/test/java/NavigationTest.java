import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.HomePage;

import java.util.stream.Stream;

@Execution(ExecutionMode.CONCURRENT)
@Feature("Навигация")
@Story("Проверка основного меню")
@DisplayName("Навигация")
public class NavigationTest extends base.BaseTest {

    @BeforeEach
    public void beforeEach() {
        driver.get("https://geekbrains.ru/events");
    }

    @AfterEach
    void tearDown() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        wait15second.until(ExpectedConditions.visibilityOf(
                homePage.getHeaderMenu().getHeaderExist()));
        wait15second.until(ExpectedConditions.visibilityOf(
                homePage.getFooterMenu().getFooterExist()));
    }

    @DisplayName("Блог")
    @Test
    public void posts() {
        String namePage="Блог";
        HomePage homePage = new HomePage(driver);

        homePage.getNavMenu().getButton(namePage).click();
        homePage.getButtonClosePopUp1().click();
        homePage.getButtonClosePopUp2().click();

        homePage.checkNamePage(namePage);
    }

    @DisplayName("Нажатие на элемент навигации")
    @ParameterizedTest
    @MethodSource("dataProvider")
    public void courses(String namePage) {
        HomePage homePage = new HomePage(driver);
        homePage.getNavMenu().getButton(namePage).click();
        homePage.checkNamePage(namePage);
    }

    public static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("Форум"),
                Arguments.of("Вебинары"),
                Arguments.of("Тесты"),
                Arguments.of("Карьера"),
                Arguments.of("Курсы")
        );
    }

}
