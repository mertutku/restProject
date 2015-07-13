package quiz;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import quiz.controller.AddressBookController;

@ApplicationPath("/addressBook")
public class AdrressBookApplication extends Application {

        @Override
        public Set<Class<?>> getClasses() {
	    Set<Class<?>> controllers = new HashSet<Class<?>>();
	    controllers.add(AddressBookController.class);
	    controllers.add(SecurityInterceptor.class);
	    return controllers;
        }
}
