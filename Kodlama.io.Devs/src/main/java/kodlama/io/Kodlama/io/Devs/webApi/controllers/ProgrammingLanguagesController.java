package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.language.CreateLanguagesRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.language.UpdateLanguagesRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.language.GetAllLanguageRespond;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")

public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@PostMapping("/add/{name}") 
	public void add(@RequestBody CreateLanguagesRequest createLanguageRequest,@PathVariable("name")String name) throws Exception{
		programmingLanguageService.add(createLanguageRequest,name);
	}
	@GetMapping("/getbyid/{id}")
	public ProgrammingLanguage getById(@PathVariable("id")int id) {

		return programmingLanguageService.getById(id);

	}
	@PutMapping("/update/{id}/{name}")
	public void update(UpdateLanguagesRequest updateLanguageRequest,@PathVariable("id")int id,@PathVariable("name")String name) throws Exception {
		
		programmingLanguageService.update(updateLanguageRequest,id,name);

	}
	@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
		
		programmingLanguageService.delete(id);

	}
	@GetMapping("/getall")
    public List<GetAllLanguageRespond> getAll() {

		return programmingLanguageService.getAll();

	}
    
    
	
	
	
	
	
	
	
	
	
	
	

}
