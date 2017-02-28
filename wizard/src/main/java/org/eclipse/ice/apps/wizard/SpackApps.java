package org.eclipse.ice.apps.wizard;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class SpackApps extends VerticalLayout {
	protected Label lblHeader;
	protected TextField txtFieldPackageSearch;
	protected Panel pnlPackageList;
	protected VerticalLayout packageList;
	protected Label dummyLabel;
	protected Button btnAdvanced;
	protected Button btnInstall;

	public SpackApps() {
		Design.read(this);
	}
}
