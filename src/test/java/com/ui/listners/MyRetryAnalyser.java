package com.ui.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyser implements IRetryAnalyzer{
	
	private int COUNT=0;
	private int MAX_CHANCES=2;

	@Override
	public boolean retry(ITestResult result) {
		if(COUNT<MAX_CHANCES) {
			COUNT++;
			return true;
		}
		return false;
	}

}
