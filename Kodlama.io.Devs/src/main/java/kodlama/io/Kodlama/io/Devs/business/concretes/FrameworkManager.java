package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.FrameworkService;
import kodlama.io.Kodlama.io.Devs.business.requests.framework.CreateFrameworksRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.framework.UpdateFrameworksRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.framework.GetAllFrameworkRespond;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.FrameworkDao;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Framework;

@Service
public class FrameworkManager implements FrameworkService {

	private FrameworkDao frameworkDao;
	private ProgrammingLanguageDao programmingLanguageDao;

	@Autowired
	public FrameworkManager(FrameworkDao frameworkDao, ProgrammingLanguageDao programmingLanguageDao) {
		super();
		this.frameworkDao = frameworkDao;
		this.programmingLanguageDao = programmingLanguageDao;
	}

	@Override
	public void add(CreateFrameworksRequest createFrameworkRequest, String name) {

		Framework framework = new Framework();
		framework.setName(createFrameworkRequest.getName());
		framework.setLanguage(programmingLanguageDao.findById(createFrameworkRequest.getLanguageId()).get());
		frameworkDao.save(framework);

	}

	@Override
	public List<GetAllFrameworkRespond> getAll() {

		List<Framework> frameworks = frameworkDao.findAll();
		List<GetAllFrameworkRespond> responses = new ArrayList<>();

		for (Framework framework : frameworks) {
			GetAllFrameworkRespond respondItem = new GetAllFrameworkRespond();
			respondItem.setName(framework.getName());
			respondItem.setId(framework.getId());
			respondItem.setLanguage(framework.getLanguage());
			responses.add(respondItem);
		}

		return responses;

	}

	@Override
	public void update(UpdateFrameworksRequest updateFrameworkRequest, int id, String name) {
		Framework framework = new Framework();
		framework.setName(name);
		framework.setLanguage(programmingLanguageDao.findById(updateFrameworkRequest.getLanguageId()).get());
		frameworkDao.save(framework);

	}

	@Override
	public void delete(int id) {
		frameworkDao.deleteById(id);

	}

	@Override
	public Framework getById(int id) {
		return frameworkDao.findById(id).get();

	}

}
