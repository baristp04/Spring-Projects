package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.framework.*;
import kodlama.io.Kodlama.io.Devs.business.responses.framework.GetAllFrameworkRespond;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Framework;

public interface FrameworkService {
	
	void add(CreateFrameworksRequest createFrameworkRequest, String name);
	List<GetAllFrameworkRespond> getAll();
	void update(UpdateFrameworksRequest updateFrameworkRequest, int id, String name);
	void delete(int id);
	Framework getById(int id);

}
