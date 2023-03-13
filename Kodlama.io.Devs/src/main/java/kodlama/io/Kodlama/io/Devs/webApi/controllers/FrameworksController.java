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

import kodlama.io.Kodlama.io.Devs.business.concretes.FrameworkManager;
import kodlama.io.Kodlama.io.Devs.business.requests.framework.CreateFrameworksRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.framework.UpdateFrameworksRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.framework.GetAllFrameworkRespond;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Framework;

@RestController
@RequestMapping("/api/frameworks")
public class FrameworksController {

	private FrameworkManager frameworkManager;

	@Autowired
	public FrameworksController(FrameworkManager frameworkManager) {
		super();
		this.frameworkManager = frameworkManager;
	}

	@GetMapping("/getall")
	public List<GetAllFrameworkRespond> getAll() {
		return frameworkManager.getAll();
	}

	@GetMapping("/getById/{id}")
	public Framework getById(@PathVariable("id") int id) {
		return frameworkManager.getById(id);
	}

	@PostMapping("/add/{name}")
	public void add(CreateFrameworksRequest createFrameworkRequest, @PathVariable("name") String name) {
		frameworkManager.add(createFrameworkRequest, name);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		frameworkManager.delete(id);
	}

	@PutMapping("/update/{id}/{name}")
	public void update(UpdateFrameworksRequest updateFrameworkRequest, @PathVariable("id") int id,
			@PathVariable("name") String name) {
		frameworkManager.update(updateFrameworkRequest, id, name);
	}

}
