package org.semanticsoft.vaaclipsedemo.mediaplayer.handlers.help;

import org.eclipse.e4.core.di.annotations.Execute;
import org.semanticsoft.vaaclipse.p2.uninstall.ui.IUninstallView;

import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

public class UninstallSoftwareHandler {
	@Execute
	public void execute(UI ui, IUninstallView uninstallView) {
		// TODO Your code goes here

		Window window1 = new Window("Install new Software");
		window1.setContent((Component) uninstallView.getUIComponent());
		window1.center();
		ui.addWindow(window1);
	}

}