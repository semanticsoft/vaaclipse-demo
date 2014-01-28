/**
 * 
 */
package org.semanticsoft.vaaclipsedemo.cassandra.app.ds;

import org.osgi.service.component.annotations.Component;

import org.lunifera.vaaclipse.ui.preferences.model.PreferencesCategory;
import org.lunifera.vaaclipse.ui.preferences.addon.PreferencesAuthorization;

/**
 * @author rushan
 *
 */
@Component(service = PreferencesAuthorization.class)
public class PreferencesAuthServiceImpl implements PreferencesAuthorization {

	String currentUserRole = "admin";
	
	@Override
	public boolean isAllowed(PreferencesCategory category) {
		return currentUserRole.equals(category.getId()) || "developer".equals(category.getId());
	}

	@Override
	public boolean exportAllowed() {
		return true;
	}

	@Override
	public boolean importAllowed() {
		return true;
	}

}
