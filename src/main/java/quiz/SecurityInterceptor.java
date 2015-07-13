package quiz;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

public class SecurityInterceptor implements ContainerRequestFilter {

        @Override
        public void filter(ContainerRequestContext requestContext) throws IOException {
	    if ("GET".equalsIgnoreCase(requestContext.getMethod())) {
		return;
	    }
	    else if ("POST".equalsIgnoreCase(requestContext.getMethod())) {
		String user = "ali";
		String pass = "123123";
		String desiredAuthKey = user + pass;
		for (String key : requestContext.getHeaders().keySet()) {
		        if ("authkey".equalsIgnoreCase(key) && requestContext.getHeaders().get(key) != null
				&& requestContext.getHeaders().get(key).contains(desiredAuthKey)) {
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
