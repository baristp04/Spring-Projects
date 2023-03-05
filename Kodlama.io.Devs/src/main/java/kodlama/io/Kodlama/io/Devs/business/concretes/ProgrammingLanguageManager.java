package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageDao programmingLanguageDao;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
		this.programmingLanguageDao = programmingLanguageDao;
	}

	public void add(ProgrammingLanguage programmingLanguage,String name) throws Exception {

		if (programmingLanguage.getName().isBlank()) {
			throw new Exception("Names cannot be blank!");
		}

		for (ProgrammingLanguage language : programmingLanguageDao.getAll()) {
			if (language.getName().equals(programmingLanguage.getName())) {
				throw new Exception("Names cannot be equal!");
			}
		}

		programmingLanguageDao.add(programmingLanguage,name);

	}

	@Override
	public ProgrammingLanguage getById(int id) {

		return programmingLanguageDao.getById(id);

	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage,int id,String name) throws Exception {

		if (programmingLanguage.getName().isBlank()) {
			throw new Exception("Names cannot be blank!");
		}

		for (ProgrammingLanguage language : programmingLanguageDao.getAll()) {
			if (language.getName().equals(programmingLanguage.getName())) {
				throw new Exception("Names cannot be equal!");
			}
		}
		
		programmingLanguageDao.update(programmingLanguage,id,name);

	}

	@Override
	public void delete(int id) {
		
		programmingLanguageDao.delete(id);

	}

	@Override
	public List<ProgrammingLanguage> getAll() {

		return programmingLanguageDao.getAll();

	}

}
