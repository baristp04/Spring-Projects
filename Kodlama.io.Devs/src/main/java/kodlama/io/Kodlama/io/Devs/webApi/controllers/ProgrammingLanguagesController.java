package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
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
	public void add(@RequestBody ProgrammingLanguage programmingLanguage,@PathVariable("name")String name) throws Exception{
		programmingLanguageService.add(programmingLanguage,name);
	}
	@GetMapping("/getbyid/{id}")
	public ProgrammingLanguage getById(@PathVariable("id")int id) {

		return programmingLanguageService.getById(id);

	}
	@PutMapping("/update/{id}/{name}")
	public void update( @RequestBody ProgrammingLanguage programmingLanguage,@PathVariable("id")int id,@PathVariable("name")String name) throws Exception {
		
		programmingLanguageService.update(programmingLanguage,id,name);

	}
	@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
		
		programmingLanguageService.delete(id);

	}
	@GetMapping("/getall")
    public List<ProgrammingLanguage> getAll() {

		return programmingLanguageService.getAll();

	}
    
    
	
	
	
	
	
	
	
	
	
	
	

}
