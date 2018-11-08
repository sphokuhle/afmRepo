/**
 * 
 */
package za.ac.afm.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import za.ac.afm.dto.UserDto;
import za.ac.afm.service.LookUpService;
import za.ac.afm.service.UserService;

/**
 * @author S'phokuhle
 *
 */
@Path("/afm/")
@Stateless
public class ResourceLayer {
	@Inject
	UserService userService;
	
	@Inject
	LookUpService lookUpService;
	
	@POST
	@Path("getAllUsers")
	@Produces({"application/json"})
	public Response getAllUsers() {
		return userService.getAllUsers();
	}
	
	@POST
	@Path("updateUser")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response updateUser(UserDto user) {
		return userService.updateUser(user);
	}
	
	@POST
	@Path("addUser")
	@Produces({"application/json"})
	public Response addUser(UserDto user) {
		return userService.addUser(user);
	}
	
	@POST
	@Path("getBaptismStatus")
	@Produces({"application/json"})
	public Response getBaptismStatuses() {
		return lookUpService.getAllBaptismStatuses();
	}
	
	@POST
	@Path("getAllMembershipCertificateStatus")
	@Produces({"application/json"})
	public Response getAllMembershipCertificatesStatus() {
		return lookUpService.getAllMemberShipStatuses();
	}
	
	@DELETE
	@Path("deleteUser/{userId}")
	@Produces({"application/json"})
	public Response deleteUser(@PathParam("userId") Long userId) {
		return userService.deleteUser(userId);
	}

}
