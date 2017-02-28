package org.eclipse.ice.apps.wizard;

import java.util.Iterator;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	Navigator navigator;
	protected static final String MAINVIEW = "main";

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        //final VerticalLayout layout = new VerticalLayout();
    	
        /*final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        layout.addComponents(name, button);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);*/
    	
    	final GeneralView gView = new GeneralView();
    	
		for (int i=0; i<10; i++) {
			final Package pkg = new Package();
			gView.packageList.addComponent(pkg);
			pkg.chkBoxPackages.addValueChangeListener( e -> {
				if(pkg.chkBoxPackages.getValue() == true) {
					gView.btnInstall.setEnabled(true);
					System.out.println(pkg.chkBoxPackages.getValue());
				}
				if(pkg.chkBoxPackages.getValue() == false) {
					gView.btnInstall.setEnabled(false);
				}
			});
		}
		
//		Iterator<Component> iterate = gView.packageList.iterator();
//		while (iterate.hasNext()) {
//			Component c = iterate.next();
//			c.addListener( e -> {
//			});
//			System.out.println();
//		}
    	
    	getPage().setTitle("Main page");
    	
    	navigator = new Navigator(this, this);
   	
    	navigator.addView("", gView);
    	navigator.addView("main", new MainView());
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
