/**
 * 
 */
package org.semanticsoft.vaaclipsedemo.cassandra.app.views;

import org.osgi.service.prefs.Preferences;

import javax.annotation.PreDestroy;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.lunifera.vaaclipse.ui.preferences.addon.PreferencesEvents;
import org.eclipse.e4.core.services.events.IEventBroker;
import com.vaadin.ui.Panel;
import org.semanticsoft.vaaclipsedemo.cassandra.pref.api.ServiceWithPreferences;
import org.semanticsoft.vaaclipsedemo.cassandra.app.CassandraActivator;
import com.vaadin.ui.Label;
import javax.annotation.PostConstruct;
import com.vaadin.ui.VerticalLayout;
import javax.inject.Inject;

/**
 * @author rushan
 *
 */
public class PreferencesView {

	@Inject
	VerticalLayout parent;
	private Panel panel;
	VerticalLayout vl;
	private ServiceWithPreferences sp2;
	private ServiceWithPreferences sp1;
	
	@Inject
	IEventBroker b;
	

	EventHandler prefHandler = new EventHandler() {
		@Override
		public void handleEvent(Event arg0) {
			refresh();
		}
	};
	
	@PostConstruct
	void init() {
		
		panel = new Panel();
		panel.setSizeFull();
		parent.addComponent(panel);
		vl = new VerticalLayout();
		panel.setContent(vl);
		
		sp1 = CassandraActivator.getInstance().getServiceWithPreference1();
		sp2 = CassandraActivator.getInstance().getServiceWithPreference2();
		
		refresh();
	}
	
	@PostConstruct
	public void registerHandlers() {
		b.subscribe(PreferencesEvents.PREFERENCES_APPLIED, prefHandler);
		b.subscribe(PreferencesEvents.PREFERENCES_TO_DEFAULTS, prefHandler);
	}
	
	@PreDestroy
	public void unregisterHandlers() {
		b.unsubscribe(prefHandler);
	}
	
	private void refresh() {
		vl.removeAllComponents();
		
		org.osgi.service.prefs.Preferences system1 = sp1.getSystemPreferences();
		org.osgi.service.prefs.Preferences system2 = sp2.getSystemPreferences();
		
		Preferences admin1 = sp1.getUserPrefrences("admin");
		Preferences admin2 = sp2.getUserPrefrences("admin");
		
		
		
		addText("system", 
				new String[] {"generatereport", "savestat", "sysprefix"},
				new Preferences[] {system1, system2, system1}
			);
		
		addText("memory", 
				new String[] {"enablecache", "maxpg", "xmx"},
				new Preferences[] {system1.node("memory"), system2.node("memory"), system1.node("memory")}
			);
		
		addText("performance", 
				new String[] {"threadpool", "options", "cpupolicy"},
				new Preferences[] {system1.node("performance"), system2.node("performance"), system1.node("performance")}
			);
		
		addText("admin", 
				new String[] {"monitor"},
				new Preferences[] {admin1}
			);
	}
	
	void addText(String category, String[] keys, org.osgi.service.prefs.Preferences[] prefs) {
		String str = "";
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			String value = prefs[i].get(key, "no");
			str += String.format("&nbsp;&nbsp;&nbsp;&nbsp;key=%s, value = %s;<br/>", key, value);
		}
		if (str.isEmpty())
			str = "no page";
		
		String text = String.format("Category: %s<br/>%s<br/><br/>", category, str);
		vl.addComponent(new Label(text, Label.CONTENT_XHTML));
	}
	
}
