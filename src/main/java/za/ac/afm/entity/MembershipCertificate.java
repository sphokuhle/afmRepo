package za.ac.afm.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import za.ac.afm.dto.LookUpsDto;

/**
 * @author S'phokuhle
 *
 */
@Entity
@Table(name = "MEMBERSHIP_CERTIFICATE", schema = "AFM")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "MembershipCertificate.findAll", query = "SELECT m FROM MembershipCertificate m"),
        @NamedQuery(name = "MembershipCertificate.findByPk", query = "SELECT m FROM MembershipCertificate m WHERE m.id = :id")
        })
@Getter
@Setter
public class MembershipCertificate implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "STATUS")
	private String status;
	
	@OneToOne(mappedBy="memberShipId")
    @XmlElement
	private User userId;
	
	public MembershipCertificate() {}
	
	public LookUpsDto buildResponse(MembershipCertificate memberShipCertificate) {
		return new LookUpsDto(memberShipCertificate.getId(), memberShipCertificate.getStatus());
	}
}
