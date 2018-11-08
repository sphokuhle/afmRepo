package za.ac.afm.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import za.ac.afm.dto.UserDto;
/**
 * @author S'phokuhle
 *
 */
@Entity
@Table(name = "USER", schema = "AFM")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findByPk", query = "SELECT u FROM User u WHERE u.id = :id"),
        @NamedQuery(name = "User.findByStatusId", query= "SELECT u FROM User u JOIN u.baptismStatusId bapt WHERE bapt.id = :baptismStatusId"),
        @NamedQuery(name = "User.findByMembershipCategoryId", query= "SELECT u FROM User u JOIN u.memberShipCategoryId mc WHERE mc.id = :memberShipCategoryId")
        })
@Getter
@Setter
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FIRST_NAME")
	private String firstname;
	@Column(name = "LAST_NAME")
	private String lastname;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "CELL_NUMBER")
	private String cellNumber;
	@Column(name = "DATE_OF_BIRTH")
	private Timestamp dateOfBirth;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "OCCUPATION")
	private String occupation;
	@Column(name = "EDUCATION_LEVEL")
	private String educationLevel;
	
	@JoinColumn(name = "BAPTISM_STATUS_ID", referencedColumnName = "ID")
	@OneToOne(cascade=CascadeType.PERSIST)
	@XmlElement
	private BaptismStatus baptismStatusId;
	//MEMBERSHIP_CATEGORY_ID
	@JoinColumn(name = "MEMBERSHIP_CERTIFICATE_ID", referencedColumnName = "ID")
	@OneToOne(cascade=CascadeType.PERSIST)
	@XmlElement
	private MembershipCertificate memberShipId;
	
	@JoinColumn(name = "MEMBERSHIP_CATEGORY_ID", referencedColumnName = "ID")
	@OneToOne(cascade=CascadeType.PERSIST)
	@XmlElement
	private MembershipCategory memberShipCategoryId;
	
	public User() {}
	
	public UserDto buildResponse(User user) {
		return new UserDto(user.getId(), user.getFirstname(), user.getLastname(), user.getAddress(), user.getCellNumber(), 
				user.getDateOfBirth(), user.getEmail(), user.getOccupation(), user.getEducationLevel(),
				user.getBaptismStatusId().getId(), user.getMemberShipCategoryId().getId(), user.getMemberShipId().getId(),
				user.getBaptismStatusId().getStatus(), user.getMemberShipId().getStatus(), user.getMemberShipCategoryId().getCategory());
	}
	
	public UserDto toUser(User user) {
		return new UserDto(user.getFirstname(), user.getLastname(), user.getAddress(), user.getCellNumber(), 
				user.getDateOfBirth(), user.getEmail(), user.getOccupation(), user.getEducationLevel());
	}
}
