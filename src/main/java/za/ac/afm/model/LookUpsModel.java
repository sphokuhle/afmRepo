package za.ac.afm.model;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import za.ac.afm.entity.BaptismStatus;
import za.ac.afm.entity.MembershipCategory;
import za.ac.afm.entity.MembershipCertificate;
import za.ac.afm.entity.User;

/**
 * @author S'phokuhle
 *
 */
@Stateless
public class LookUpsModel {
	@PersistenceContext
    EntityManager em;
	public List<BaptismStatus> getStatuses() {
		try {
            TypedQuery<BaptismStatus> query =
                    em.createNamedQuery("BaptismStatus.findAll", BaptismStatus.class);
            return query.getResultList();
    	} catch(Exception e) {
    		// TODO
    		System.out.println("Error in getStatuses(): " + e);
    	}
    	return Collections.emptyList();
	}
	
	public List<MembershipCertificate> getMemberShipCertificates() {
		try {
            TypedQuery<MembershipCertificate> query =
                    em.createNamedQuery("MembershipCertificate.findAll", MembershipCertificate.class);
            return query.getResultList();
    	} catch(Exception e) {
    		// TODO
    		System.out.println("Error in getMemberShipCertificates(): " + e);
    	}
    	return Collections.emptyList();
	}
	
	//"MembershipCategory.findAll"
	public List<MembershipCategory> getMemberShipCategories() {
		try {
            TypedQuery<MembershipCategory> query =
                    em.createNamedQuery("MembershipCategory.findAll", MembershipCategory.class);
            return query.getResultList();
    	} catch(Exception e) {
    		// TODO
    		System.out.println("Error in getMemberShipCategories(): " + e);
    	}
    	return Collections.emptyList();
	}
	
	
}
