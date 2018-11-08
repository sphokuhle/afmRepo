package za.ac.afm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import za.ac.afm.dto.UserDto;
import za.ac.afm.entity.BaptismStatus;
import za.ac.afm.entity.MembershipCategory;
import za.ac.afm.entity.MembershipCertificate;
import za.ac.afm.entity.User;

/**
 * @author S'phokuhle
 *
 */
@Stateless
public class UserModel {
	@PersistenceContext
    EntityManager em;

	public List<User> getUsers() {
		try {
            TypedQuery<User> query =
                    em.createNamedQuery("User.findAll", User.class);
            return query.getResultList();
    	} catch(Exception e) {
    		// TODO
    		System.out.println("Error in getUsers(): " + e);
    	}
    	return Collections.emptyList();
	}
	
	public User getUserById(Long id) {
		try {
            TypedQuery<User> query =
                    em.createNamedQuery("User.findByPk", User.class)
                    .setParameter("id", id);
            return query.getSingleResult();
    	} catch(Exception e) {
    		System.out.println("Error in getUserById(): " + e);
    	}
    	return null;
	}
	
	
	public User getUsersByCategoryId(Long id) {
		try {
			List<UserDto> users = new ArrayList<>();
            TypedQuery<User> query =
                    em.createNamedQuery("User.findByPk", User.class)
                    .setParameter("id", id);
            return query.getSingleResult();
    	} catch(Exception e) {
    		System.out.println("Error in getUserById(): " + e);
    	}
    	return null;
	}
	
	public User addUser(UserDto usr)
	{
		
		/*private String firstname;
		private String lastname;
		private String address;
		private String cellNumber;
		private Timestamp dateOfBirth;
		private String email;
		private String occupation;*/
		User user = new User();
		user.setFirstname(usr.getFirstName());
		user.setLastname(usr.getLastName());
		user.setAddress(usr.getAddress());
		user.setCellNumber(usr.getCellNumber());
		user.setDateOfBirth(usr.getDateOfBirth());
		user.setEmail(usr.getEmail());
		user.setOccupation(usr.getOccupation());
		user.setBaptismStatusId(getBaptismStatus(usr.getBaptismId()));
		user.setMemberShipId(getMembershipCertificate(usr.getMembershipId()));
		try {
			em.persist(user);
			em.flush();
			return user;
		} catch (Exception e) {
			System.out.println("Error in addUser(): " + e +"\nClass: " + this.getClass().getCanonicalName());
		}
		return null;	
	}
	
	private BaptismStatus getBaptismStatus(Long bId) {
		try {
            TypedQuery<BaptismStatus> query =
                    em.createNamedQuery("BaptismStatus.findByPk", BaptismStatus.class)
                    .setParameter("id", bId);
            return query.getSingleResult();
    	} catch(Exception e) {
    		// TODO
    		System.out.println("Error in getUsers(): " + e);
    	}
    	return null;
	}
	
	private MembershipCertificate getMembershipCertificate(Long mId) {
		try {
            TypedQuery<MembershipCertificate> query =
                    em.createNamedQuery("MembershipCertificate.findByPk", MembershipCertificate.class)
                    .setParameter("id", mId);
            return query.getSingleResult();
    	} catch(Exception e) {
    		// TODO
    		System.out.println("Error in getMembershipCertificate(): " + e);
    	}
    	return null;
	}
	
	private MembershipCategory getMembershipCategory(Long mId) {
		try {
            TypedQuery<MembershipCategory> query =
                    em.createNamedQuery("MembershipCategory.findByPk", MembershipCategory.class)
                    .setParameter("id", mId);
            return query.getSingleResult();
    	} catch(Exception e) {
    		// TODO
    		System.out.println("Error in getMembershipCertificate(): " + e);
    	}
    	return null;
	}
	
	public User updateUser(UserDto user) {
		
		User usertoUpdate = getUserById(user.getUserId());
		usertoUpdate.setCellNumber(user.getCellNumber());
		usertoUpdate.setEmail(user.getEmail());
		usertoUpdate.setOccupation(user.getOccupation());
		usertoUpdate.setEducationLevel(user.getEducationLevel());
		usertoUpdate.setBaptismStatusId(getBaptismStatus(user.getBaptismId()));
		usertoUpdate.setMemberShipId(getMembershipCertificate(user.getMembershipId()));
		usertoUpdate.setMemberShipCategoryId(getMembershipCategory(user.getCategoryId()));
		em.merge(usertoUpdate);
		return usertoUpdate;
	}
	
	public int deleteUser(Long userId) {
		try {
            TypedQuery<User> query =
                    em.createQuery("DELETE FROM User WHERE id = :id", User.class)
                    .setParameter("id", userId);
            return query.executeUpdate();
    	} catch(Exception e) {
    		// TODO
    		System.out.println("Error in deleteUser(): " + e);
    	}
		return 0;
	}
	
}
