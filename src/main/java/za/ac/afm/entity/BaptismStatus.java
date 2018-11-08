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
import za.ac.afm.dto.LookUpsDto;

/**
 * @author S'phokuhle
 *
 */
@Entity
@Table(name = "BAPTISM_STATUS", schema = "AFM")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "BaptismStatus.findAll", query = "SELECT b FROM BaptismStatus b"),
        @NamedQuery(name = "BaptismStatus.findByPk", query = "SELECT b FROM BaptismStatus b WHERE b.id = :id")
        })
@Getter
@Setter
public class BaptismStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	private Long id;
	
	@Column(name = "STATUS")
	private String status;
	
	@OneToOne(mappedBy="baptismStatusId")
    @XmlElement
	private User userId;
	
	public BaptismStatus() {}

	public LookUpsDto buildResponse(BaptismStatus status2) {
		// TODO Auto-generated method stub
		return new LookUpsDto(status2.getId(), status2.getStatus());
	}
}
