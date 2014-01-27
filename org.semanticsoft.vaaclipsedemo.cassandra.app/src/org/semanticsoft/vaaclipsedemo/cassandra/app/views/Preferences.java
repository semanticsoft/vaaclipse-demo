/**
 * 
 */
package org.semanticsoft.vaaclipsedemo.cassandra.app.views;

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
	
	@PostConstruct
	void init() {
		ServiceWithPreferences sp1 = CassandraActivator.getInstance().getServiceWithPreference1();
		ServiceWithPreferences sp2 = CassandraActivator.getInstance().getServiceWithPreference2();
		
		parent.addComponent(new Label("Preferences of bundle1"));
		addString(sp1.getSystemPreferences(), "Processor", "NoName");
		addString(sp1.getSystemPreferences(), "Memory", "0");
		addString(sp1.getSystemPreferences(), "Motherboard", "NoName");
		
		parent.addComponent(new Label("Preferences of bundle2"));
		addString(sp2.getSystemPreferences(), "Processor", "NoName");
		addString(sp2.getSystemPreferences(), "Memory", "0");
		addString(sp2.getSystemPreferences(), "Motherboard", "NoName");
	}
	
	void addString(org.osgi.service.prefs.Preferences p, String key, String def) {
		parent.addComponent(new Label(String.format("%s: %s", key, p.get(key, def))));
	}
	
}
