/**
 * 
 */
package org.semanticsoft.vaaclipsedemo.cassandra.app.preferences;

import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.lunifera.vaaclipse.ui.preferences.model.ListCrud;
import org.lunifera.vaaclipse.ui.preferences.model.ListEditor;
import org.lunifera.vaaclipse.ui.preferences.model.metadata.PreferencesFactory;
import org.semanticsoft.vaaclipsedemo.cassandra.app.emf.EmfHelper;

/**
 * @author rushan
 *
 */
public class ListEditorContribution {

	@Inject
	ListEditor editor;
	
	@Inject
	PreferencesFactory factory;
	
	public static class ListCrudImpl extends EmfHelper.EInterface implements ListCrud {
		@Override
		public String addNewValue(String values) {
			return "This is generated value - " + UUID.randomUUID().toString();
		}
	}
	
	@PostConstruct
	public void init() {
		editor.setListCrud(new ListCrudImpl());
	}
}
