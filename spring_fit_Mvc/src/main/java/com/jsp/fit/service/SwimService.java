package com.jsp.fit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jsp.fit.dao.SwimDao;
import com.jsp.fit.dto.Swim;
@Component
public class SwimService {
	@Autowired
	SwimDao swimDao ;
	
	public Swim saveSwim(Swim swim) {
		return swimDao.saveSwim(swim);
	}

	public boolean deleteSwimById(int id) {
		return swimDao.deleteSwimById(id);

	}

	public Swim updateSwimById(int id, Swim swim) {
		return swimDao.updateSwimById(id, swim);

	}

}
