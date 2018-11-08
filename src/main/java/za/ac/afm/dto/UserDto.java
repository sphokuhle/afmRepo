package za.ac.afm.dto;

import java.sql.Timestamp;

import lombok.Data;
/**
 * @author S'phokuhle
 *
 */
@Data
public class UserDto {
	
	private Long userId;
	private String firstName;
	private String lastName;
	private String address;
	private String cellNumber;
	private Timestamp dateOfBirth;
	private String email;
	private String occupation;
	private String educationLevel;
	private Long membershipId;
	private Long baptismId;
	private Long categoryId;
	private String baptism;
	private String membership;
	private String category;
	
	public UserDto() {}
	
	public UserDto(Long userId, String firstname, String lastname, String address, String cellNumber,
			Timestamp dateOfBirth, String email, String occupation, String educationLevel, Long membershipId,
			Long baptismId, Long categoryId, String baptism, String membership, String category) {
		this.userId = userId;
		this.firstName = firstname;
		this.lastName = lastname;
		this.address = address;
		this.cellNumber = cellNumber;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.occupation = occupation;
		this.educationLevel = educationLevel;
		this.membershipId = membershipId;
		this.baptismId = baptismId;
		this.baptism = baptism;
		this.categoryId = categoryId;
		this.membership = membership;
		this.category = category;
	}
	
	public UserDto(String firstname, String lastname, String address, String cellNumber, Timestamp dateOfBirth,
			String email, String occupation, String educationLevel) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.address = address;
		this.cellNumber = cellNumber;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.occupation = occupation;
		this.educationLevel = educationLevel;
		
	}
	
}
