/**
 * 
 */
package org.semanticsoft.vaaclipsedemo.cassandra.app.views;

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
public class Preferences {

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
		
		vl.addComponent(new Label("Bundle1 preferences"));
		addString(system1, "b1.settings1", "-");
		addString(system1, "b1.settings2", "-");
		addString(system1, "b1.settings3", "-");
		
		vl.addComponent(new Label("Bundle1 subpreferences1"));
		addString(system1.node("subsystem1"), "b1.subsettings11", "-");
		addString(system1.node("subsystem1"), "b1.subsettings12", "-");
		
		vl.addComponent(new Label("Bundle1 subpreferences2"));
		addString(system1.node("subsystem2"), "b1.subsettings21", "-");
		addString(system1.node("subsystem2"), "b1.subsettings22", "-");
		
		vl.addComponent(new Label("Bundle1 subpreferences3"));
		addString(system1.node("subsystem3"), "b1.subsettings31", "-");
		addString(system1.node("subsystem3"), "b1.subsettings32", "-");
		
		vl.addComponent(new Label("Bundle2 preferences"));
		addString(system2, "b2.settings1", "-");
		addString(system2, "b2.settings2", "-");
		addString(system2, "b2.settings3", "-");
		
		vl.addComponent(new Label("Bundle2 subpreferences1"));
		addString(system2.node("b2.subsystem1"), "b1.subsettings11", "-");
		addString(system2.node("b2.subsystem1"), "b1.subsettings12", "-");
		
		vl.addComponent(new Label("Bundle1 subpreferences2"));
		addString(system2.node("b2.subsystem2"), "b1.subsettings21", "-");
		addString(system2.node("b2.subsystem2"), "b1.subsettings22", "-");
		
		vl.addComponent(new Label("Bundle1 subpreferences3"));
		addString(system2.node("b2.subsystem3"), "b2.subsettings31", "-");
		addString(system2.node("b2.subsystem3"), "b2.subsettings32", "-");
	}

	void addString(org.osgi.service.prefs.Preferences p, String key, String def) {
		vl.addComponent(new Label(String.format("%s: %s", key, p.get(key, def))));
	}
	
}
