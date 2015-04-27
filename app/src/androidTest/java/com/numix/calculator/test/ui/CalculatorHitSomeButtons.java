package com.numix.calculator.test.ui;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.numix.calculator.Calculator;
import com.numix.calculator.view.CalculatorDisplay;
import com.numix.calculator.R;
import com.numix.calculator.test.SystemAnimations;

import android.support.test.espresso.matcher.BoundedMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.is;

public class CalculatorHitSomeButtons extends ActivityInstrumentationTestCase2<Calculator> {
    public static final String TAG = "CalculatorHitSomeButtons";

    Activity activity;

    private SystemAnimations systemAnimations;

    public CalculatorHitSomeButtons() {
        super(Calculator.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        systemAnimations = new SystemAnimations(getInstrumentation().getContext());
        systemAnimations.disableAll();
        activity = getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        systemAnimations.enableAll();
        super.tearDown();
    }

    public void testCalculatorPlus() throws InterruptedException {
        onView(withId(R.id.digit2)).perform(click());
        onView(withId(R.id.plus)).perform(click());
        onView(withId(R.id.digit2)).perform(click());
        onView(withId(R.id.equal)).perform(click());
        onView(withId(R.id.display)).check(matches(withCalculatorDisplayText(is("4"))));
    }

    public static Matcher<View> withCalculatorDisplayText(final Matcher<String> stringMatcher) {
        return new BoundedMatcher<View, CalculatorDisplay>(CalculatorDisplay.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("with calculator display text: ");
                stringMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(CalculatorDisplay calculatorDisplay) {
                return stringMatcher.matches(calculatorDisplay.getText().toString());
            }
        };
    }
}
