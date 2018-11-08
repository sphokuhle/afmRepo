package za.ac.afm.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import za.ac.afm.dto.LookUpsDto;
import za.ac.afm.dto.UserDto;
import za.ac.afm.entity.BaptismStatus;
import za.ac.afm.entity.MembershipCertificate;
import za.ac.afm.entity.User;
import za.ac.afm.model.LookUpsModel;
import za.ac.afm.util.ResponseBuilder;

/**
 * @author S'phokuhle
 *
 */
@Stateless
public class LookUpService {
	@Inject
	ResponseBuilder responseBuilder;

	@Inject
	LookUpsModel lukUpModel;
	public Response getAllBaptismStatuses() {
		
		List<LookUpsDto> mes = new ArrayList<>();
		
		try {
			for(BaptismStatus status: lukUpModel.getStatuses()) {
				mes.add(status.buildResponse(status));
			}
			
		} catch(Exception e) {
		
		}
		System.out.println("Message list: "+ mes);
		
		return responseBuilder.buildResponse(Status.OK, mes);
	}
	
	public Response getAllMemberShipStatuses() {
		
		List<LookUpsDto> mes = new ArrayList<>();
		
		try {
			for(MembershipCertificate certs: lukUpModel.getMemberShipCertificates()) {
				mes.add(certs.buildResponse(certs));
			}
			
		} catch(Exception e) {
		
		}
		System.out.println("Message list: "+ mes);
		
		return responseBuilder.buildResponse(Status.OK, mes);
	}
}
