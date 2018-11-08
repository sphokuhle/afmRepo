package za.ac.afm.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

/**
 * @author S'phokuhle
 *
 */
@Entity
@Table(name = "MEMBERSHIP_CATEGORY", schema = "AFM")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "MembershipCategory.findAll", query = "SELECT mc FROM MembershipCategory mc"),
        @NamedQuery(name = "MembershipCategory.findByPk", query = "SELECT mc FROM MembershipCategory mc WHERE mc.id = :id")
        })
@Getter
@Setter
public class MembershipCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	private Long id;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@OneToOne(mappedBy="memberShipCategoryId")
    @XmlElement
	private User userId;
	
	public MembershipCategory() {
	}
	

}
