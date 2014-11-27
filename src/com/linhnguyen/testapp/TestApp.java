package com.linhnguyen.testapp;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class TestApp extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException {
		CheckNotification.openNotificationPanel();
		CheckNotification
				.checkNotificationFileUploaded(this,
						"Sta 002 shared file 1Anh Muon Em Song Sao - Bao Anh.fcs with you");
		// 1Anh Muon Em Song Sao - Bao Anh.fcs
		FSAtutoStringFileUtils.checkFileInAllFile(this,
				"1Anh Muon Em Song Sao - Bao Anh.fcs");
	}

}
