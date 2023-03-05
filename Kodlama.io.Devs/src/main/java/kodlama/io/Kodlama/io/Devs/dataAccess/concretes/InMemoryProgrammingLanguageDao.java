package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.*;
import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageDao implements ProgrammingLanguageDao {
	
	List <ProgrammingLanguage> languages;
	
	public InMemoryProgrammingLanguageDao() {
		
		languages = new ArrayList<>();
		languages.add(new ProgrammingLanguage(1,"Java"));
		languages.add(new ProgrammingLanguage(2,"Python"));
		languages.add(new ProgrammingLanguage(3,"PhP"));
		languages.add(new ProgrammingLanguage(4,"C#"));
		languages.add(new ProgrammingLanguage(5,"C++"));

	}


	public void add(ProgrammingLanguage programmingLanguage, String name) {
		
		languages.add(new ProgrammingLanguage(languages.size()+1,name));

	}

	@Override
	public ProgrammingLanguage getById(int id) {
		
		return languages.get(id-1);

	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage,int id,String name) {
		
		languages.get(id-1).setName(name);
		
	}


	public void delete(int id) {
		
		languages.remove(id-1);

	}

	@Override
	public List<ProgrammingLanguage> getAll() {

		return languages;
	}


	
	

}
