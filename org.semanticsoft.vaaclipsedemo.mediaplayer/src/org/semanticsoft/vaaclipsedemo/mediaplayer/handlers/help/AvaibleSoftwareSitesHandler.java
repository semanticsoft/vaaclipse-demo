package org.semanticsoft.vaaclipsedemo.mediaplayer.handlers.help;

import org.eclipse.e4.core.di.annotations.Execute;
import org.semanticsoft.vaaclipse.p2.sites.ui.ISitesView;

import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

public class AvaibleSoftwareSitesHandler {
	@Execute
	public void execute(ISitesView sitesView, UI ui) {
		// TODO Your code goes here

		Window window = new Window("Install new Software");

		window.setContent((Component) sitesView.getUIComponent());
		window.center();

		ui.addWindow(window);
	}

}