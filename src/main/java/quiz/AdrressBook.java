package quiz;

import org.jboss.resteasy.plugins.server.sun.http.SunHttpJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

public class AdrressBook {

        public static void main(String[] args) {
	    SunHttpJaxrsServer server = new SunHttpJaxrsServer();
	    ResteasyDeployment deployment = new ResteasyDeployment();
	    AdrressBookApplication application = new AdrressBookApplication();
	    deployment.setApplication(application);
	    server.setDeployment(deployment);
	    server.setRootResourcePath("addressBook");
	    server.setPort(8080);
	    server.start();
        }
}
