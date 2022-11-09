package com.swiggy.app.Master;

import java.util.List;

public interface MasterService {
	
	Master saveMaster(Master master);
	
	List<Master> getAllMasters();
	
	Master getMasterById(Long id);
	
	String deleteMasterById(Long id);
}
