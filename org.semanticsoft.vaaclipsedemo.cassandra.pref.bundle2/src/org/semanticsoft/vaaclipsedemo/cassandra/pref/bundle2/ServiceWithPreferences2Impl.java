/**
 * 
 */
package org.semanticsoft.vaaclipsedemo.cassandra.pref.bundle2;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.prefs.Preferences;
import org.osgi.service.prefs.PreferencesService;
import org.semanticsoft.vaaclipsedemo.cassandra.pref.api.ServiceWithPreferences;

/**
 * @author rushan
 *
 */
@Component(property = {"(provider=bundle2)"}, service = ServiceWithPreferences.class)
public class ServiceWithPreferences2Impl implements ServiceWithPreferences {

	private PreferencesService osgiPreferencesService;

	@Reference(service = PreferencesService.class)
	public void bindPrefrencesService(PreferencesService osgiPreferencesService) {
		
		this.osgiPreferencesService = osgiPreferencesService;
		
	}
	
	@Activate
	public void activate() {
		
	}

	@Override
	public Preferences getSystemPreferences() {
		return osgiPreferencesService.getSystemPreferences();
	}

	@Override
	public Preferences getUserPrefrences(String user) {
		return osgiPreferencesService.getUserPreferences(user);
	}
	
}
