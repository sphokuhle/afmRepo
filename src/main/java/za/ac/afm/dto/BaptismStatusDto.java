package za.ac.afm.dto;
import lombok.Data;

@Data
public class BaptismStatusDto {
	
	private Long id;
	private String status;
	
	public BaptismStatusDto() {
		
	}
	
	public BaptismStatusDto(Long id, String status) {
		this.id = id;
		this.status = status;
	}
	
}
