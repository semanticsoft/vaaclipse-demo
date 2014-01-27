/**
 * 
 */
package org.semanticsoft.vaaclipsedemo.cassandra.app.processor;

import e4modelextension.VaaclipseApplication;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.core.di.annotations.Execute;

/**
 * @author rushan
 *
 */
public class PreferencesProcessor {

	@Execute
	public void setupPreferences(VaaclipseApplication app) {
		VaaclipseApplication vaaclipseApp = (VaaclipseApplication) app;
		System.out.println(vaaclipseApp.getPreferencesCategories().get(0).getName());
	}

}
