package org.semanticsoft.vaaclipsedemo.mediaplayer.handlers.help;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.semanticsoft.vaaclipse.p2.install.ui.IBasicUI;
import org.semanticsoft.vaaclipse.p2.install.ui.IContainerP2Views;
import org.semanticsoft.vaaclipse.p2.install.ui.ILoadExplorRepoistory;
import org.semanticsoft.vaaclipse.p2.iservice.IInstallNewSoftwareService;
import org.semanticsoft.vaaclipse.p2.uninstall.ui.IUninstallView;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TreeTable;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class InstallNewSoftwareHandler {
	@Inject
	IProvisioningAgent provisioningAgent;

	@Execute
	public void execute(UI ui, IContainerP2Views basicUI) {

		
		Window window = new Window("Install new Software");

		basicUI.initUI();
		window.setContent((Component) basicUI.getUIComponent());
		window.center();

		ui.addWindow(window);

	}
}