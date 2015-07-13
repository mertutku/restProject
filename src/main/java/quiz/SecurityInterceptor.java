package quiz;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.util.Base64;

public class SecurityInterceptor implements ContainerRequestFilter {

        @Override
        public void filter(ContainerRequestContext requestContext) throws IOException {
	    if ("GET".equalsIgnoreCase(requestContext.getMethod())) {
		return;
	    }
	    else if ("POST".equalsIgnoreCase(requestContext.getMethod())) {
		String user = "admin";
		String pass = "123";
		String desiredAuthKey = Base64.encodeBytes((user +":"+ pass).getBytes());
		String desiredAuthStr = "Basic " + desiredAuthKey;
		for (String key : requestContext.getHeaders().keySet()) {
		        if ("Authorization".equalsIgnoreCase(key) && requestContext.getHeaders().get(key) != null
				&& requestContext.getHeaders().get(key).contains(desiredAuthStr)) {
			    return;
		        }
		}
		requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("This is not authorized!").build());

	    }
	    else {
		requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("This is not authorized!").build());

	    }
        }
}
