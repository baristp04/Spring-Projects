package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
    void add(ProgrammingLanguage programmingLanguage,String name) throws Exception;
	ProgrammingLanguage getById(int id);
	void update(ProgrammingLanguage programmingLanguage,int id,String name) throws Exception;
	void delete(int id);
	List <ProgrammingLanguage> getAll();

}
