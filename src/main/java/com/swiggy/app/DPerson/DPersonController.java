package com.swiggy.app.DPerson;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.app.GResponse.GResponse;

@RestController
@RequestMapping("/api/DPerson")
public class DPersonController {
	@Autowired
	private DPersonService dPersonService;
	@Autowired
	private GResponse gResponse;

	@GetMapping("/all")
	public GResponse findAll() {
		gResponse.setData(dPersonService.getAll());
		return gResponse;
	}

	@GetMapping("/{id}")
	public GResponse getById(@PathVariable Long id) {
		gResponse.setData(dPersonService.getDPersonById(id));
		return gResponse;
	}

	@PostMapping
	public GResponse addDPerson(@Valid @RequestBody DPerson dPerson) {
		gResponse.setData(dPersonService.saveDPerson(dPerson));
		return gResponse;
	}

	@DeleteMapping("/del/{id}")
	public GResponse deletePerson(@PathVariable Long id) {
		gResponse.setData(dPersonService.deletePerson(id));
		return gResponse;
	}

}
