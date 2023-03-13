package kodlama.io.Kodlama.io.Devs.business.requests.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFrameworksRequest {

	private int id;
	private String name;
	private int languageId;
	
}
