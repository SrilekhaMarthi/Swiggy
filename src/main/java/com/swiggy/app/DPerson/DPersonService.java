package com.swiggy.app.DPerson;

import java.util.List;

public interface DPersonService {

	DPerson saveDPerson(DPerson dPerson);

	List<DPerson> getAll();

	DPerson getDPersonById(Long id);

	String deletePerson(Long id);

}
