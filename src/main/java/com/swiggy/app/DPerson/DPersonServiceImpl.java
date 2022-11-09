package com.swiggy.app.DPerson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DPersonServiceImpl implements DPersonService {
	@Autowired
	private DPersonRepository dPersonRepo;

	@Override
	public DPerson saveDPerson(DPerson dPerson) {
		return dPersonRepo.save(dPerson);
	}

	@Override
	public List<DPerson> getAll() {
		return dPersonRepo.findAll();
	}

	@Override
	public DPerson getDPersonById(Long id) {
		return dPersonRepo.findById(id).get();
	}

	@Override
	public String deletePerson(Long id) {
		dPersonRepo.deleteById(id);
		return "deleted successfully!";
	}

}
