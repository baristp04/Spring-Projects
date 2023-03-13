package kodlama.io.Kodlama.io.Devs.business.requests.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateFrameworksRequest {
	
	private String name;
	private int languageId;

}
