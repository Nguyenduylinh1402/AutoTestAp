package com.linhnguyen.testapp;

import android.util.Log;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class TestApp extends UiAutomatorTestCase {
	private  final static String FILESTRING_RECEIVE_FILES = "FileString Received Files";
	private  final static String FILESTRING_SENDER_FOLDER = "Sta 002";
	public void testDemo() throws UiObjectNotFoundException {
		CheckNotification.openNotificationPanel();
		CheckNotification
				.checkNotificationFileUploaded(this,
						"Sta 002 shared file 1Anh Muon Em Song Sao - Bao Anh.fcs with you");
		//Đoạn này sử dụng lại checkFileInAllFile
		findReceiveFolder(this, FILESTRING_RECEIVE_FILES);
		
		findReceiveFolder(this, FILESTRING_SENDER_FOLDER);
		// 1Anh Muon Em Song Sao - Bao Anh.fcs
		
		FSAtutoStringFileUtils.checkFileInAllFile(this,
				"1Anh Muon Em Song Sao - Bao Anh.fcs");
	}
	
	public static void findReceiveFolder(final UiAutomatorTestCase test,
			final String fileName) {

		UiScrollable scrollableAllFile = new UiScrollable(new UiSelector()
				.className("android.widget.ListView").scrollable(true));

		UiSelector fileSelector;
		fileSelector = new UiSelector().className(android.widget.TextView.class
				.getName());
		UiObject fileCatch;

		for (int i = 0; i < 10; i++) {

			try {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				fileCatch = scrollableAllFile.getChildByText(fileSelector,
						fileName, true);

				if (fileCatch != null) {
					Log.d(FSAtutoStringFileUtils.class.getName(), "File: "
							+ fileName + " Here");
					fileCatch.clickAndWaitForNewWindow();
					break;
				}
			} catch (UiObjectNotFoundException e) {
				System.out.println("Did not find match for "
						+ e.getLocalizedMessage());
				// test.getUiDevice().pressBack();
			}

		}

	}

}
