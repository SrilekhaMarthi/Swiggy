package com.swiggy.app.Master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService{
	
	@Autowired
	private MasterRepository masterRepo;

	@Override
	public Master saveMaster(Master master) {
		return masterRepo.save(master);
	}

	@Override
	public List<Master> getAllMasters() {
		return masterRepo.findAll();
	}

	@Override
	public Master getMasterById(Long id) {
		return masterRepo.findById(id).get();
	}

	@Override
	public String deleteMasterById(Long id) {
		masterRepo.deleteById(id);
		return "deleted successfully";
	}

}
