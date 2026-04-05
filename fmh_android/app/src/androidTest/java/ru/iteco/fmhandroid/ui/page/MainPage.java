package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public ViewInteraction tradeMark = onView(withId(R.id.trademark_image_view));
    public ViewInteraction titleNews = onView(withText("News"));
    public ViewInteraction accountButton = onView(withId(R.id.authorization_image_button));
    public ViewInteraction logOutButton = onView(allOf(withId(android.R.id.title), withText("Log out")));
    public ViewInteraction quotesButton = onView(withId(R.id.our_mission_image_button));
    public ViewInteraction menuButton = onView(withId(R.id.main_menu_image_button));
    public ViewInteraction mainPageButton = onView(allOf(withId(android.R.id.title), withText("Main")));
    public ViewInteraction newsPageButton = onView(allOf(withId(android.R.id.title), withText("News")));
    public ViewInteraction aboutOfApp = onView(allOf(withId(android.R.id.title), withText("About")));

}
