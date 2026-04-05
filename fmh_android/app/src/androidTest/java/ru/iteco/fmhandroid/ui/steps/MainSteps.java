package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.DataHelper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.page.MainPage;


public class MainSteps {

    MainPage mainPage = new MainPage();

    public void waitMainPage() {
        Allure.step("Загрузка главной страницы");
        elementWaiting(withId(R.id.all_news_text_view), 5000);
    }

    public void checkMainPage() {
        Allure.step("Проверка элементов главной страницы");
        mainPage.accountButton.check(matches(isDisplayed()));
        mainPage.menuButton.check(matches(isDisplayed()));
    }
    public void logOut() {
        Allure.step("Выход из профиля");
        mainPage.accountButton.perform(click());
        mainPage.logOutButton.perform(click());
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        authorizationSteps.loadAuthorizationPage();
    }
    public void openNewsPage() {
        Allure.step("Открытие раздела \"Новости\"");
        mainPage.menuButton.perform(click());
        mainPage.newsPageButton.perform(click());
    }

    public void openAboutPage() {
        Allure.step("Открытие раздела \"О приложении\"");
        mainPage.menuButton.perform(click());
        mainPage.aboutOfApp.perform(click());
    }

    public void openQuotesPage() {
        Allure.step("Открытие раздела \"Цитаты\"");
        mainPage.quotesButton.perform(click());
    }


    public void openAllNews() {
        Allure.step("Переход ко всем новостям");
        mainPage.newsPageButton.perform(click());
    }
}
