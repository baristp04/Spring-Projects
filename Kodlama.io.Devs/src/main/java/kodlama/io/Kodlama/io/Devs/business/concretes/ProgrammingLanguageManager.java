package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.language.CreateLanguagesRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.language.UpdateLanguagesRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.language.GetAllLanguageRespond;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageDao programmingLanguageDao;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
		this.programmingLanguageDao = programmingLanguageDao;
	}

	public void add(CreateLanguagesRequest createLanguageRequest,String name) throws Exception {

		if (createLanguageRequest.getName().isBlank()) {
			throw new Exception("Names cannot be blank!");
		}

		for (ProgrammingLanguage language : programmingLanguageDao.findAll()) {
			if (language.getName().equals(createLanguageRequest.getName())) {
				throw new Exception("Names cannot be equal!");
			}
		}

		ProgrammingLanguage language = new ProgrammingLanguage();
		language.setName(createLanguageRequest.getName());
		this.programmingLanguageDao.save(language);

	}

	@Override
	public ProgrammingLanguage getById(int id) {

		return programmingLanguageDao.findById(id-1).get();

	}

	@Override
	public void update(UpdateLanguagesRequest updateLanguageRequest,int id,String name) throws Exception {
        
		if (updateLanguageRequest.getName().isBlank()) {
			throw new Exception("Names cannot be blank!");
		}

		for (ProgrammingLanguage language : programmingLanguageDao.findAll()) {
			if (language.getName().equals(updateLanguageRequest.getName())) {
				throw new Exception("Names cannot be equal!");
			}
		}
		
		ProgrammingLanguage language = programmingLanguageDao.findById(id).get();
		language.setName(updateLanguageRequest.getName());
		programmingLanguageDao.save(language);

	}

	@Override
	public void delete(int id) {
		
		programmingLanguageDao.deleteById(id-1);

	}

	@Override
	public List <GetAllLanguageRespond> getAll() {

		List<ProgrammingLanguage> languages = programmingLanguageDao.findAll();
		List<GetAllLanguageRespond> responses = new ArrayList<>();
		
		for(ProgrammingLanguage language: languages) {
			
			GetAllLanguageRespond respondItem = new GetAllLanguageRespond();
			respondItem.setId(language.getId());
			respondItem.setName(language.getName());
			responses.add(respondItem);
			
		}
		
		return responses;

	}

}
