package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.language.CreateLanguagesRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.language.UpdateLanguagesRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.language.GetAllLanguageRespond;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
    void add(CreateLanguagesRequest createLanguageRequest,String name) throws Exception;
	ProgrammingLanguage getById(int id);
	void update(UpdateLanguagesRequest updateLanguageRequest,int id,String name) throws Exception;
	void delete(int id);
	List <GetAllLanguageRespond> getAll();

}
