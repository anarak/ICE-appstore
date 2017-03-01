package org.eclipse.ice.apps.wizard;

import com.vaadin.navigator.View;

import org.eclipse.ice.apps.wizard.MyUI.MyUIServlet;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.declarative.Design;

public class GeneralView extends SpackApps implements View {
	private Navigator navigator;
	final EnvironmentDesign env = new EnvironmentDesign();
	
	final FolderEnvironment folderEnv = new FolderEnvironment();
	final DockerEnvironment dockerEnv = new DockerEnvironment();
	//final DockerDesign envConfig = new DockerDesign();
	Window repoURL = new Window();
	
	public GeneralView() {
		//setSizeFull();	
		btnAdvanced.setIcon(FontAwesome.CARET_RIGHT);
		btnAdvanced.addClickListener( e -> {
			if (btnAdvanced.getIcon().equals(FontAwesome.CARET_RIGHT)) {
				System.out.println("dosn");
				vlayoutEnvironment.addComponent(env);
				btnAdvanced.setIcon(FontAwesome.CARET_DOWN);
			}
			else if (btnAdvanced.getIcon().equals(FontAwesome.CARET_DOWN)) {
				vlayoutEnvironment.removeComponent(env);
				btnAdvanced.setIcon(FontAwesome.CARET_RIGHT);
			}
		});
		env.optionGroupInstallType.select("Docker container");
		env.envVerticalLayout.addComponent(dockerEnv);
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		navigator = getUI().getNavigator();
		
		env.optionGroupInstallType.addValueChangeListener( e -> {
			if (env.optionGroupInstallType.getValue().equals("Folder")) {
				if (dockerEnv.isVisible()) {
					env.envVerticalLayout.addComponent(folderEnv);
					env.envVerticalLayout.removeComponent(dockerEnv);
				}
				
			}
			if (env.optionGroupInstallType.getValue().equals("Docker container")) {
				if (folderEnv.isVisible() || !dockerEnv.isVisible()) {
					env.envVerticalLayout.addComponent(dockerEnv);
					env.envVerticalLayout.removeComponent(folderEnv);					
				}
			}
			
			//System.out.println(optionGroupInstallType.getValue());
		});
		
		navigator = getUI().getNavigator();
//        env.btnEnvBack.addClickListener( e -> {
//        	navigator.navigateTo("");
//       	});             
	}

}
