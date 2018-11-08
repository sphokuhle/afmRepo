package za.ac.afm.dto;

import lombok.Data;

@Data
public class MembershipCertificateDto {
	private Long id;
	private String status;
	
	public MembershipCertificateDto() {}
	
	public MembershipCertificateDto(Long id, String status) {
		this.id = id;
		this.status = status;
	}
	
}