/**
 * 
 */
package org.semanticsoft.vaaclipsedemo.cassandra.pref.api;

import org.osgi.service.prefs.Preferences;

/**
 * @author rushan
 *
 */
public interface ServiceWithPreferences {
	Preferences getSystemPreferences();
	Preferences getUserPrefrences(String user);	
}
