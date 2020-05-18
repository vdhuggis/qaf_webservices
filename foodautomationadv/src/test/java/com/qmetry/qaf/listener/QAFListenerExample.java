package com.qmetry.qaf.listener;

import com.qmetry.qaf.automation.ui.webdriver.CommandTracker;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElementCommandAdapter;
import org.apache.commons.logging.*;

public class QAFListenerExample extends QAFWebElementCommandAdapter {
	Log logger = LogFactory.getLog(getClass());
	@Override
	public void beforeCommand(QAFExtendedWebElement element, CommandTracker commandTracker) {
		System.out.println("-------------------- " +commandTracker.getCommand());
		// TODO Auto-generated method stub

	}

}
