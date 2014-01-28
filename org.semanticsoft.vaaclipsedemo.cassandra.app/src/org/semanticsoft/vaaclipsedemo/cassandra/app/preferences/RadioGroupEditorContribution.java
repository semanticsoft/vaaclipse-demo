/**
 * 
 */
package org.semanticsoft.vaaclipsedemo.cassandra.app.preferences;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.lunifera.vaaclipse.ui.preferences.model.Entry;
import org.lunifera.vaaclipse.ui.preferences.model.RadioGroupFieldEditor;
import org.lunifera.vaaclipse.ui.preferences.model.metadata.PreferencesFactory;

/**
 * @author rushan
 *
 */
public class RadioGroupEditorContribution {
	@Inject
	RadioGroupFieldEditor editor;
	
	@Inject
	PreferencesFactory factory;
	
	@PostConstruct
	public void init() {
		addOption("contrib-option-1", "This is contributed option-1");
		addOption("contrib-option-2", "This is contributed option-2");
		addOption("contrib-option-3", "This is contributed option-3");
	}
	
	public void addOption(String key, String value) {
		Entry entry = factory.createEntry();
		entry.setValue(key);
		entry.setName(value);
		editor.getEntries().add(entry);
	}
}
