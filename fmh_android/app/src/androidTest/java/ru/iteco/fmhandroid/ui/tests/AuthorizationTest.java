package ru.iteco.fmhandroid.ui.tests;

import static org.hamcrest.CoreMatchers.not;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.steps.DownloadSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTest {
    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));
    DownloadSteps downloadSteps = new DownloadSteps();
    AuthorizationPage authorizationPage = new AuthorizationPage();

    MainPage mainPage = new MainPage();
    MainSteps mainSteps = new MainSteps();
    private View decorView;

    @Before
    public void setUp() {
        downloadSteps.appDownload();
        try {
            authorizationPage.loadAuthorizationPage();
        } catch (
                Exception e) {
            mainSteps.logOut();
            authorizationPage.loadAuthorizationPage();
        }
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @After
    public void tearDown() {
        try {
            mainSteps.logOut();
        } catch (Exception ignored) {
        }
    }

    /*Тест проверяет процесс авторизации с использованием корректных учетных данных пользователя */
    @Test
    @Feature(value = "Тесты по странице Авторизации")
    @Story("Авторизация в приложении под валидными данными")
    public void shouldAuthorizeAndLoadMainScreenWithValidCredentials() {
        authorizationPage.successfulAuthorization();
    }

    /*Тест проверяет процесс авторизации с невалидными учетными данными  */
    @Test
    @Feature(value = "Тесты по странице Авторизации")
    @Story("Авторизация в приложении под НЕ валидными данными")
    public void shouldRejectLoginWithInvalidCredentialsAndShowErrorMessage() {
        String invalidLogin = DataHelper.AuthData.getInvalidLogin();
        String invalidPassword = DataHelper.AuthData.getInvalidPassword();
        String errorText = "Invalid login or password";
        authorizationPage.authorization(invalidLogin, invalidPassword);
        authorizationPage.checkToastMessageText(errorText, decorView);
        authorizationPage.checkAuthorizationPage();
    }
    /*Тест проверяет попытку входа в систему с пустыми данными */
    @Test
    @Feature(value = "Тесты по странице Авторизации")
    @Story("Авторизация в приложении с пустыми данными")
    public void shouldRejectEmptyLoginCredentialsWithMessage() {
        String emptyLogin = DataHelper.CommonValues.getValueEmpty();
        String emptyPassword = DataHelper.CommonValues.getValueEmpty();
        String errorText = "Login or password cannot be empty";
        authorizationPage.authorization(emptyLogin, emptyPassword);
        authorizationPage.checkToastMessageText(errorText, decorView);
        authorizationPage.checkAuthorizationPage();
    }
    /*Тест проверяет процесс выхода из учетной записи после успешной авторизации*/
    @Test
    @Feature(value = "Тесты по странице Авторизациии")
    @Story("Выход из учётной записи")
    public void shouldLogoffAndReturnToAuthorizationBlock() {
        authorizationPage.successfulAuthorization();
        mainSteps.logOut();
        authorizationPage.checkAuthorizationPage();
    }

}
