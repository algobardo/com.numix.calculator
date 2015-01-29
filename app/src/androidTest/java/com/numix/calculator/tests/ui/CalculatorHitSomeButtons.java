package com.numix.calculator.test.ui;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.numix.calculator.Calculator;
import com.numix.calculator.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;

public class CalculatorHitSomeButtons extends ActivityInstrumentationTestCase2<Calculator> {
    public static final String TAG = "CalculatorHitSomeButtons";

    Activity activity;

    public CalculatorHitSomeButtons() {
        super(Calculator.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCalculatorPlus() throws InterruptedException {
        onView(withId(R.id.digit2)).perform(click());
        onView(withId(R.id.plus)).perform(click());
        onView(withId(R.id.digit2)).perform(click());
        onView(withId(R.id.equal)).perform(click());
        onView(withId(R.id.display)).check(matches(withText(is("4"))));
    }
}