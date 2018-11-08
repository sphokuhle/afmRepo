/**
 * 
 */
package za.ac.afm.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import za.ac.afm.dto.UserDto;
import za.ac.afm.entity.User;
import za.ac.afm.model.UserModel;
import za.ac.afm.rest.ResponseMessage;
import za.ac.afm.util.ResponseBuilder;

/**
 * @author S'phokuhle
 *
 */
@Stateless
public class UserService {
	@Inject
	ResponseBuilder responseBuilder;

	@Inject
	UserModel userModel;
	
	public Response getAllUsers() {
		
		List<UserDto> mes = new ArrayList<>();
		
		try {
			for(User user: userModel.getUsers()) {
				mes.add(user.buildResponse(user));
			}
			
		} catch(Exception e) {
		
		}
		System.out.println("Message list: "+ mes);
		
		return responseBuilder.buildResponse(Status.OK, mes);
	}
	
	
	public Response updateUser(UserDto user) {
		User userToUpdate = null;
		ResponseMessage mes = null;
		try {
			userToUpdate = userModel.updateUser(user);
		} catch(Exception e) {
			System.out.println("Failed to update...");
		}
		
		if (userToUpdate == null) {
			mes = new ResponseMessage(true, "Failed to update User");
			return responseBuilder.buildResponse(Status.OK, mes);
		}
		else {
			mes = new ResponseMessage(true, "User has been updated");
			return responseBuilder.buildResponse(Status.OK, mes);
		}
	}
	
	public Response addUser(UserDto usr) {
		ResponseMessage mes = null;
		User user = null;
		try {
			user = userModel.addUser(usr);
		} catch(Exception e) {
			System.out.println("Failed to add user...");
		}
		
		if (user == null) {
			mes = new ResponseMessage(true, "Failed to add User");
			return responseBuilder.buildResponse(Status.OK, mes);
		}
		else {
			mes = new ResponseMessage(false, "User has been updated");
			System.out.println(mes);
			return responseBuilder.buildResponse(Status.OK, user);
		}
	}
	
	public Response deleteUser(Long userId) {
		ResponseMessage mes = null;
		int result = 0;
		try {
			result = userModel.deleteUser(userId);
		} catch(Exception e) {
			System.out.println("Failed to add user...");
		}
		
		if (result == 0) {
			mes = new ResponseMessage(true, "Failed to delete User");
			return responseBuilder.buildResponse(Status.OK, mes);
		}
		else {
			mes = new ResponseMessage(false, "User has been deleted");
			return responseBuilder.buildResponse(Status.OK, mes);
		}
	}
	
	
}
