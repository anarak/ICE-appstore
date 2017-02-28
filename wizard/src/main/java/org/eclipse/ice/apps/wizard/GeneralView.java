package org.eclipse.ice.apps.wizard;

import com.vaadin.navigator.View;

import org.eclipse.ice.apps.wizard.MyUI.MyUIServlet;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

public class GeneralView extends SpackApps implements View {
	private Navigator navigator;
	public GeneralView() {
		//setSizeFull();	
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		navigator = getUI().getNavigator();
		btnAdvanced.addClickListener( e -> {
			navigator.navigateTo("main");
		});
	}

}
