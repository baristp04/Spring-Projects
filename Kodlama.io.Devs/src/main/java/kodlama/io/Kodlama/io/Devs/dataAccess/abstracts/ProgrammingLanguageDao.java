package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageDao {
	
	void add(ProgrammingLanguage programmingLanguage,String name);
	ProgrammingLanguage getById(int id);
	void update(ProgrammingLanguage programmingLanguage,int id,String name);
	void delete(int id);
	List <ProgrammingLanguage> getAll();


}
