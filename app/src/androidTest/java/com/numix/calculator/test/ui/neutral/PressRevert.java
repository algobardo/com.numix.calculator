package com.numix.calculator.test.ui.neutral;

import android.support.test.espresso.NeutralComponent;

import com.numix.calculator.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class PressRevert extends NeutralComponent {

	public PressRevert() {
	}

	public void execute() {
		onView(withId(R.id.digit2)).perform(click());
		onView(withId(R.id.delete)).perform(click());
	}

	public boolean canExecute() {
		return true;
	}
}
