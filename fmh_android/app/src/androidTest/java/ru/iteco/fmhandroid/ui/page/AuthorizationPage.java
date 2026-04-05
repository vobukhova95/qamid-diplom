package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.data.DataHelper.elementWaiting;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

public class AuthorizationPage {
    private final ViewInteraction title = onView(withText(R.string.authorization));
    private final ViewInteraction loginField = onView(withHint(R.string.login));
    private final ViewInteraction passwordField = onView(withHint(R.string.password));
    private final ViewInteraction loginButton = onView(withId(R.id.enter_button));

    private final String validLogin = DataHelper.AuthData.getValidLogin();
    private final String validPassword = DataHelper.AuthData.getValidPassword();

    public void loadAuthorizationPage() {
        Allure.step("Загрузка страницы авторизации");
        elementWaiting(withId(R.id.enter_button), 4000);
    }

    public void checkAuthorizationPage() {
        Allure.step("Наличие элементов формы авторизации");
        loginField.check(matches(isDisplayed()));
        passwordField.check(matches(isDisplayed()));
    }

    public void authorization(String login, String password) {
        Allure.step("Процесс ввода логина и пароля, нажатие на кнопку \"Войти\"");
        loginField.perform(replaceText(login), closeSoftKeyboard());
        passwordField.perform(replaceText(password), closeSoftKeyboard());
        loginButton.perform(click());
    }
    public void successfulAuthorization() {
        Allure.step("Авторизация под валидными данным");
        authorization(validLogin, validPassword);
        MainSteps mainSteps = new MainSteps();
        mainSteps.waitMainPage();
        mainSteps.checkMainPage();
    }


    public void checkToastMessageText(String text, View decorView) {
        Allure.step("Проверка сообщения по тексту");
        onView(withText(text))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }
}
