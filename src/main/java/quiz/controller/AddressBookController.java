package quiz.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import quiz.model.AddressBookItem;
import quiz.service.AddressBookService;

@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
public class AddressBookController {

        private static final AddressBookService SERVICE = new AddressBookService();

        @GET
        @Path("/list")
        public List<AddressBookItem> list() {
	    return SERVICE.list();
        }

        @GET
        @Path("/add")
        public void add(@QueryParam("name") String name, @QueryParam("address") String address) {
	    SERVICE.add(name, address);
        }

        @GET
        @Path("/delete")
        public boolean deleteByName(@QueryParam("name") String name) {
	    return SERVICE.delete(name);
        }

        @GET
        @Path("/update")
        public boolean updateByName(@QueryParam("name") String name, @QueryParam("address") String address) {
	    return SERVICE.update(name, address);
        }

}