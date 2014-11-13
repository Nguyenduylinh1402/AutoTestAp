package com.linhnguyen.testapp;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class TestApp extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException {
		// Unable to locate tools.jar. Expected to find it in C:\Program
		// Files\Java\jre1.8.0_25\lib\tools.jar
		// C:\Program Files\Java\jdk1.7.0_21
		// C:\Program Files (x86)\Java\jdk1.8.0_25\

		// Simulate a short press on the HOME button.
		getUiDevice().pressHome();

		// We’re now in the home screen. Next, we want to simulate
		// a user bringing up the All Apps screen.
		// If you use the uiautomatorviewer tool to capture a snapshot
		// of the Home screen, notice that the All Apps button’s
		// content-description property has the value “Apps”. We can
		// use this property to create a UiSelector to find the button.
		UiObject allAppsButton = new UiObject(
				new UiSelector().description("Apps"));

		// Simulate a click to bring up the All Apps screen.
		allAppsButton.clickAndWaitForNewWindow();

		// In the All Apps screen, the Settings app is located in
		// the Apps tab. To simulate the user bringing up the Apps tab,
		// we create a UiSelector to find a tab with the text
		// label “Apps”.
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));

		// Simulate a click to enter the Apps tab.
		appsTab.click();

		// Next, in the apps tabs, we can simulate a user swiping until
		// they come to the Settings app icon. Since the container view
		// is scrollable, we can use a UiScrollable object.
		UiScrollable appViews = new UiScrollable(
				new UiSelector().scrollable(true));

		// Set the swiping mode to horizontal (the default is vertical)
		appViews.setAsHorizontalList();

		// Create a UiSelector to find the Settings app and simulate
		// a user click to launch the app.
		UiObject settingsApp = appViews.getChildByText(new UiSelector()
				.className(android.widget.TextView.class.getName()),
				"FileString");
		// -------------//
		settingsApp.clickAndWaitForNewWindow();

		// Validate that the package name is the expected one
		UiObject settingsValidation = new UiObject(
				new UiSelector().packageName("com.android.settings"));
		assertTrue("Unable to detect Settings", settingsValidation.exists());
		//-----------------------------------------------------------------//
		
		// now the Calculator app is open
		// so we can test the press of button "7" using the ID
		// "com.android.calculator2:id/digit7"
		// we found by using uiautomatorviewer

		UiObject seven = new UiObject(
				new UiSelector()
						.resourceId("com.android.calculator2:id/digit7"));
		seven.click();

		// now we test the press of button "+"
		UiObject plus = new UiObject(
				new UiSelector().resourceId("com.android.calculator2:id/plus"));
		plus.click();

		// and then the press of button "1"
		UiObject one = new UiObject(
				new UiSelector()
						.resourceId("com.android.calculator2:id/digit1"));
		one.click();

		// we test the press of button "="
		UiObject result = new UiObject(
				new UiSelector().resourceId("com.android.calculator2:id/equal"));
		result.click();

		// and finally we test the press of "Back" button
		getUiDevice().pressBack();

	}

}
